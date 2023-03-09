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

	
	
	/*
	 * public List<Movie> getListMovie(){ SqlSession session =
	 * MyBatisUtil.getSqlSessionFactory().openSession(); List<Movie> movieList =
	 * session.selectList("getListMovie"); session.commit(); session.close(); return
	 * movieList;
	 * 
	 * }
	 */
	public List<Movie> getListMovie(int pageNum,Date fromDate,Date toDate,String Search) {
		int offSet = (pageNum-1) *10;
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		String str = Search;
        String[] arrOfStr = str.split(" ");
        StringBuilder sb1 = new 
                StringBuilder("");
  
        for (String a : arrOfStr) {
        	sb1.append("%"+a);
            
        }
        
		Map filterMap = new HashMap();
		filterMap.put("offset", offSet);
		filterMap.put("fromdate", fromDate);
		filterMap.put("todate", toDate);
		filterMap.put("search", sb1.toString()+"%");
		List<Movie> movieList = session.selectList("getListMovie",filterMap);
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


	public int getRowcount(String tblName,Date fromDate,Date toDate,String Search) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		String str = Search;
        String[] arrOfStr = str.split(" ");
        StringBuilder sb1 = new 
                StringBuilder("");
  
        for (String a : arrOfStr) {
        	sb1.append("%"+a);
            
        }
        
		Map filterMap = new HashMap();
		filterMap.put("fromdate", fromDate);
		filterMap.put("todate", toDate);
		filterMap.put("tblName", tblName);
		filterMap.put("search", sb1.toString()+"%");
		int rowCount = session.selectOne("getRowcount", filterMap);
		session.commit();
		session.close();
		return rowCount;
	}


	
}
