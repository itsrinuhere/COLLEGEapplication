package com.example.project.controller;

import com.example.project.Services.FacultyServices;
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
    @PostMapping("faculty/{id}")
    ResponseEntity<Object> saveSubFaculty(@RequestBody HashMap<String,Object> map, @PathVariable String id){
       int res = -1;
       System.out.println(map.get("userid"));
        try{
            switch (id) {
                case "social" -> {
                    res = fs.saveSocialLinks(map);
                }
                case "recent" -> {

                    res = fs.saveResearchPapers(map);
                }
                case "experience" -> {
                    res=fs.saveExperience(map);
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(res==1?HttpStatus.CREATED:HttpStatus.CONFLICT);
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
