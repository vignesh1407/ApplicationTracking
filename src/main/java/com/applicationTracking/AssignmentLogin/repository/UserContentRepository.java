package com.applicationTracking.AssignmentLogin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.applicationTracking.AssignmentLogin.model.UserContent;

@Repository
public interface UserContentRepository extends CrudRepository<UserContent,Long> {

}
