package com.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.stereotype.Service;

import com.spring.NewGreeting;

@Service
public class GreetingService {
	private static final String template = "Hello, %s %s!";
	private List<NewGreeting> greetingList = new ArrayList<>();
	public String getMessage() {
		return "Hello World";
	}
	public String getGreeting(String fname, String lname) {
		return String.format(template, fname, lname);
	}

	public NewGreeting addGreeting(NewGreeting greeting) {
		greetingList.add(greeting);
		return greeting;
	}

	public List<NewGreeting> getGreeting() {
		return greetingList;
	}
	
    public String getEmployeeByID(int id) {
		AtomicReference<String> greetings = new AtomicReference<>("");
		greetingList.stream()
				.filter(greetingElement -> greetingElement.getId() == id)
				.forEach(greetingElement -> {
					greetings.set(greetingElement.getMessage());
			});
		return String.valueOf(greetings);
    }

	public NewGreeting updateGreeting(int id, String message) {
		NewGreeting greeting = findEmployeeById(id);
		greeting.setMessage(message);
		return greeting;
	}

	private NewGreeting findEmployeeById(int id) {
		return greetingList.stream()
				.filter(greetingElement -> greetingElement.getId() == id).findFirst()
				.orElseThrow(() -> new RuntimeException("Unable to find any greeting"));
	}

	public String deleteGreeting(int id) {
		NewGreeting greeting = findEmployeeById(id);
		greetingList.remove(greeting);
		return "Greeting deleted successfully";
	}
}
