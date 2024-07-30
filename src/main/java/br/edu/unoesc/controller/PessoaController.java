package br.edu.unoesc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.unoesc.modelo.Formacao;
import br.edu.unoesc.modelo.Pessoa;
import br.edu.unoesc.modelo.Time;
import br.edu.unoesc.modelo.enums.Genero;
import br.edu.unoesc.service.FormacaoService;
import br.edu.unoesc.service.PessoaService;
import br.edu.unoesc.service.TimeService;
import br.edu.unoesc.service.validator.ValidadorCpf.CpfValidator;

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
		if (!CpfValidator.isValid(pessoa.getCpfFormatado())) {
	        attr.addFlashAttribute("error", "CPF inválido.");
	        return "redirect:/pessoa/cadastrar";
	    }

	    pessoaService.salvar(pessoa);
	    attr.addFlashAttribute("success", "Cadastro de Pessoa inserido com sucesso.");
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
		if (!CpfValidator.isValid(pessoa.getCpfFormatado())) {
	        attr.addFlashAttribute("error", "CPF inválido.");
	        return "redirect:/pessoa/cadastrar";
	    }

	    pessoaService.editar(pessoa);
	    attr.addFlashAttribute("success", "Cadastro de Pessoa editado com sucesso!");
	    return "redirect:/pessoa/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		pessoaService.excluir(id);
		attr.addFlashAttribute("success", "Cadastro de Pessoa removido com sucesso!");
		return "redirect:/pessoa/listar";
	}
	
	@ModelAttribute("genero")
	public Genero [] getGenero() {
		return Genero.values();
	}
	
}
