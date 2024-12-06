package com.MyDemo.StudentManager.layers.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    private String firstName;
    private String lastName;
    @Id
    private String id;
    private Long birthYear;
}
