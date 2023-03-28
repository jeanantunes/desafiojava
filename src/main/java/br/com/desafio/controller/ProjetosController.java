package br.com.desafio.controller;

import br.com.desafio.model.Projetos;
import br.com.desafio.service.IProjetosService;
import br.com.desafio.service.ProjetosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ProjetosController {

	@Autowired
	private IProjetosService projetosService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	/*
	@RequestMapping(value = "/list-projetos", method = RequestMethod.GET)
	public String showProjetos(ModelMap model) {
		model.put("projetos", projetosService.getProjetosList());
		return "list-projetos";
	}*/

	/*
	@RequestMapping(value = "/add-projetos", method = RequestMethod.GET)
	public String showAddProjetosPage(ModelMap model) {
		model.addAttribute("projetos", new Projetos());
		return "projetos";
	}*/

	/*
	@RequestMapping(value = "/delete-projetos", method = RequestMethod.GET)
	public String deleteProjetos(@RequestParam long id) {
		projetosService.deleteProjetos(id);
		return "redirect:/list-projetos";
	}*/

	/*
	@RequestMapping(value = "/update-projetos", method = RequestMethod.GET)
	public String showUpdateProjetosPage(@RequestParam long id, ModelMap model) {
		Projetos projetos = projetosService.getProjetosById(id).get();
		model.put("projetos", projetos);
		return "projetos";
	}*/

	/*
	@RequestMapping(value = "/add-projetos", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Projetos projetos, BindingResult result) {

		if (result.hasErrors()) {
			return "projetos";
		}

		projetos.setNome(String.valueOf((model.getAttribute("nome"))));
		projetosService.saveProjetos(projetos);
		return "redirect:/list-projetos";
	}*/
}
