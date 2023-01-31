package com.Springlearning.JpaHibernate.course.jdbc;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Springlearning.JpaHibernate.course.Course;

@Repository
@Transactional
public class CourseJdbcRepo {

	@Autowired
	private JdbcTemplate springJdbcTemp;

	private static String INSERT_QUERY = """
			insert into course (id, name, author)
			values(?, ?, ?);;
						""";
	private static String DELETE_QUERY = """
			delete from course where id = ?;
						""";
	private static String SELECT_QUERY = """
			select * from course where id = ?
							""";

	public void insert(Course course) {
		springJdbcTemp.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	public void deletebyId(long id) {
		springJdbcTemp.update(DELETE_QUERY, id);
	}

	public Course selectbyId(long id) {
		return springJdbcTemp.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
