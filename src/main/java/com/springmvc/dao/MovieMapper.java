package com.springmvc.dao;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Movie;
import com.springmvc.utils.MyBatisUtil;

@Repository
public class MovieMapper {

	
	
	public List<Movie> getListMovie(){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Movie> movieList = session.selectList("getListMovie");
		session.commit();
		session.close();
		return movieList;
		
	}

	
	public void addMovie(Movie movie){
		
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("addmovie",movie);
		session.commit();
		session.close();
		
	}
	
	public void deleteMovie(int movieId){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("deletemovie", movieId);
		
		session.commit();
		session.close();
	}


	public Movie getMoviebyId(int movieId) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Movie movieList = (Movie)session.selectOne("getMoviebyId",movieId);
		session.commit();
		session.close();
		return movieList;
	}


	public void updateMovie(Movie movie) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("updatemovie", movie);
		session.commit();
		session.close();
		
	}


	


	public List<Movie> filterMovielist(Date fromDate,Date toDate) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		 Map<String, Date> filterDate = new HashMap<String, Date>();

		 filterDate.put("fromdate", fromDate);
		 filterDate.put("todate", toDate);
		
		List<Movie> movieList = session.selectList("filterMovielist",filterDate);
		session.commit();
		session.close();
		return movieList;
	}
}
