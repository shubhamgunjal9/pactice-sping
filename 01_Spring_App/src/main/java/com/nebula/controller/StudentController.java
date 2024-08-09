package com.nebula.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nebula.entity.Student;

@RestController
public class StudentController {

	@GetMapping("/studentinfo")
	public ResponseEntity<Student> getStudent() {
		Student student = new Student();
		student.setId(1);
		student.setName("lord yuvraj");
		student.setCources(new String[]{"java","collection","spring","spring boot"});
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
}
