package com.mynt.ortega.service;

import com.mynt.ortega.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    String deleteStudent(Long id);
    Student updateStudent(Long id, Student student);
}
