package com.applicationTracking.AssignmentLogin.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.applicationTracking.AssignmentLogin.dto.UserDto;
import com.applicationTracking.AssignmentLogin.model.User;

public interface UserService extends UserDetailsService {
	
	User save(UserDto uDto);
}
