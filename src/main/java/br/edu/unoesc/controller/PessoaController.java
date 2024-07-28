package br.edu.unoesc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String listar(ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarTodos());
		return "/pessoa/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Pessoa pessoa, RedirectAttributes attr) {
		pessoaService.salvar(pessoa);
		attr.addFlashAttribute("success", "Cadastro de Pessoa, inserido com sucesso.");
		return "redirect:/pessoa/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		return "pessoa/cadastrar";
	}
	
	@GetMapping("/editar")
	public String editar(Pessoa pessoa, RedirectAttributes attr) {
		pessoaService.editar(pessoa);
		attr.addFlashAttribute("sucess", "Cadastro de Pessoa, editado com sucesso!");
		return "redirect:/pessoa/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		pessoaService.excluir(id);
		attr.addFlashAttribute("success", "Cadastro de Pessoa, removido com sucesso!");
		return "redirect:/pessoa/listar";
	}
	
	@GetMapping("/buscar/nome")
	public String getBuscarNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarPorNome(nome));
		return "/pessoa/lista";
	}
	
	@ModelAttribute("genero")
	public Genero [] getGenero() {
		return Genero.values();
	}
	
}
