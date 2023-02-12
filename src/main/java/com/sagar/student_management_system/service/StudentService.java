package com.sagar.student_management_system.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sagar.student_management_system.bean.Student;
import com.sagar.student_management_system.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public List<Student> getStudents(){
		
		return repository.findAll();
	}
	
	public Student getStudent(String id) {
		
		try {
			return repository.findById(id).get();
		}
		catch(NoSuchElementException ex) {
			return null;
		}
	}
	
	public String addStudent(Student student) {
		
		return "Your id is = "+ repository.insert(student).getId();
	}
	
	public String deleteStudent(String id) {
		
		if(!repository.existsById(id)) return "Not present";
		repository.deleteById(id);
		return "Successfully deleted";
	}
	
	public String updateStudent(Student student) {
		
		if(!repository.existsById(student.getId())) return "Not present";
		repository.save(student);
		return "Successfully updated";
	}
}
