package com.sagar.student_management_system.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sagar.student_management_system.bean.Faculty;
import com.sagar.student_management_system.repository.FacultyRepository;

@Service
public class FacultyService {
	
	@Autowired
	private FacultyRepository repository;
	
	public List<Faculty> getFaculty(){
		
		return repository.findAll();
	}
	
	public Faculty getFaculty(String id) {
		
		try {
			return repository.findById(id).get();
		}
		catch(NoSuchElementException ex) {
			return null;
		}
	}
	
	public String addFaculty(Faculty faculty) {
		
		return "Your id is = "+ repository.insert(faculty);
	}
	
	public String deleteFaculty(String id) {
		
		if(!repository.existsById(id)) return "Not present";
		repository.deleteById(id);
		return "Successfully deleted";
	}
	
	public String updateFaculty(Faculty faculty) {
		
		if(!repository.existsById(faculty.getId())) return "Not present";
		repository.save(faculty);
		return "Successfully updated";
	}
}

