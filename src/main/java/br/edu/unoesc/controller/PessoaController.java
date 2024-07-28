package br.edu.unoesc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.unoesc.modelo.Formacao;
import br.edu.unoesc.modelo.Pessoa;
import br.edu.unoesc.modelo.Time;
import br.edu.unoesc.modelo.enums.Genero;
import br.edu.unoesc.service.FormacaoService;
import br.edu.unoesc.service.PessoaService;
import br.edu.unoesc.service.TimeService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
		
	@Autowired
	private TimeService timeService;
	
	@Autowired
	private FormacaoService formacaoService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Pessoa pessoa, ModelMap model) {
		List<Time> time = timeService.buscarTodos();
		List<Formacao> formacao = formacaoService.buscarTodos();
		model.addAttribute("time", time);
		model.addAttribute("formacao", formacao);
		model.addAttribute("pessoa", pessoa);
		return "/pessoa/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarTodos());
		return "/pessoa/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Pessoa pessoa, RedirectAttributes attr) {
		try {
			pessoaService.salvar(pessoa);
			attr.addFlashAttribute("success", "Cadastro de Pessoa, inserido com sucesso.");
		} catch (DataIntegrityViolationException e) {
			attr.addFlashAttribute("error", "Erro ao salvar o cadastro: " + e.getMessage());
			return "redirect:/pessoa/cadastrar";
		}
		return "redirect:/pessoa/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, ModelMap model) {
		List<Time> time = timeService.buscarTodos();
		List<Formacao> formacao = formacaoService.buscarTodos();
		model.addAttribute("time", time);
		model.addAttribute("formacao", formacao);
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		return "pessoa/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Pessoa pessoa, RedirectAttributes attr) {
		try {
			pessoaService.editar(pessoa);
			attr.addFlashAttribute("sucess", "Cadastro de Pessoa, editado com sucesso!");
		} catch (DataIntegrityViolationException e) {
			attr.addFlashAttribute("error", "Erro ao editar o cadastro: " + e.getMessage());
			return "redirect:/pessoa/cadastrar";
		}	
		return "redirect:/pessoa/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		try {
			pessoaService.excluir(id);
			attr.addFlashAttribute("success", "Cadastro de Pessoa, removido com sucesso!");
		} catch (Exception e) {
			attr.addFlashAttribute("error", "Erro ao excluir o registro: " + e.getMessage());
			return "redirect:/pessoa/listar";	
		}
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
