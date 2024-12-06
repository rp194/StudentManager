package com.MyDemo.StudentManager.layers.controllers;

import com.MyDemo.StudentManager.layers.Services.StudentService;
import com.MyDemo.StudentManager.layers.domain.Student;
import com.MyDemo.StudentManager.layers.domain.dto.StudentDto;
import com.MyDemo.StudentManager.layers.mappers.Mapper;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {
    private StudentService studentService;
    private Mapper<Student, StudentDto> studentMapper;
    public StudentController(StudentService studentService, Mapper<Student, StudentDto> studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }
    @PostMapping(path = "/dbInteractions")
    public ResponseEntity<String> createStudent(@RequestBody @Valid StudentDto studentDto) {
        Student student = studentMapper.mapFrom(studentDto);
        studentService.saveStudent(student);
        return new ResponseEntity<>("Student created successfully!", HttpStatus.CREATED);
    }
    @GetMapping(path = "/dbInteractions")
    public Page<StudentDto> showStudentList(Pageable pageable) {
        Page<Student> studentPage = studentService.findAll(pageable);
        Page<StudentDto> resultedPage = studentPage.map(student -> studentMapper.mapTo(student));
        return resultedPage;
    }
    @PutMapping(path = "/dbInteractions/{id}")
    public ResponseEntity<String> fullUpdate(@PathVariable("id") String id, @RequestBody @Valid StudentDto studentDto) {
        if(!studentService.contains(id)) {
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }
//        in case of having passed a miscellaneous id inside the body, different from the one in the path variable!
        studentDto.setId(id);
        Student student = studentMapper.mapFrom(studentDto);
        studentService.saveStudent(student);
        return new ResponseEntity<>("Student fully updated successfully!", HttpStatus.ACCEPTED);
    }
    @PatchMapping(path = "/dbInteractions/{id}")
    public ResponseEntity<String> partialUpdate(@PathVariable("id") String id, @RequestBody @Valid StudentDto studentDto) {
        if(!studentService.contains(id)) {
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }
        Student student = studentMapper.mapFrom(studentDto);
        studentService.partialUpdate(id, student);
        return new ResponseEntity<>("Student partially updated successfully!", HttpStatus.ACCEPTED);
    }
    @DeleteMapping(path = "/dbInteractions/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") String id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully!", HttpStatus.NO_CONTENT);
    }
    @GetMapping(path = "/dbInteractions/avgage")
    public ResponseEntity<String> averageAge() {
        if (studentService.isTableEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Double averageAge = studentService.findAverageAge();
        return new ResponseEntity<>("The average age of the students is " + averageAge, HttpStatus.FOUND);
    }
}
