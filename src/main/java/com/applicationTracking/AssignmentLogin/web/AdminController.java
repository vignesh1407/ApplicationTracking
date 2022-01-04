package com.applicationTracking.AssignmentLogin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.applicationTracking.AssignmentLogin.dto.AdminDto;
import com.applicationTracking.AssignmentLogin.service.AdminService;

@Controller	
@RequestMapping("/registrationadmin")
public class AdminController {

	private AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	@ModelAttribute("admin")
	public AdminDto adminDto() {
		return new AdminDto();
	}

	@GetMapping
	public String showRegistrationForm() {
		return "registrationadmin";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("admin") AdminDto adminDto) {
		adminService.save(adminDto);
		return "redirect:/registrationadmin?success";
	}

}
