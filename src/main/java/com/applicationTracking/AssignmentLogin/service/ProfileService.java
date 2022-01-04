package com.applicationTracking.AssignmentLogin.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.applicationTracking.AssignmentLogin.model.Role;
import com.applicationTracking.AssignmentLogin.model.User;
import com.applicationTracking.AssignmentLogin.model.UserContent;

@Service
public class ProfileService {

	@Autowired
	JdbcTemplate template;

	public List<User> findAll() {
		String sql = "select * from trackingresult";
		RowMapper<User> rm = new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet resultSet, int i) throws SQLException {
				User userContent = new User(resultSet.getLong("applicationNumber"),
						resultSet.getString("firstName"), resultSet.getString("lastName"),
						resultSet.getString("email"), resultSet.getString("password"),Arrays.asList(new Role("ADMIN")));
				String email = resultSet.getString("email");
                if (email != null) {
                	userContent.setEmail(email);
                }
				return userContent;
			}
		};
		
		
		return template.query(sql, rm);
	}

}
