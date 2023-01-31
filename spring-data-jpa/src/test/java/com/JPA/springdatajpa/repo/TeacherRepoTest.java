package com.JPA.springdatajpa.repo;

import com.JPA.springdatajpa.entity.Course;
import com.JPA.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepoTest {
    @Autowired
    private TeacherRepo teacherRepo;

    @Test
    public void saveTeacher(){
        Course courseSPM = Course.builder().
                courseTitle("SPM").credit(33).build();

        Course courseCOA = Course.builder().
                courseTitle("COA").credit(23).build();

//        Teacher teacher = Teacher.builder().firstName("Dean").lastname("Gopal").//courses(List.of(courseSPM, courseCOA)).build();
//        teacherRepo.save(teacher);

    }

}