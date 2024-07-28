package br.edu.unoesc.service.conversor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.springframework.core.convert.converter.Converter;

public class StringToLocalDateConversor implements Converter<String, LocalDate>{

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate convert(String source) {
        try {
            return LocalDate.parse(source, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data inválido: " + source, e);
        }
    }

}
