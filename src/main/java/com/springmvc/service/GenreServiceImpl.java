package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.GenreMapper;
import com.springmvc.model.Genre;
@Service
public class GenreServiceImpl implements GenreService {
	@Autowired
	private GenreMapper genreMapper;

	@Override
	public List<Genre> getGenreList() {
		
		return genreMapper.getGenreList();
	}

}
