package com.JPA.springdatajpa.repo;

import com.JPA.springdatajpa.entity.Guardian;
import com.JPA.springdatajpa.entity.Student;
import com.JPA.springdatajpa.repo.StudentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;
@Test
    public void saveStudent(){
    Student student = Student.builder().emailId("guna@gmail.com").
                        firstName("Sai")
            .lastName("Guna")
//            .guardianName("Nagesh")
//            .guardianEmail("Nagesh@gmail.com")
//            .guardianMobile("7702029854")
            .build();
    studentRepo.save(student);
}



@Test
public void saveStudentwithGuardian(){

    Guardian guardian = Guardian.builder().Name("Nagesh")
            .Email("Nagesh@gmail.com")
            .Mobile("7702029854").build();


    Student student = Student.builder().firstName("alex").lastName("Hastings").emailId("alex@gmail.com")
            .guardian(guardian).build();
    studentRepo.save(student);
}

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepo.findAll();

        System.out.println("Student list =" +studentList);
    }

    @Test
    public void printNamebyFirstname(){
    List<Student> students = studentRepo.findByFirstName("alex");
    System.out.println("Students = "+students);
    }
    @Test
    public void printNamebyFirstnameContaining(){
        List<Student> students = studentRepo.findByFirstNameContaining("ex");
        System.out.println("Students = "+students);
    }
    @Test
    public void getStudentByEmailAddress(){
    Student student = studentRepo.getStudentByEmailAddress("guna@gmail.com");
        System.out.println("Students = "+student);

    }

    @Test
    public void getStudentfirstNameByEmailAddress() {
        String firstName = studentRepo.getStudentfirstNameByEmailAddress("guna@gmail.com");
        System.out.println("firstName = "+firstName);

    }

    @Test
    public void getStudentByEmailAddressNative(){
    Student student = studentRepo.getStudentByEmailAddressNative("guna@gmail.com");
        System.out.println("Students = "+student);
    }
    @Test
    public void getStudentByEmailAddressNativeParam(){
        Student student = studentRepo.getStudentByEmailAddressNativeParam("guna@gmail.com");
        System.out.println("Students = "+student);
    }
    @Test
    public void updateStudentnamebyEmailId(){
      studentRepo.updateStudentnamebyEmailId("arivu", "arivu@gmail.com");
    }



}