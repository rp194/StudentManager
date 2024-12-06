package com.MyDemo.StudentManager.layers.Services;

import com.MyDemo.StudentManager.layers.domain.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//@Service
public interface StudentService {
    Student saveStudent(Student student);

    Page<Student> findAll(Pageable pageable);

    boolean contains(String id);

    Student partialUpdate(String id, Student student);

    void deleteStudent(String id);

    Double findAverageAge();

    boolean isTableEmpty();
}
