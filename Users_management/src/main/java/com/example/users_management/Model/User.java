package com.example.users_management.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(columnDefinition = "varchar(20) not null")
    @NotNull(message = "Name shouldn't be empty")
    private String name;

    @Column(columnDefinition = "varchar(15) unique")
    @NotNull(message = "Username shouldn't be empty")
    private String username;
    @NotNull(message = "Password shouldn't be empty")
    private String password;
//    @Column(columnDefinition = "varchar(30) unique")
    @NotNull(message = "E-mail shouldn't be empty")
    @Pattern(message = "Email should add @ and .", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    private String email ;
//    @Column(columnDefinition = "varchar(6) check(role = admin or role = user)")
    @NotNull(message = "Role shouldn't be empty")
    private String role;
    @NotNull(message = "Age shouldn't be empty")
    private Integer age;
}
