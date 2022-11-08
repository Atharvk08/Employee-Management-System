package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springproject1.springserver.model.Employee;
import com.springproject1.springserver.model.EmployeeDao;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping("/employee/get-all")
	public ArrayList<Employee> getAllEmployees(){
		System.out.println(employeeDao.findAllEmployees());
		return employeeDao.findAllEmployees();
	}
	
	@GetMapping("/employee/get")
	public String getEmployee(@RequestBody String s) {
		int i=Integer.parseInt(s);
		return employeeDao.findAllEmployees().get(i).toString();
	}
	@PostMapping("/employee/save")
	public Employee save(@RequestBody Employee employee) {
		return employeeDao.save(employee);		
	}
	
	
}
