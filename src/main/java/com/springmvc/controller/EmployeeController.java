package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/emp")
	public String index(Model model) {
		model.addAttribute("Employees", employeeService.getAllEmployees());
		System.out.println(employeeService.getAllEmployees());
		return "employee";
	}
}
