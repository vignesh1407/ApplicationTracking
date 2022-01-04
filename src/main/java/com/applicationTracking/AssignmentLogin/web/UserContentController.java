package com.applicationTracking.AssignmentLogin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.applicationTracking.AssignmentLogin.model.UserContent;
import com.applicationTracking.AssignmentLogin.service.UserContentService;

@Controller
@RequestMapping("/content")
public class UserContentController {
	
	@Autowired
	private UserContentService userContentService;
	
	@ModelAttribute("trackingResult")
	public UserContent userContent() {
		return new UserContent();
	}
	
	@GetMapping
    public String content() {
    	System.out.println("Default Controller content");
        return "content";
    }
	
	@PostMapping
	public String userContentDetails(@ModelAttribute("trackingResult") UserContent userContent) {
		System.out.println("Content COntroller");
		userContentService.addContent(userContent);
		return "redirect:/content?success";
	}
	
}
