package com.data.Controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class RestClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static String GET_STUDENT_LIST="http://localhost:8080/students";
	
	private static String GET_STUDENT_BY_ID="http://localhost:8080/students/{id}";
	
@GetMapping("/students")
public List<Object> getStudentList(){
	
	Object[] listObjects=restTemplate.getForObject(GET_STUDENT_LIST, Object[].class);
	return Arrays.asList(listObjects);
	
}
	
@GetMapping("/students/{id}")
public Object getStudentById(){
	
	Map<String, String> params=new HashMap<>();
	params.put("id", "1");
	Object object=restTemplate.getForObject(GET_STUDENT_BY_ID, Object.class, params);
	return object;
	
}

		

}
