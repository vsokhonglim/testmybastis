package com.springmvc.formatter;

import org.springframework.core.convert.converter.Converter;


import com.springmvc.model.Genre;

public class GenreListFormatter implements Converter<String, Genre> {



	@Override
	public Genre convert(String source) {
		String[] data = source.split(",");
		return new Genre(
				);
	}

}
