package com.sagar.student_management_system.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.student_management_system.bean.Faculty;
import com.sagar.student_management_system.bean.Login;
import com.sagar.student_management_system.bean.Student;
import com.sagar.student_management_system.repository.FacultyRepository;
import com.sagar.student_management_system.repository.StudentRepository;

@RestController
public class LoginController {
	
	@Autowired
	StudentRepository stu;
	
	@Autowired
	FacultyRepository fac;
	
	@PostMapping("/login")
	public Object login(@RequestBody Login login) {
		
		if(login.getType().equals("student")) {
			
			Student student;
			try {
				student = stu.findById(login.getId()).get();
			}
			catch(NoSuchElementException ex) {
				return "Your id is wrong";
			}
			if(!login.getPassword().equals(student.getPassword())) return "Your Password is wrong";
			return student;
		}
        if(login.getType().equals("faculty")) {
			
			Faculty faculty;
			try {
				faculty = fac.findById(login.getId()).get();
			}
			catch(NoSuchElementException ex) {
				return "Your id is wrong";
			}
			if(!login.getPassword().equals(faculty.getPassword())) return "Your Password is wrong";
			return faculty;
		}
        if(!login.getId().equals("sagar")) return "Your Id is wrong";
        if(!login.getPassword().equals("tanwar")) return "Your Password is wrong";
		return "";
	}
}