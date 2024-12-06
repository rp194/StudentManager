package com.MyDemo.StudentManager.layers.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.MyDemo.StudentManager.layers.model.Student;

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
