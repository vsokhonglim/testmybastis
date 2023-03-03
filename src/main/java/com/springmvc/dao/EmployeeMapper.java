package com.springmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Employees;
import com.springmvc.utils.MyBatisUtil;

@Repository
public class EmployeeMapper {

	@Transactional
	public List<Employees> getAllEmployees() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Employees> employeesList = session.selectList("getAllEmployees");
		return employeesList;
	}

}
