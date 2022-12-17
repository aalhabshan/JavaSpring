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
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
public class TeacherContoller {
    private final TeacherService teacherService;
    @GetMapping("/teachers")
    public ResponseEntity get(){
        ArrayList<Teacher> teachers = teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Teacher teacher, Errors errors){
        if(errors.hasErrors()) {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        teacherService.add(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Teacher teacher, Errors errors){
        if(errors.hasErrors()) {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        if(teacherService.isUpdated(id,teacher))
            return ResponseEntity.status(200).body(new ApiResponse("Updated"));
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        if(teacherService.isDeleted(id))
            return ResponseEntity.status(200).body(new ApiResponse("Deleted"));
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }
    @GetMapping("/idteacher/{id}")
    public ResponseEntity idTeagher(@PathVariable Integer id){
        int index = teacherService.idHere(id);
        if(index == -1)
            return ResponseEntity.status(400).body(new ApiResponse("not found"));

        return ResponseEntity.status(200).body(teacherService.whoTeacher(index));
    }
    @GetMapping("/sal")
    public ResponseEntity salaryTeacher(@RequestBody Integer sal){
        ArrayList<Teacher> sals = teacherService.getSalaryTechers(sal);
        return ResponseEntity.status(200).body(sals);
    }
}
