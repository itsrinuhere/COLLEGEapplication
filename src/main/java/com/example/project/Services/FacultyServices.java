package com.example.project.Services;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class FacultyServices {
    @Autowired
    JdbcTemplate jt;
    public int saveFaculty(@NotNull HashMap<String,Object> map){
        if(isFacultyInTable((String)map.get("userid"))) return -1;
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
    public boolean isFacultyInTable(String id){
     try{
         jt.queryForMap("select userid from faculty where userid=?;",id);
         return true;
     }catch(Exception e){
         return false;
        }
    }
    public boolean isFacultyInexperineceTable(String id){
        try{
            jt.queryForMap("select userid from experience where userid=?;",id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public int saveExperience(@NotNull HashMap<String,Object> map){
            if(isFacultyInexperineceTable((String)map.get("userid"))) return -1;
            String ex =(String) map.get("exfrom");
            String to = (String) map.get("exto");
        String sql = "insert into experience(experienceid, userid, experiencetype, exfrom, exto, company, designation)" +
                "values(?,?,?,'"+ex+"','"+to+"',?,?)";
        return jt.update(sql,map.get("experienceid"),map.get("userid"),map.get("experiencetype"),map.get("company"),map.get("designation"));
    }//completed
    public int saveSocialLinks(HashMap<String,Object> map){
        String ex =(String) map.get("exfrom");
        String to = (String) map.get("exto");
        String sql = "insert into experience(experienceid, userid, experiencetype, exfrom, exto, company, designation)" +
                "values(?,?,?,'"+ex+"','"+to+"',?,?)";

        return jt.update(sql,map.get("experienceid"),map.get("userid"),map.get("experiencetype"),map.get("company"),map.get("designation"));


    }//SQL need to updated
    public int saveResearchPapers(HashMap<String,Object> map){
        String ex =(String) map.get("exfrom");
        String to = (String) map.get("exto");
        String sql = "insert into experience(experienceid, userid, experiencetype, exfrom, exto, company, designation)" +
                "values(?,?,?,'"+ex+"','"+to+"',?,?)";

        return jt.update(sql,map.get("experienceid"),map.get("userid"),map.get("experiencetype"),map.get("company"),map.get("designation"));

        //throws
    }
}
