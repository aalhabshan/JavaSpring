package com.example.todo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ToDoList {
    private String title , description , status , deadline;

}
