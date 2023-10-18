package com.example.project;

import com.example.project.Services.FacultyServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProjectApplicationTests {
	@Autowired
	FacultyServices fs;
	@Test
	void contextLoads() {
	}
@Test
	void test(){
    assertTrue(fs.isFacultyInTable("123456fijjjjjjj"));
}
@Test
void testSocialData(){
		HashMap<String,Object> map = new HashMap<>();
		map.put("userid","1234567890a");
		map.put("github","");
		map.put("linkedin","");
		assertEquals(fs.saveSocialLinks(map),1);;
}
}
