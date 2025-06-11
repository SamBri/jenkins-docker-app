package com.codefilms.application.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codefilms.application.entity.User;
import com.codefilms.application.service.impl.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class ApplicationController {

	@Value("${apiTextMessage}")
	private String apiTextMessage;

	@Autowired
	UserService userService;

	// let's have a public method that says hello to users
	@GetMapping(value = "/greetings", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> sayHello() {

		log.info("api endpoint called from " + System.getProperty("os.name"));

		return new ResponseEntity<String>(new JSONObject().put("message", apiTextMessage).put("status", "success")
				.put("timestamp", LocalDateTime.now()).put("requestId", UUID.randomUUID().toString()).toString(),
				HttpStatus.OK);

	}

	
	// author: bobby.
	@GetMapping(value = "/yarn", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> yarn() {

		log.info("api endpoint called from " + System.getProperty("os.name"));
		
		apiTextMessage = "yarn :: {dateTime}".replace("{dateTime}", LocalDateTime.now().toString());

		return new ResponseEntity<String>(new JSONObject().put("message", apiTextMessage).put("status", "success")
				.put("timestamp", LocalDateTime.now()).put("requestId", UUID.randomUUID().toString()).toString(),
				HttpStatus.OK);

	}
	
	




	@PostMapping(path = "/users", consumes = { MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<User> createUser(@RequestBody User userDto) {

		log.info("api endpoint called with user request received {}", new JSONObject(userDto));

		User theCreatedUser = null;
		ResponseEntity<User> apiResponseEntity;
		try {
			theCreatedUser = userService.createUser(userDto);
			apiResponseEntity = new ResponseEntity<User>(theCreatedUser, HttpStatus.CREATED);

		} catch (Exception e) {

			log.error("exception", e);
			apiResponseEntity = new ResponseEntity<User>(theCreatedUser, HttpStatus.EXPECTATION_FAILED);
		}

		return apiResponseEntity;
	}

	@GetMapping(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> fetchUserByUserId(@PathVariable String userId) {

		log.info("api endpoint called from " + System.getProperty("os.name"));

		HashMap<String, Object> container = new HashMap<>();
		Optional.ofNullable(userService.fetchUserByUserId(userId)).ifPresentOrElse(user -> {
			container.put("user", user);
			container.put("message", "user found");
			container.put("status", "success");
		}, () -> {
			container.put("message", "user not found");
			container.put("status", "failed");
			log.error("user not found");
		});

		return new ResponseEntity<String>(new JSONObject().put("message", container.get("message"))
				.put("status", container.get("status")).put("response", new JSONObject(container.get("user")))
				.put("timestamp", LocalDateTime.now()).put("requestId", UUID.randomUUID().toString()).toString(),
				HttpStatus.OK);

	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.version"));

		System.out.println(System.getProperty("java.vendor"));

		System.out.println(System.getProperty("java.home"));

	}

}
