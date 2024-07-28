package br.edu.unoesc.service.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.edu.unoesc.modelo.Time;
import br.edu.unoesc.service.TimeService;

@Component
public class StringToTimeConverter implements Converter<String, Time>{

	@Autowired
	private TimeService service;
	
	@Override
	public Time convert(String source) {
		if (source.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(source);
		return service.buscarPorId(id);
	}
	

}
