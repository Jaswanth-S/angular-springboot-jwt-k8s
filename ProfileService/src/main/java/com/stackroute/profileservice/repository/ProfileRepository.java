package com.stackroute.profileservice.repository;

import com.stackroute.profileservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * This class is implementing the JpaRepository interface for Person.
 * Annotate this class with @Repository annotation
 */
@Repository
public interface ProfileRepository extends JpaRepository<User, String> {

}
