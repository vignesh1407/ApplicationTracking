package com.applicationTracking.AssignmentLogin.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.applicationTracking.AssignmentLogin.model.UserContent;
import com.applicationTracking.AssignmentLogin.repository.UserContentRepository;

@Service
public class UserContentService {

	@Autowired
	private UserContentRepository userContentRepository;

	public List<UserContent> getAllContent() {
		List<UserContent> content = new ArrayList<>();
		userContentRepository.findAll().forEach(content::add);
		return content;
	}

	public void addContent(UserContent userContent) {
		userContentRepository.save(userContent);
	}
}
