package com.applicationTracking.AssignmentLogin.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.applicationTracking.AssignmentLogin.dto.AdminDto;
import com.applicationTracking.AssignmentLogin.model.Admin;

public interface AdminService extends UserDetailsService {
	
	Admin save(AdminDto uDto);
}
