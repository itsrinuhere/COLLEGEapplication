package com.example.project.controller;

import com.example.project.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentServices studentServices;
    @PostMapping("/student")
    ResponseEntity<Object> saveStudent(@RequestBody HashMap<String,Object> data){
        studentServices.saveStudent(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/student/{id}")
    ResponseEntity<Object> getStudentById(@PathVariable String id){
        return null;
    }

}
