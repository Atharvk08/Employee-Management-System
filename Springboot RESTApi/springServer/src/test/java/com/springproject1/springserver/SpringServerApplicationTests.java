package com.springproject1.springserver;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springproject1.springserver.model.Employee;
import com.springproject1.springserver.model.EmployeeDao;

import antlr.collections.List;

@SpringBootTest
class SpringServerApplicationTests {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Test
	void addEmployee() {
		Employee employee=new Employee();
		employee.setName("Rachel Wayne");
		employee.setBranch("Consult");
		employee.setLocation("USA");
		employeeDao.save(employee);
	}
	
//	@Test
	void getAllEmployees() {
		ArrayList<Employee> empList=employeeDao.findAllEmployees();
		System.out.println(empList);
	}
	
//	@Test
	void getAllEmployeesAndDeleteThem() {
		ArrayList<Employee> employees=employeeDao.findAllEmployees();
		for(Employee e: employees) {
			employeeDao.delete(e);
		}
	} 

}
