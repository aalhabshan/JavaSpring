package com.example.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Assimnment {
    @GetMapping("/name")
    public String name(){
        return "My name is Abdullah";
    }

    @GetMapping("/age")
    public String age(){
        return "My age is 23";
    }

    @GetMapping("/check/status")
    public String check(){
        return "verything OK";
    }

    @GetMapping("/halth")
    public String health(){
        return "Server health is up and running";
    }
}
