package com.springproject1.springserver.model;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import antlr.collections.List;
@Service
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Employee save(Employee employee) {
		return repository.save(employee);
	}
	
	public void delete(Employee employee) {
		repository.delete(employee);
	}
	public ArrayList<Employee> findAllEmployees() {
		
		ArrayList<Employee> employeesList=new ArrayList<>();
		Streamable.of(repository.findAll())
		.forEach(employee ->{
			employeesList.add(employee);
		});
		return employeesList;
	}
	
}
