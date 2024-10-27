package com.codefilms.application.controllers;

import java.time.LocalDateTime;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
	
	
	//let's have a public method that says hello to users
	@GetMapping(value="/greetings",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> sayHello() {
		
		return new ResponseEntity<String>(new JSONObject().put("greetings", "Hello world :: " + LocalDateTime.now()).toString(), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	

}
