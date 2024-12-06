package com.MyDemo.StudentManager.layers.Services.implementations;

import com.MyDemo.StudentManager.layers.Services.StudentService;
import com.MyDemo.StudentManager.layers.domain.Student;
import com.MyDemo.StudentManager.layers.repositories.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.Optional;

@Service
public class StudentServiceHandler implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceHandler(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public boolean contains(String id) {
        return studentRepository.existsById(id);
    }

    @Override
    public Student partialUpdate(String id, Student student) {
        return  studentRepository.findById(id).map(foundStudent -> {
            Optional.ofNullable(student.getBirthYear()).ifPresent(foundStudent::setBirthYear);
            Optional.ofNullable(student.getFirstName()).ifPresent(foundStudent::setFirstName);
            Optional.ofNullable(student.getLastName()).ifPresent(foundStudent::setLastName);
            return studentRepository.save(foundStudent);
        }).orElseThrow();
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Double findAverageAge() {
        return studentRepository.findAverageAge(Year.now().getValue());
    }

    @Override
    public boolean isTableEmpty() {
        return studentRepository.count() == 0;
    }

    
}
