package com.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.model.Movie;

@Service
public interface MovieService {
	public List<Movie> getListMovie();

	public void addMovie(Movie movie);
}
