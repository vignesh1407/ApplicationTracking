package com.applicationTracking.AssignmentLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.applicationTracking.AssignmentLogin.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
