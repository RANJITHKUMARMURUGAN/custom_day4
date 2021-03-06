

package com.spring.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Greeting;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	

	@GetMapping("/getGreeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@PostMapping("/postGreeting")
    public Greeting sayHello(@RequestBody Greeting greeting) {
		return new Greeting(counter.incrementAndGet(), String.format(template, greeting.getContent()));
    }
	
	@PutMapping("/putGreeting/{counter}")
    public Greeting sayHello(@PathVariable int counter, @RequestParam(value = "content") String contentName) {
		return new Greeting(counter, String.format(template, contentName));
    }	

}
