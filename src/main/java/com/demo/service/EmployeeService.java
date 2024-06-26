package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Employees;
import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employees> getAllEmployees (){
		List<Employees> empList = employeeRepository.findAll(); 
		return empList;
	}
	
	
	public Optional<Employees> getEmployeeByid(int id) {
		   return employeeRepository.findById(id);
		 
	}
	
	public List<Employees> getEmployeeByName (String name){
		return employeeRepository.getEmployeesByempName(name);
	}
	
	public List<Employees> getEmployeeBySalary (int salary){
		return employeeRepository.getEmployeeBySalary(salary);
	}
	
	public List<Employees> getEmployeeByCity (String city){
		return employeeRepository.getEmployeeByCity(city);
	}
	
	public List<Employees> getEmployeeBySalaryAndCity (int salary,String city){
		return employeeRepository.getEmployeeBySalaryAndCity(salary, city);
	}
	
	public void deleteEmployeeById (int id) {
		employeeRepository.deleteById(id);
	}
	
	public List<Employees> findEmployeeBySalaryAndCity(int salary,String city){
		return employeeRepository.findEmployeeBySalaryAndCity(salary, city);
	}
}
