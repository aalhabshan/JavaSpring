package com.example.vali.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

@Data @AllArgsConstructor
public class Employee {

    @NotNull(message = "ID shouldn't be empty")
    @Size(min = 3,message = "ID must be more than 2 number")
    public String id;
    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 4,message = "Name must be more than 4 letter")
    public String name;
    @NotNull(message = "Age shouldn't be empty")
    @Min(value = 25, message = "Age must be more than 25")
    public int age;
    @AssertFalse(message = "On Leave must be (false)")
    public boolean onLeave;
    @NotNull(message = "employmentYear shouldn't be empty")
//    @Min(value = 2047-age,message = "The year not valid")
    public int employmentYear;
    @NotNull(message = "annualLeave shouldn't be empty")
//    @Pattern(regexp="^(0|[1-9][0-9]*)$",message = "annualLeave must be number")
    @Positive(message = "annualLeave must be positive")
    public int annualLeave;
}
