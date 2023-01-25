package com.Springlearning.JpaHibernate.course.Jpa;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Springlearning.JpaHibernate.course.Course;

@Repository
@Transactional
public class CoursejpaRepo {

	@Autowired
	private EntityManager entityManager;

	public void insert(Course course) {
		entityManager.merge(course);
	}

	public Course selectbyId(long id) {
		return entityManager.find(Course.class, id);
	}
	public void deletebyId(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	
}
