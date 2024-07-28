package br.edu.unoesc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.unoesc.modelo.Time;
import br.edu.unoesc.service.TimeService;

@Controller
@RequestMapping("/time")
public class TimeController {

	@Autowired
	private TimeService timeService;
		
	@GetMapping("/cadastrar")
	public String cadastrar(Time time) {
		return "/time/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("time", timeService.buscarTodos());
		return "/time/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Time time, RedirectAttributes attr) {
		timeService.salvar(time);
		attr.addFlashAttribute("success", "Time inserido com sucesso.");
		return "redirect:/time/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("time", timeService.buscarPorId(id));
		return "time/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Time time, RedirectAttributes attr) {
		timeService.editar(time);
		attr.addFlashAttribute("sucess", "Cadastro de Time, editado com sucesso!");
		return "redirect:/time/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		timeService.excluir(id);
		attr.addFlashAttribute("success", "Cadastro de Time, removido com sucesso!");
		return "redirect:/time/listar";
	}

}
