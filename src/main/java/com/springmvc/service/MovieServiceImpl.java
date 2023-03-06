package com.springmvc.service;

import java.util.Date;
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

	@Override
	public void deleteMovie(int movieId) {
		movieMapper.deleteMovie(movieId);

	}

	@Override
	public Movie getMoviebyId(int movieId) {

		return movieMapper.getMoviebyId(movieId);
	}

	@Override
	public void updateMovie(Movie movie) {
		movieMapper.updateMovie(movie);

	}

	@Override
	public List<Movie> filterMovielist(Date fromDate,Date toDate) {
		
		return movieMapper.filterMovielist(fromDate,toDate);
	}

}
