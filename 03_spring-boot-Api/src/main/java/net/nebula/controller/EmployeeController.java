package net.nebula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import net.nebula.entity.Employee;
import net.nebula.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employee")
	public ResponseEntity<String> save(@RequestBody Employee employee) {
		service.save(employee);
		return new ResponseEntity<>("saved",HttpStatus.OK);
	}
	
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> get() {
		return new ResponseEntity<> (
				service.getAll(),HttpStatus.OK
				);
				
	}
	
	@DeleteMapping("/employee")
	public ResponseEntity<String> delete(@RequestParam("emp") String empName) {
		service.delete(empName);
		return new ResponseEntity<>("deleted",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getByid(@PathVariable("id") int id) {
		return new ResponseEntity<>(
				service.getByid(id),
				HttpStatus.ACCEPTED
			);
				
	}
	
	@PutMapping("/employee") 
	public ResponseEntity<List<Employee>> update(@RequestBody Employee employee) {
		
		service.update(employee);
		
		return new ResponseEntity<>(service.getAll(),HttpStatus.ACCEPTED);
	}

}
