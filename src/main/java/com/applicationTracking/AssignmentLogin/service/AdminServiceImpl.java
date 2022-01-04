package com.applicationTracking.AssignmentLogin.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.applicationTracking.AssignmentLogin.dto.AdminDto;
import com.applicationTracking.AssignmentLogin.model.Admin;
import com.applicationTracking.AssignmentLogin.model.Role;
import com.applicationTracking.AssignmentLogin.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	private AdminRepository adminRepository;

	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Admin save(AdminDto aDto) {
		Admin admin = new Admin(aDto.getFirstName(), aDto.getLastName(), aDto.getEmail(),
				bCryptPasswordEncoder.encode(aDto.getPassword()), Arrays.asList(new Role("ADMIN")));
		return adminRepository.save(admin);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByEmail(username);
		if (admin == null)
			throw new UsernameNotFoundException("Invalid Username or Password");
		System.out.print("admin roles check" + admin.getRoles() + "Vignesh");
		return new org.springframework.security.core.userdetails.User(admin.getEmail(), admin.getPassword(),
				mappingRolesToAuth(admin.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mappingRolesToAuth(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoles())).collect(Collectors.toList());
	}

}
