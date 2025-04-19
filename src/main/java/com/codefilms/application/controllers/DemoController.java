package com.codefilms.application.controllers;

import java.time.LocalDateTime;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class DemoController {

	
	@Value("${apiTextMessage}")
	private   String apiTextMessage;

	// let's have a public method that says hello to users
	@GetMapping(value = "/greetings", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> sayHello() {

		log.info("api endpoint called from " + System.getProperty("os.name"));
		
		//apiTextMessage = System.g

		return new ResponseEntity<String>(new JSONObject().put("message", apiTextMessage).put("status", "success")
				.put("timestamp", LocalDateTime.now()).put("requestId", UUID.randomUUID().toString()).toString(),
				HttpStatus.OK);

	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.version"));

		System.out.println(System.getProperty("java.vendor"));

		System.out.println(System.getProperty("java.home"));

	}

}
