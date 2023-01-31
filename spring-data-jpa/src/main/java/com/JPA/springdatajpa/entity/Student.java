package com.JPA.springdatajpa.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student",
    uniqueConstraints = @UniqueConstraint(
            name = "email_unq",
            columnNames = "email_add"
    )
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "st_seq",
            sequenceName = "st_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "st_seq"
    )
    private Long StudentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_add"
    ,nullable = false)
    private String emailId;

    @Embedded
    public Guardian guardian;


}
