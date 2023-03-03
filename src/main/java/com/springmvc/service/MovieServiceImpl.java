package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.MovieMapper;
import com.springmvc.model.Movie;
@Service
public class MovieServiceImpl implements MovieService {

	
	@Autowired
	private MovieMapper movieMapper;
	@Override
	public List<Movie> getListMovie() {
		
		return movieMapper.getListMovie();
	}
	@Override
	public void addMovie(Movie movie) {
		
		movieMapper.addMovie(movie);
		
	}

	
	
	

}
