package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("/")
	public String getMovielist(Model model) {
		model.addAttribute("Movielist", movieService.getListMovie());
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

}
