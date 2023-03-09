package com.springmvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Genre;
import com.springmvc.utils.MyBatisUtil;
@Repository
public class GenreMapper {
	public List<Genre> getGenreList() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Genre> genre = session.selectList("getGenreList");
		return genre;
		
	}
}
