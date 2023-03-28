package br.com.desafio.controller;

import javax.servlet.http.HttpServletRequest;

import br.com.desafio.model.Membros;
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
	@RequestMapping(value = "/delete-projetos", method = RequestMethod.GET)
	public String deleteProjetos(@RequestParam Long id) {
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

	/*
	@PostMapping(path = "/save/{id}", consumes = "application/json")
	public String test(@RequestBody Projetos projetos) {
		return projetos.toString();
	}*/

	@PostMapping(path = "/save/{id}", consumes = "application/x-www-form-urlencoded")
	public String initSave(Projetos projetos) {
		return update(projetos.getId(), projetos);
	}

	/*
	@RequestMapping(value = "/save/{id}", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Projetos> findById(@PathVariable("id") Long id, @RequestBody Projetos projetos) {
		return projetosService.getProjetosById(id)
				.map( r -> ResponseEntity.ok().body(r))
				.orElse(ResponseEntity.notFound().build());
	}*/

	@RequestMapping(value = "/save/{id}", method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String update(@PathVariable("id") Long id, @RequestBody Projetos projetos){
		projetosService.getProjetosById(id)
				.map(r -> {
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
			return "add-projetos";
		}else {
			Long lastId = Long.valueOf(projetosService.getProjetosList().size()+1);
			projetos.setId(lastId.longValue());
			projetos.setIdGerente(Cargo.GERENTE.getCargo());
			Projetos proj1 = projetosService.saveProjetos(projetos);

			Membros membros = new Membros();
			//membrosService.getMembrosById(Cargo.GERENTE.getCargo());
			Long p = Long.valueOf(projetosService.getProjetosList().size()+1);
			membros.setProjetosId(proj1);
			membros.setPessoaId(pessoaService.getPessoaById(Cargo.FUNCIONARIO.getCargo()).get());
			Long lastMembros = Long.valueOf(membrosService.getMembrosList().size()+1);
			membros.setId(lastMembros);
			membrosService.saveMembros(membros);

			return "redirect:/list-projetos";

			/*
			Long lastId = Long.valueOf(projetosService.getProjetosList().size());
			projetos.setId(lastId+1);

			projetos.setIdGerente(Cargo.GERENTE.getCargo());
			projetosService.saveNewProjeto(projetos);

			Membros membros = new Membros();
			membrosService.getMembrosById(Cargo.GERENTE.getCargo());
			membros.setProjetosId(projetos);
			membros.setPessoaId(pessoaService.getPessoaById(Cargo.FUNCIONARIO.getCargo()).get());
			membrosService.saveMembros(membros);

			return "redirect:/list-projetos";
			 */
		}
	}

	@RequestMapping(value = "/list-pessoa", method = RequestMethod.GET)
	public String showPessoa(ModelMap model) {
		model.put("pessoa", pessoaService.getPessoaList());
		return "pessoa";
	}
}
