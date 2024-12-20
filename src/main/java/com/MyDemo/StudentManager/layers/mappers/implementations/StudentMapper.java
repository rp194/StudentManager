package com.MyDemo.StudentManager.layers.mappers.implementations;

import com.MyDemo.StudentManager.layers.mappers.Mapper;
import com.MyDemo.StudentManager.layers.model.Student;
import com.MyDemo.StudentManager.layers.model.dto.StudentDto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements Mapper<Student, StudentDto> {
    private ModelMapper modelMapper;

    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDto mapTo(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public Student mapFrom(StudentDto studentDto) {
        return modelMapper.map(studentDto, Student.class);
    }
}
