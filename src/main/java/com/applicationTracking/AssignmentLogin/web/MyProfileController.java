
package com.applicationTracking.AssignmentLogin.web;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.applicationTracking.AssignmentLogin.model.User;
import com.applicationTracking.AssignmentLogin.repository.UserRepository;
import com.applicationTracking.AssignmentLogin.service.ProfileService;

@Controller

@RequestMapping("/myprofile")
public class MyProfileController {

	@Autowired
	private ProfileService profileService;

	/*
	 * @GetMapping public String profile() { List<User> user =
	 * profileService.getAll(); return "myprofile";
	 * 
	 * }
	 */

	@GetMapping
	public String profile() {
		//List<User> user = profileService.
		System.out.println("Inside my profile controller");
		return "myprofile";
	}
	/*
	 * @GetMapping public Map<String, Object> home(Principal principal) {
	 * Map<String, Object> model = new HashMap<String, Object>(); model.put("id",
	 * UUID.randomUUID().toString()); model.put("myprofile", "Hello " +
	 * principal.getName()); return model; }
	 */

}
