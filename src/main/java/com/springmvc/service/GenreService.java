package com.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.model.Genre;

@Service
public interface GenreService {
 public List<Genre> getGenreList();
}
