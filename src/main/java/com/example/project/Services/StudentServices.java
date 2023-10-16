package com.example.project.Services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;
@Service
public class StudentServices {
    public void saveStudent(HashMap<String,Object> map){
        Set<String> keys = map.keySet();
        for(String i : keys){
            System.out.println(map.get(i));
        }
    }
}
