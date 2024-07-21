package com.mynt.ortega.service;

import com.mynt.ortega.model.Student;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import com.mynt.ortega.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent(){
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().forEach(student -> students.add(student));
        return students;
        
//        return studentRepository.findByAgeGreaterThan();

//        List<String> list = Arrays.asList("emily.taylor@example.com");
//        return studentRepository.findByEmailIn(list);
    }

    @Override
    public Student getStudentById(Long id){
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    @Override
    public String deleteStudent(Long id){
        if (studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return "Student successfully deleted.";
        } else {
            throw new IllegalArgumentException("Student does not exist or has already been deleted.");
        }
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();

            boolean updated = false;
            if (student.getId() != null) {
                existingStudent.setId(student.getId());
                updated = true;
            }
            if (student.getName() != null) {
                existingStudent.setName(student.getName());
                updated = true;
            }
            if (student.getAge() != null) {
                existingStudent.setAge(student.getAge());
                updated = true;
            }
            if (student.getEmail() != null) {
                existingStudent.setEmail(student.getEmail());
                updated = true;
            }

            if (updated) {
                Student updatedEntry = studentRepository.save(existingStudent);
                return updatedEntry;
            } else {
                return existingStudent;
            }
        } else {
            return null;
        }
    }
}
