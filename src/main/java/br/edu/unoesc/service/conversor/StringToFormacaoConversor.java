package br.edu.unoesc.service.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.edu.unoesc.modelo.Formacao;
import br.edu.unoesc.service.FormacaoService;

@Component
public class StringToFormacaoConversor implements Converter<String, Formacao>{

	@Autowired
	private FormacaoService service;
	
	@Override
	public Formacao convert(String source) {
		if (source.isEmpty()) {
			return null;	
		}
		Long id = Long.valueOf(source);
		return service.buscarPorId(id);
	}


}
