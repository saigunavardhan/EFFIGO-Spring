package com.Springbootlearning.firstrestapi.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldresource {
// /hello-world =>"Hello World"
	
	@RequestMapping("/hello-world")
	public String helloWorld() {
		return ("HELLO WORLD");
	}
	
	@RequestMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("HELLO WORLD");
	}
	
	@RequestMapping("/hello-world-path-param/{name}")
	public HelloWorldBean helloWorldPathParam(@PathVariable String name) {
		return new HelloWorldBean("Hello World" +name);
	}
	
	@RequestMapping("/hello-world-path-param/Guna/hey")
	public HelloWorldBean helloWorldMultiplePathParam(@PathVariable String name, @PathVariable String message) {
		return new HelloWorldBean("Hello World" +name+ "," + message);
	}
	
	
}
