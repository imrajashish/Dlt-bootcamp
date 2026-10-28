package com.deloitte.training.student.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/hello")
public class HelloController {
//    http://localhost:8080/hello/Ashish
    @GetMapping("/{name}")
    public ResponseEntity<String> getGreeting(@PathVariable String name){
        String message = "Hello "+ name +", Welcome to Springboot Tutorial!";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


}


