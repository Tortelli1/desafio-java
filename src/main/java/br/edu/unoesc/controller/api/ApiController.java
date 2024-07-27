package br.edu.unoesc.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ApiController {

	@GetMapping("/fatosAleatorios")
	private String getFatosAleatorios() {
		String uri = "https://uselessfacts.jsph.pl/api/v2/facts/random";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
}
