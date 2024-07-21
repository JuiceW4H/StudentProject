package com.mynt.ortega.test;

import com.mynt.ortega.model.Student;
import com.mynt.ortega.repository.StudentRepository;

import com.mynt.ortega.service.StudentServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl stService;

    @Mock
    private StudentRepository stRepository;

    @Mock
    private Student student;

    private AutoCloseable closeable;

    @BeforeEach
    public void setup() {

        closeable = MockitoAnnotations.openMocks(this);

        when(student.getId()).thenReturn(1L);
        when(student.getName()).thenReturn("Josh Garcia");
        when(student.getAge()).thenReturn(20);
        when(student.getEmail()).thenReturn("josh.garcia@example.com");
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testSaveStudent(){
        when(stService.saveStudent(student)).thenReturn(student);

        assertNotNull(stService.saveStudent(student));
    }

    @Test
    public void testGetAllStudent(){
        when(stRepository.findAll()).thenReturn(Collections.singletonList(student));

        List<Student> students = stService.getAllStudent();

        assertEquals("josh.garcia@example.com", students.get(0).getEmail());
        verify(stRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteStudent() {
        Long studentID = 1L;
        when(stRepository.existsById(student.getId())).thenReturn(true);
        doNothing().when(stRepository).deleteById(studentID);

        stService.deleteStudent(studentID);

        verify(stRepository, times(1)).existsById(studentID);
        verify(stRepository, times(1)).deleteById(studentID);
    }
}