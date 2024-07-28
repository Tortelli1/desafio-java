package br.edu.unoesc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.unoesc.modelo.Formacao;
import br.edu.unoesc.modelo.enums.NivelFormacao;
import br.edu.unoesc.service.FormacaoService;

@Controller
@RequestMapping("/formacao")
public class FormacaoController {

	@Autowired
	private FormacaoService formacaoService;
		
	@GetMapping("/cadastrar")
	public String cadastrar(Formacao formacao) {
		return "/formacao/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/formacao/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Formacao formacao, RedirectAttributes attr) {
		formacaoService.salvar(formacao);
		attr.addFlashAttribute("success", "Formação  inserido com sucesso.");
		return "redirect:/formacao/cadastrar";
	}

	public NivelFormacao [] getNivelFormacao(){
		return NivelFormacao.values();
	}
}
