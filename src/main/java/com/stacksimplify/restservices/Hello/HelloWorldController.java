package com.stacksimplify.restservices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {
	
	// Simple Method
	//URI - /helloworld
	//GET
	//@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
	@GetMapping("helloword1")
	public String helloWorld() {
		return "hello world";
	}
	
	@GetMapping("/helloword-bean")
	public UserDetails helloWorldBean() {
		return new UserDetails("Kaylan", "Reddy", "Hyperabad");
	}
	
}