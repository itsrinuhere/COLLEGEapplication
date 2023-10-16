package com.example.project.controller;

import com.example.project.Services.FacultyServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping("api")
public class FacultyController {
    @Autowired
    FacultyServices fs;
    @PostMapping("faculty")
    ResponseEntity<Object> saveFaculty(@RequestBody HashMap<String,Object> data){
        return new ResponseEntity<>(fs.saveFaculty(data)==1?HttpStatus.CREATED:HttpStatus.NO_CONTENT);
    }
    @GetMapping("/faculty")
    ResponseEntity<Object> getAllFaculty() {
        fs.getAllFaculty();
        return new ResponseEntity<>( fs.getAllFaculty(),HttpStatus.OK);
    }
    @GetMapping("/faculty/{id}")
    ResponseEntity<Object> getFacultyById(@PathVariable String id){
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    ResponseEntity<Object> getFacultsByDoctorates(){
//
//    }
}
