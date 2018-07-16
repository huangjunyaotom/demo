package com.h.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
@EnableTransactionManagement
public class Application {
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	
	@GetMapping("/")
	public String menu() {
		return "menu";
	}
}
