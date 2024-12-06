package com.MyDemo.StudentManager.layers.domain.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class StudentDto {
    private String firstName;
    private String lastName;
    @NotNull(message = "Field cannot be null")
    @Pattern(regexp = "^[0-9]{10}$", message = "Field must be exactly 10 digits")
    private String id;
    @NotNull(message = "Birth year cannot be null")
    @Range(min = 1900, max = 2024, message = "Birth year must be a 4-digit number between 1900 and 2024")
    private Long birthYear;
}

