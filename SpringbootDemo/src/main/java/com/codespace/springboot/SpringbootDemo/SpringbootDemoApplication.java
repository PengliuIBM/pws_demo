package com.codespace.springboot.SpringbootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootDemoApplication.class, args);

	}

	@RequestMapping (value = {"/bar","/foo"})
	public String test(){
		return "hello SpringBoot!" + "/bar";
	}
}
