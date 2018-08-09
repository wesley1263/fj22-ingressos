package br.com.caelum.ingresso.util;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

public class YearMonthConverter implements Converter<String, YearMonth> {

	@Override
	public YearMonth convert(String validade) {
		
		return YearMonth.parse(validade,DateTimeFormatter.ofPattern("MM/yyyy"));
	}

}
