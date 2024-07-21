package com.mynt.ortega.controller;

import com.mynt.ortega.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mynt.ortega.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
}
