package com.mynt.ortega.repository;

import com.mynt.ortega.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

//    List<Student> findByAgeGreaterThan(Integer age);
//    List<Student> findAllByOrderByAge();
//    List<Student> findByEmailIn(List<String> emails);
}
