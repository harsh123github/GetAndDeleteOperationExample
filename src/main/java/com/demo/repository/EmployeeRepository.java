package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

public List<Employees> getEmployeesByempName (String empName);

@Query (value="select * from employee where salary>?1 ", nativeQuery =true)
public List<Employees> getEmployeeBySalary (int salary);

public List<Employees> getEmployeeByCity (String city);

public List<Employees> getEmployeeBySalaryAndCity (int salary,String city);

@Query(value="select * from employee e where salary>?1 and city=?2" , nativeQuery=true)
public List<Employees> findEmployeeBySalaryAndCity (int salary,String city);


}
