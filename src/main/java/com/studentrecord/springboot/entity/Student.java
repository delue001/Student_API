package com.studentrecord.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long StudentId;

    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private int age;
    @Column
    private String country;
    @Column
    private String city;

}
