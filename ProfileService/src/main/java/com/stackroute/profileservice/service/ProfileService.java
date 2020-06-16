package com.stackroute.profileservice.service;


import com.stackroute.profileservice.exception.UserNotFoundException;
import com.stackroute.profileservice.domain.User;
public interface ProfileService {

    /*
     * You Should not modify this interface. You have to implement these methods in
     * corresponding Impl classes
     */

    User getUserByEmail(String email) throws UserNotFoundException;
    User updateProfile(User user) throws UserNotFoundException;

}