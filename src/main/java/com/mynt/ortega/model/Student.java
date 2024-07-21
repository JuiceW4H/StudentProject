package com.mynt.ortega.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //mark class as entity
@Table //defining class name as Table name
public class Student {

    @Column //defining id as primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column
    public String name;

    @Column
    public Integer age;

    @Column
    public String email;
}
