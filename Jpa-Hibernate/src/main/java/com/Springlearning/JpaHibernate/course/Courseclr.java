package com.Springlearning.JpaHibernate.course;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Springlearning.JpaHibernate.course.Course;
import com.Springlearning.JpaHibernate.course.Jpa.CoursejpaRepo;
import com.Springlearning.JpaHibernate.course.jdbc.CourseJdbcRepo;
import com.Springlearning.JpaHibernate.course.springdatajpa.CourseSpringdataJpaRepo;

@Component
public class Courseclr implements CommandLineRunner {

	// @Autowired
	// private CourseJdbcRepo repo;

	// @Autowired
	// private CoursejpaRepo repo;

	@Autowired
	private CourseSpringdataJpaRepo repo;

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Course(1, "Learn Boot", "Udemy"));
		repo.save(new Course(2, "Learn Sql", "Udemy"));
		repo.save(new Course(3, "Learn Pyt", "Udemy"));
		repo.save(new Course(4, "Learn ML", "Udemy"));

		repo.deleteById(1l);

		System.out.println(repo.findById(2l));
		System.out.println(repo.findAll());
		System.out.println(repo.count());

		System.out.println(repo.findByAuthor("Udemy"));
		System.out.println(repo.findByName("Learn Sql"));

	}

}
