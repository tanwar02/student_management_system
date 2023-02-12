package com.sagar.student_management_system.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sagar.student_management_system.bean.Course;
import com.sagar.student_management_system.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
	public List<Course> getCourses(){
		
		return repository.findAll();
	}
	
    public Course getCourse(String id) {
		
		try {
			return repository.findById(id).get();
		}
		catch(NoSuchElementException ex) {
			return null;
		}
	}
	
	public String addCourse(Course course) {
		
		return "Your id is = "+ repository.insert(course).getId();
	}
	
	public String deleteCourse(String id) {
		
		if(!repository.existsById(id)) return "Not present";
		repository.deleteById(id);
		return "Successfully deleted";
	}
	
	public String updateCourse(Course course) {
		
		if(!repository.existsById(course.getId())) return "Not present";
		repository.save(course);
		return "Successfully updated";
	}
}
