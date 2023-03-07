package com.springmvc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.Movie;
import com.springmvc.service.MovieService;

@Controller
public class MoviesController {
	@Autowired
	private MovieService movieService;

	/*
	 * @RequestMapping("/") public String getMovielist(Model model) {
	 * model.addAttribute("Movielist", movieService.getListMovie());
	 * model.addAttribute("rowcount",movieService.getRowcount("movie")); return
	 * "movie";
	 * 
	 * }
	 */
	@RequestMapping("/")
	public String getMovielist(Model model,
								@RequestParam(value = "page", defaultValue = "1", required = false) int pageNum,
								@RequestParam(value="fromdate",defaultValue = "1900-01-01")@DateTimeFormat(pattern = "yyyy-MM-dd")Date fromDate,
								@RequestParam(value="todate",defaultValue = "2100-01-01")@DateTimeFormat(pattern = "yyyy-MM-dd")Date toDate) {
		model.addAttribute("Movielist", movieService.getListMovie(pageNum,fromDate,toDate));
		model.addAttribute("rowcount",movieService.getRowcount("movie",fromDate,toDate));
		return "movie";

	}

	@GetMapping("/addmovie")
	public String addMovie(Model model) {
		Movie newMovie = new Movie();
		model.addAttribute("newmovie", newMovie);
		return "addmovie";
	}

	@RequestMapping("/addNewMovie")
	public String addNewMovie(@ModelAttribute("newmovie") Movie movie) {
		
		if (movie.getId() == 0) {
			movieService.addMovie(movie);
		} else {
			movieService.updateMovie(movie);
		}

		return "redirect:/";
	}

	@RequestMapping("/deletemovie")
	public String deleteEmployee(@RequestParam("movieid") int movieId) {

		movieService.deleteMovie(movieId);
		return "redirect:/";
	}

	@RequestMapping("/updatemovie")
	public String updateMovie(@RequestParam("movieid") int movieId, Model model) {

		model.addAttribute("newmovie", movieService.getMoviebyId(movieId));
		return "addmovie";
	}
	
	@RequestMapping("/filter")
	public String filterMovielist(@RequestParam(value="fromdate")@DateTimeFormat(pattern = "yyyy-MM-dd")Date fromDate, @RequestParam(value="todate")@DateTimeFormat(pattern = "yyyy-MM-dd")Date toDate,Model model) {
		
		model.addAttribute("Movielist", movieService.filterMovielist(fromDate,toDate));
	
		return "movie";

	}

}
