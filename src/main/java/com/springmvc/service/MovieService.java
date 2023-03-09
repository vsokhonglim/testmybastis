package com.springmvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.model.Movie;

@Service
public interface MovieService {
	/* public List<Movie> getListMovie(); */
	public List<Movie> getListMovie(int pageNum,Date fromDate,Date toDate,String Search);

	public void addMovie(Movie movie);

	public void deleteMovie(int movieId);

	public Movie getMoviebyId(int movieId);

	public void updateMovie(Movie movie);

	public List<Movie> filterMovielist(Date fromDate,Date toDate);

	public int getRowcount(String string,Date fromDate,Date toDate,String Search);
}
