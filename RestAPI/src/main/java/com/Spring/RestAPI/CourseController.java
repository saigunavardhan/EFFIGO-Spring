package com.Spring.RestAPI;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> Course(){
		return Arrays.asList(
				new Course(1, "Learn COre java", "udemy"),
				new Course(2, "Learn Spring", "udemy"),
				new Course(3, "Learn ML", "udemy"),
				new Course(4, "Learn az", "udemy"));
				
	}
}
