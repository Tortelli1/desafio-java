package br.edu.unoesc.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import br.edu.unoesc.modelo.Pessoa;
import br.edu.unoesc.service.PessoaService;

@Controller
public class ApiController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/quadro")
	public String getFatosAleatorios(Model model) {
		List<Pessoa> pessoas = pessoaService.buscarTodos();
		
		if (pessoas.isEmpty()) {
            model.addAttribute("mensagemErro", "Nenhuma pessoa encontrada");
            return "erro";
        }

		List<PessoaFato> pessoaFato = new ArrayList<>();
		String uri = "https://uselessfacts.jsph.pl/api/v2/facts/random";
		RestTemplate restTemplate = new RestTemplate();
		
		for (Pessoa pessoa : pessoas) {
            FatosAleatoriosRetorno result = restTemplate.getForObject(uri, FatosAleatoriosRetorno.class);
            pessoaFato.add(new PessoaFato(pessoa.getNome(), result.getText()));
        }
	
		 model.addAttribute("pessoaFato", pessoaFato);
	     return "quadro";
	}
	
		public static class FatosAleatoriosRetorno {
			
			private String text;
			
			public String getText() {
				return text;
			}
			
			@SuppressWarnings("unused")
			public void setText(String text) {
				this.text = text;
			}
		}
	
		private static class PessoaFato {
	        private String nome;
	        private String fatoAleatorio;
	
	        public PessoaFato(String nome, String fatoAleatorio) {
	            this.nome = nome;
	            this.fatoAleatorio = fatoAleatorio;
	        }
	
	        @SuppressWarnings("unused")
			public String getNome() {
	            return nome;
	        }
	
	        @SuppressWarnings("unused")
			public String getFatoAleatorio() {
	            return fatoAleatorio;
	        }
	
		}

}
