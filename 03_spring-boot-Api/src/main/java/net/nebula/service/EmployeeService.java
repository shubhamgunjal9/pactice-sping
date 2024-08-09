package net.nebula.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.nebula.entity.Employee;

@Service
public class EmployeeService {
	
	public static List<Employee> list = new ArrayList<>();
	
	public void save(Employee employee) {
		System.out.println("implemented save operation");
		System.out.println(employee);
		list.add(employee);
	}
	
	public List<Employee> getAll() {
		return list;
	}
	
	public void delete(String name) {
		int count = 0;
		for(Employee emp : list) {
			if(emp.getName().equals(name)) {
				list.remove(count);
			}
			count++;
		}
	}
	
	public Employee getByid(int id) {
		for(Employee employee : list) {
			if(employee.getId() == id) {
				return employee;
			}
		} return new Employee();
	}
	
	
	public void update(Employee employee) {
		int count = 0;
		for(Employee emp : list) {
			if(emp.getId()==employee.getId()) {
				list.set(count,employee);
			}
			count++;
		}
	}
	

}
