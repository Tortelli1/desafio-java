package br.edu.unoesc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String cadastrar(Formacao formacao, Model model) {
		model.addAttribute("formacao", new Formacao());
		model.addAttribute("nivelFormacao", NivelFormacao.values());
		return "/formacao/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("formacao", formacaoService.buscarTodos());
		return "/formacao/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Formacao formacao, RedirectAttributes attr) {
		formacaoService.salvar(formacao);
		attr.addFlashAttribute("success", "Formação  inserido com sucesso.");
		return "redirect:/formacao/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("formacao", formacaoService.buscarPorId(id));
		model.addAttribute("nivelFormacao", NivelFormacao.values());
		return "formacao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Formacao formacao, RedirectAttributes attr) {
		formacaoService.editar(formacao);
		attr.addFlashAttribute("success", "Cadastro de Formacação, editado com sucesso!");
		return "redirect:/formacao/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		formacaoService.excluir(id);
		attr.addFlashAttribute("success", "Cadastro de Formação, removido com sucesso!");
		return "redirect:/formacao/listar";
	}
	
	
}
