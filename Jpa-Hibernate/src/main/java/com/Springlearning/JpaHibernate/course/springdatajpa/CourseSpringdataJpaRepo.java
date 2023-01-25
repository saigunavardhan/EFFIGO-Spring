package com.Springlearning.JpaHibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Springlearning.JpaHibernate.course.Course;

public interface CourseSpringdataJpaRepo extends JpaRepository<Course, Long> {
	List<Course>findByAuthor(String author);
	List<Course>findByName(String name);
}
