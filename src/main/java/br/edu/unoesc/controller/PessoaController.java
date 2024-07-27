package br.edu.unoesc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.unoesc.modelo.Pessoa;
import br.edu.unoesc.modelo.enums.Genero;
import br.edu.unoesc.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
		
	@GetMapping("/cadastrar")
	public String cadastrar(Pessoa pessoa) {
		return "/pessoa/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/pessoa/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Pessoa pessoa, RedirectAttributes attr) {
		pessoaService.salvar(pessoa);
		attr.addFlashAttribute("success", "Funcionário inserido com sucesso.");
		return "redirect:/pessoa/cadastrar";
	}
	
	@ModelAttribute("genero")
	public Genero [] getGenero() {
		return Genero.values();
	}
	
}
