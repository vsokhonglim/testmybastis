package com.springmvc.dao;


import java.util.List;


import javax.transaction.Transactional;

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
}
