package com.example.users_management.Controller;
import com.example.users_management.Model.*;
import com.example.users_management.Service.*;
import com.example.users_management.Dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/get")

    public ResponseEntity get(){
        List<User> users= userService.get();
        return ResponseEntity.status(200).body(users);
    }
    @PostMapping ("/add")
    public ResponseEntity add(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        userService.add(user);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        if(userService.update(id, user))
            return ResponseEntity.status(200).body(new ApiResponse("Updated"));
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        if(userService.delete(id))
            return ResponseEntity.status(200).body(new ApiResponse("Deleted"));
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }
}
