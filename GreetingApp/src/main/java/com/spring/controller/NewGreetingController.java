
package com.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.NewGreeting;
import com.spring.GreetingService;

@RestController
public class NewGreetingController {
	@Autowired
	private GreetingService greetingService;
	
	
	@GetMapping(value = "/getMessage")
	public ResponseEntity<String> getMessage() {
	    return new ResponseEntity<>(greetingService.getMessage(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getGreetingMessage")
	public ResponseEntity<String> greeting(@RequestParam(value = "fname", defaultValue = "World") String fname,
			@RequestParam(value = "lname", defaultValue = "") String lname) {
		return new ResponseEntity<>(greetingService.getGreeting(fname, lname), HttpStatus.OK);
	}

	@GetMapping(value = "/getGreetingDetails")
	public ResponseEntity<List<NewGreeting>> getGreeting() {
	    return new ResponseEntity<>(greetingService.getGreeting(), HttpStatus.OK);
	}

	@PostMapping(value = "/addGreetingDetails")
	public ResponseEntity<NewGreeting> addGreeting(@RequestBody NewGreeting greeting) {
	    return new ResponseEntity<>(greetingService.addGreeting(greeting), HttpStatus.OK);
	}

	@GetMapping(value = "/getGreetingByID")
	public ResponseEntity<String> getEmployeeByID(@RequestParam(name = "id") int id) {
		return new ResponseEntity<>(greetingService.getEmployeeByID(id), HttpStatus.OK);
	}

	@PutMapping(value = "/updateGreeting")
	public ResponseEntity<NewGreeting> updateGreeting(@RequestParam(name = "id") int id,
												   @RequestParam(name = "message") String message) {
		return new ResponseEntity<>(greetingService.updateGreeting(id, message), HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteGreeting")
	public ResponseEntity<String> deleteGreeting(@RequestParam(name = "id") int id) {
		return new ResponseEntity<>(greetingService.deleteGreeting(id), HttpStatus.OK);
	}
}
