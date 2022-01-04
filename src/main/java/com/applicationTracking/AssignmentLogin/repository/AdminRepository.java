package com.applicationTracking.AssignmentLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.applicationTracking.AssignmentLogin.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
	Admin findByEmail(String email);
}
