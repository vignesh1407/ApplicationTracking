package com.applicationTracking.AssignmentLogin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login() {
		System.out.println("VVVVCHEECK!! + login");
		return "login";
	}

	@GetMapping("/home")
	public String index() {
		System.out.println("VVVVCHEECK!! + index");
		return "index";
	}
	
	@GetMapping("/profile")
	public String profile() {
		System.out.println("Inside my profile controller");
		return "myprofile";
	}
}
