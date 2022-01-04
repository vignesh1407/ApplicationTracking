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
import com.applicationTracking.AssignmentLogin.dto.UserDto;
import com.applicationTracking.AssignmentLogin.model.Role;
import com.applicationTracking.AssignmentLogin.model.User;
import com.applicationTracking.AssignmentLogin.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User save(UserDto uDto) {
		User user = new User(uDto.getApplicationNumber(), uDto.getFirstName(), uDto.getLastName(), uDto.getEmail(),
				bCryptPasswordEncoder.encode(uDto.getPassword()), Arrays.asList(new Role("USER")));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null)
			throw new UsernameNotFoundException("Invalid Username or Password");
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mappingRolesToAuth(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mappingRolesToAuth(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoles())).collect(Collectors.toList());
	}

}
