package com.example.bankmanagement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class User {
    private int id;
    private String username;
    private double balance;
}
