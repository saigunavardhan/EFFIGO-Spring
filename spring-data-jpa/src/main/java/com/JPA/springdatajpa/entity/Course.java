package com.JPA.springdatajpa.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_seq",
            sequenceName = "course_seq",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_seq"
    )
    private Long courseId;
    private String courseTitle;
    private Integer credit;
    @OneToOne(
            mappedBy ="course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
           cascade = CascadeType.ALL
    )
    @JoinColumn(
             name = "teacher_id",
             referencedColumnName = "teacherId"
    )

    private Teacher teacher;


    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name ="student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
            referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentID"
            )
    )
    private List<Student> students;
    public void addStudents(Student student){
        if(students == null) students = new ArrayList<>();
        students.add(student);
    }


}
