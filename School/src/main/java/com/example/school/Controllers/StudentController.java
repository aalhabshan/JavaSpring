package com.example.school.Controllers;
import com.example.school.Model.*;
import com.example.school.Services.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/students")
    public ResponseEntity get(){
        ArrayList<Student> students = studentService.getStudents();
        return ResponseEntity.status(200).body(students);
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid  Student student, Errors errors){
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        studentService.add(student);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Student student, Errors errors){
        if(errors.hasErrors()) {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        if(studentService.isUpdated(id,student))
            return ResponseEntity.status(200).body(new ApiResponse("Updated"));
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        if(studentService.isDeleted(id))
            return ResponseEntity.status(200).body(new ApiResponse("Deleted"));
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @GetMapping("/idstudent/{id}")
    public ResponseEntity idStudent(@PathVariable Integer id){
        int index = studentService.idHere(id);
        if(index == -1)
            return ResponseEntity.status(400).body(new ApiResponse("not found"));

        return ResponseEntity.status(200).body(studentService.whoStudent(index));
    }
    @GetMapping("/namestudent")
    public ResponseEntity nameStudent(@RequestBody String name){
        int index = studentService.nameHere(name);
        if(index == -1)
            return ResponseEntity.status(400).body(new ApiResponse("not found"));

        return ResponseEntity.status(200).body(studentService.whoStudent(index));
    }

    @GetMapping("/major")
    public ResponseEntity majorStudents(@RequestBody String major){
        ArrayList<Student> majors = studentService.getMajorStudents(major);
        return ResponseEntity.status(200).body(majors);
    }
    @GetMapping("/ages")
    public ResponseEntity ageStudents(@RequestBody Integer age){
        ArrayList<Student> ages = studentService.getAgeStudents(age);
        return ResponseEntity.status(200).body(ages);
    }
}
