package com.applicationTracking.AssignmentLogin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.applicationTracking.AssignmentLogin.service.DocumentDetailsService;

@Controller
@RequestMapping("/details")
public class DocumentDetailsController {

	@Autowired
	DocumentDetailsService service;

	@GetMapping
	public String index(Model md) {
		md.addAttribute("userContents", service.findAll());
		return "details";
	}
}
