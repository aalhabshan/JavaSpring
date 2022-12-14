package com.example.vali.Controller;
import com.example.vali.Model.*;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class Conroller1 {
    ArrayList<Employee> employees= new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Employee> getEmployees(){return employees; }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Employee employee, Errors error){
        if(error.hasErrors())
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        employees.add(employee);
        return ResponseEntity.status(200).body(new ApiResponse("Added"));
    }

    @PutMapping("/ubdate/{index}")
    public ResponseEntity update(@PathVariable int index, @RequestBody @Valid Employee employee, Errors errors){
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        employees.set(index,employee);
        return ResponseEntity.status(200).body(new ApiResponse("Updated"));
    }

    @DeleteMapping("/del/{index}")
    public ResponseEntity del(@PathVariable int index){
        employees.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Deleted"));
    }
}
