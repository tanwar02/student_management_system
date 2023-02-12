package com.sagar.student_management_system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.student_management_system.bean.Student;
import com.sagar.student_management_system.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	public StudentController() {
		
		System.out.println("Object is created");
	}
	
	@GetMapping()
	public List<Student> getStudents(){
		
		return service.getStudents();
	}
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable String id) {
		
		return service.getStudent(id);
	}
	
	@PostMapping()
	public String addStudent(@RequestBody Student student) {
		
		return service.addStudent(student);
	}
	
	@PutMapping()
	public String updateStudent(@RequestBody Student student) {
		
		return service.updateStudent(student);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable String id) {
		
		return service.deleteStudent(id);
	}
}
