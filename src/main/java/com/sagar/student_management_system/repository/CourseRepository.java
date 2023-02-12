package com.sagar.student_management_system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.student_management_system.bean.Course;

@RestController
public interface CourseRepository extends MongoRepository<Course, String> {
	
}
