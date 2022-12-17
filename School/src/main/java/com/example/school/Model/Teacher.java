package com.example.school.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Teacher {
    @NotNull(message = "ID shouldn't be empty")
    @Min(value = 1000,message = "ID must be more than 3 numbers")
    private int id;
    @NotNull(message = "Name shouldn't be empty")
    @Size(min = 3,message = "Name must be more than 2 letter")
    private String name;
    @NotNull(message = "Salary shouldn't be empty")
    private int salary;


}
