package com.applicationTracking.AssignmentLogin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.applicationTracking.AssignmentLogin.model.UserContent;

@Service
public class DocumentDetailsService {
	@Autowired
	JdbcTemplate template;

	public List<UserContent> findAll() {
		String sql = "select * from trackingresult";
		RowMapper<UserContent> rm = new RowMapper<UserContent>() {
			@Override
			public UserContent mapRow(ResultSet resultSet, int i) throws SQLException {
				UserContent userContent = new UserContent(resultSet.getLong("applicationNumber"),
						resultSet.getString("studentEmail"), resultSet.getString("genderRef"),
						resultSet.getString("updatedBy"), resultSet.getString("email"),
						resultSet.getDate("updatedDate"), resultSet.getString("waitingTime"),
						resultSet.getString("document"), resultSet.getString("missingDocuments"));
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
