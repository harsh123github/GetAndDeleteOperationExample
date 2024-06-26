package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employees;
import com.demo.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping ("/getall")
	@ApiOperation(value ="Use to get all Employee List")
	public ResponseEntity<List<Employees>> getAllEmployee() {
		List<Employees> empList= employeeService.getAllEmployees();  
		return ResponseEntity.ok().body(empList);
	}
	
	@GetMapping ("/getemployeebyid/{empId}")
	@ApiOperation(value ="Use to get Employee through their id")
	public ResponseEntity<Optional<Employees>> getEmployeeById (@PathVariable int empId){
		Optional<Employees> employee= employeeService.getEmployeeByid(empId);
		return ResponseEntity.ok().body(employee);
		
	}
	
	
	@GetMapping ("/getempbyname/{empName}")
	@ApiOperation(value ="Use to get Employee through their Name")
	public ResponseEntity<List<Employees>> getEmployeeByName(@PathVariable("empName") String name){
		List<Employees> emp =employeeService.getEmployeeByName(name);
		return ResponseEntity.ok().body(emp);
	}
	
	
	@GetMapping("/getempbysalary/{salary}")
	@ApiOperation(value ="Use to get Employee through their Salary")
	public ResponseEntity<List<Employees>> getEmployeeBySalary (@PathVariable int salary){
		List<Employees> emp1 = employeeService.getEmployeeBySalary(salary);
		return ResponseEntity.ok().body(emp1);
	}
	
	
	@GetMapping("/getempcity/{city}")
	@ApiOperation(value ="Use to get Employee through their City")
	public ResponseEntity<List<Employees>> getEmployeeByCity (@PathVariable String city){
		List<Employees> emp1 = employeeService.getEmployeeByCity(city);
		return ResponseEntity.ok().body(emp1);
	}
	
	
	@GetMapping ("/getempbysalaryandcity/{salary}/{city}")
	@ApiOperation(value ="Use to get Employee through their Salary and city")
	public ResponseEntity<List<Employees>> getEmployeeBySalaryAndCity ( @PathVariable String city,@PathVariable int salary){
		List<Employees> emplist=employeeService.getEmployeeBySalaryAndCity(salary, city);
		return ResponseEntity.ok().body(emplist);
	}

	@GetMapping("/deleteempbyid/{empId}")
	@ApiOperation(value ="Use to delete specific Employee from List th")
	public void deleteEmployeeById(@PathVariable("empId") int id){
	employeeService.deleteEmployeeById(id);	
	}
	
	@GetMapping ("/getempbysalaryandname/{salary}/{city}")
	public ResponseEntity<List<Employees>> findEmployeeBySalaryAndCity (@PathVariable int salary,@PathVariable String city){
		 List<Employees> emplist=  employeeService.findEmployeeBySalaryAndCity(salary, city);
		 return ResponseEntity.ok().body(emplist);
		 }
}