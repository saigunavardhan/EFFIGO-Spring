package com.JPA.springdatajpa.repo;

import com.JPA.springdatajpa.entity.Course;
import com.JPA.springdatajpa.entity.Student;
import com.JPA.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

@SpringBootTest
class CourseRepoTest {
    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void printCourses(){
        List<Course> courseList = courseRepo.findAll();
        System.out.println("Courses = "+courseList);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher= Teacher.builder().firstName("Madhav").lastname("Mohan")
                .build();

        Course course = Course.builder().courseTitle("C").credit(33).teacher(teacher).build();
        courseRepo.save(course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder().
                        firstName("Ravi").lastname("babu").build();

        Student student = Student.builder()
        .firstName("Sai").lastName("Kumar").emailId("sai@gmail.com").build();

            Course course = Course.builder().
        courseTitle("DSAI").credit(33).teacher(teacher).build();

            course.addStudents(student);

            courseRepo.save(course);
    }

}