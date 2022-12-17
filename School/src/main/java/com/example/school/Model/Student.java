package com.example.school.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty(message = "ID shouldn't be empty")
    @Min(value = 1000,message = "ID must be more than 3 numbers")
    private int id;
    @NotNull(message = "Name shouldn't be empty")
    @Size(min = 3,message = "Name must be more than 2 letter")
    private String name;
    @NotEmpty(message = "Age shouldn't be empty")
    private int age;
    @NotNull(message = "Major shouldn't be empty")
    @Pattern(regexp = "(CS|MATH|Engineer)",message = "Major just CS , MATH , Engineer")
    private String major;
}
