package com.MyDemo.StudentManager.layers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MyDemo.StudentManager.layers.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String>,
        JpaRepository<Student, String>,
        PagingAndSortingRepository<Student, String> {
        @Query("SELECT AVG(:currentYear - s.birthYear) FROM Student s")
        Double findAverageAge(@Param("currentYear") int currentYear);                
}
