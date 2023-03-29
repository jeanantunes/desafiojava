package br.com.desafio.controller;

import javax.servlet.http.HttpServletRequest;

import br.com.desafio.model.Membros;
import br.com.desafio.model.Pessoa;
import br.com.desafio.model.Projetos;
import br.com.desafio.service.IMembrosService;
import br.com.desafio.service.IPessoaService;
import br.com.desafio.service.IProjetosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class IndexController {

    @Autowired
    private IProjetosService projetosService;

    @Autowired
    private IPessoaService pessoaService;

    @Autowired
    private IMembrosService membrosService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @GetMapping("/")
    public String home(Model model, HttpServletRequest httpServletRequest) {
        return "index";
    }

    @RequestMapping(value = "/list-projetos", method = RequestMethod.GET)
    public String showProjetos(ModelMap model) {
        model.put("projetos", projetosService.getProjetosList());
        return "projetos";
    }

    @RequestMapping(value = "/delete-projetos/{id}", method = RequestMethod.GET)
    public String deleteProjetos(@PathVariable("id") Long id) {
        //Membros m = membrosService.getMembrosList().get(membrosService.getMembrosList().size()-1);
        membrosService.deleteMembros(id + 1);
        projetosService.deleteProjetos(id);
        return "redirect:/list-projetos";
    }

    @RequestMapping(value = "/update-projetos/{id}", method = RequestMethod.GET)
    public String showUpdateProjetosPage(@PathVariable("id") Long id, ModelMap model) {
        Projetos projetos = projetosService.getProjetosById(id).get();
        model.put("nome", projetos.getNome());
        model.put("dataInicio", projetos.getDataInicio());
        model.put("dataPrevisaoFim", projetos.getDataPrevisaoFim());
        model.put("dataFim", projetos.getDataFim());
        model.put("descricao", projetos.getDescricao());
        model.put("status", projetos.getStatus());
        model.put("orcamento", projetos.getOrcamento());
        model.put("risco", projetos.getRisco());

        return "update-projetos";
    }

    @PostMapping(path = "/save/{id}", consumes = "application/x-www-form-urlencoded")
    public String initSave(Projetos projetos) {
        return update(projetos.getId(), projetos);
    }

    @RequestMapping(value = "/save/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String update(@PathVariable("id") Long id, @RequestBody Projetos projetos) {
        projetosService.getProjetosById(id).map(r -> {
            r.setNome(projetos.getNome());
            r.setDataInicio(projetos.getDataInicio());
            r.setDataPrevisaoFim(projetos.getDataPrevisaoFim());
            r.setDataFim(projetos.getDataFim());
            r.setDescricao(projetos.getDescricao());
            r.setOrcamento(projetos.getOrcamento());
            r.setStatus(projetos.getStatus());
            r.setRisco(projetos.getRisco());
            Projetos m = projetosService.saveProjetos(r);
            return ResponseEntity.ok().body(m);
        }).orElse(ResponseEntity.notFound().build());
        return "redirect:/list-projetos";
    }

    @PostMapping(path = "/add-projetos", consumes = "application/x-www-form-urlencoded")
    public String addProjetos(Projetos projetos, BindingResult result) {

        if (result.hasErrors()) {
            return "index";
        } else if (projetos.getNome() == null) {
            if(pessoaService.getPessoaList().isEmpty()){
                ModelMap m = new ModelMap();
                m.addAttribute("alerta", "Necessário salvar um funcionário, primeiro.");
                return redirect(m);
            }
            return "add-projetos";
        } else {
            Long lastId = Long.valueOf(projetosService.getProjetosList().size());
            if (lastId != 0) {
                Projetos projId = projetosService.getProjetosList().get(projetosService.getProjetosList().size() - 1);
                projetos.setId(projId.getId() + 1);
            } else {
                projetos.setId(lastId.longValue());
            }
            projetos.setIdGerente(Cargo.GERENTE.getCargo());
            projetosService.saveProjetos(projetos);

            Membros membros = new Membros();
            Long lastMemId = Long.valueOf(membrosService.getMembrosList().size());
            if (lastMemId != 0) {
                Membros memId = membrosService.getMembrosList().get(membrosService.getMembrosList().size() - 1);
                membros.setId(memId.getId() + 1);
            } else {
                membros.setId(lastMemId.longValue());
            }

            Projetos projetosList = projetosService.getProjetosList().get(projetosService.getProjetosList().size() - 1);
            membros.setProjetosId(projetosList);
            //FIXME: Necessário ter Pessoa cadastrada com atribuição funcionário=true
            if(!pessoaService.getPessoaList().isEmpty()){
                membros.setPessoaId(pessoaService.getPessoaById(Cargo.FUNCIONARIO.getCargo()).get());
            }else{
                ModelMap m = new ModelMap();
                m.addAttribute("alerta", "Necessário salvar uma pessoa com atribudo funcionário = true");
                return "redirect:/";
            }

            membrosService.saveMembros(membros);

            return "redirect:/list-projetos";

        }
    }

    @RequestMapping(value = "/list-pessoa", method = RequestMethod.GET)
    public String showPessoa(ModelMap model) {
        model.put("pessoa", pessoaService.getPessoaList());
        return "pessoa";
    }

    @RequestMapping(value = "/delete-pessoa/{id}", method = RequestMethod.GET)
    public String deletePessoa(@PathVariable("id") Long id) {
        pessoaService.deletePessoa(id);
        return "redirect:/list-pessoa";
    }

    @PostMapping(path = "/add-pessoa", consumes = "application/x-www-form-urlencoded")
    public String addPessoa(Pessoa pessoa, BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/index";
        } else if (pessoa.getNome() == null) {
            return "add-pessoa";
        } else {
            Long lastPessoaId = Long.valueOf(pessoaService.getPessoaList().size());
            if (lastPessoaId != 0) {
                Pessoa pessoaId = pessoaService.getPessoaList().get(pessoaService.getPessoaList().size() - 1);
                pessoa.setId(pessoaId.getId() + 1);
            } else {
                pessoa.setId(lastPessoaId.longValue());
            }
            pessoa.setNome(pessoa.getNome());
            pessoa.setDataNascimento(pessoa.getDataNascimento());
            pessoa.setCpf(pessoa.getCpf());
            pessoa.setPessoaCol(String.valueOf(pessoa.getId()));
            pessoaService.savePessoa(pessoa);

            return "redirect:/list-pessoa";

        }
    }

    @GetMapping("/redirect")
    public String redirect(ModelMap model) {
        String aux = "Necessário salvar um funcionário, primeiro.";
        model.put("alerta", aux);
        return "redirect:/list-pessoa";
    }
}
