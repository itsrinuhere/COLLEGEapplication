package com.example.project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FacultyServices {
    @Autowired
    JdbcTemplate jt;
    public int saveFaculty(HashMap<String,Object> map){
//        Set<String> keySet = map.keySet();
        if(isFacutlyInTable((String)map.get("userid"))) return -1;
        String sql="insert into faculty(userid,name,gender,dob,department,contactnumber,address,designation) values (?,?,?,?,?,?,?,?)";
        return jt.update(sql,
                map.get("userid"),map.get("name"),map.get("gender"),
                map.get("dob"),map.get("department"),map.get("contact_number"),
                map.get("address"),map.get("designation"));
    }
    public List<Map<String, Object>> getAllFaculty(){
       List<Map<String,Object>> dataS= jt.queryForList("select * from faculty");
       if(dataS.isEmpty()){
           return new ArrayList<>();
       }
       return dataS;
    }//working
    public boolean isFacutlyInTable(String id){
     try{
         jt.queryForMap("select userid from faculty where userid=?;",id);
         return true;
     }catch(Exception e){
         return false;
        }
    }
}
