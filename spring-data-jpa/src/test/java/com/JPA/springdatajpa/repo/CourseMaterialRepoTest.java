package com.JPA.springdatajpa.repo;

import com.JPA.springdatajpa.entity.Course;
import com.JPA.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepoTest {

    @Autowired
  private CourseMaterialRepo courseMaterialRepo;


    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder().courseTitle("Cse").credit(33).build();
                CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.gun.com").
                course(course).build();
                courseMaterialRepo.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepo.findAll();
        System.out.println("courseMaterials = "+courseMaterialList);
    }

}
