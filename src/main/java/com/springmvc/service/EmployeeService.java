package com.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.model.Employees;

@Service
public interface EmployeeService {
	public List<Employees> getAllEmployees();
}
