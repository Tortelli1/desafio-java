package br.edu.unoesc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.unoesc.modelo.Pessoa;
import br.edu.unoesc.modelo.Time;
import br.edu.unoesc.service.TimeService;

@Controller
@RequestMapping("/time")
public class TimeController {

	private TimeService timeService;
		
	@GetMapping("/cadastrar")
	public String cadastrar(Pessoa pessoa) {
		return "/time/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/time/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Time time, RedirectAttributes attr) {
		timeService.salvar(time);
		attr.addFlashAttribute("success", "Time inserido com sucesso.");
		return "redirect:/time/cadastrar";
	}

}
