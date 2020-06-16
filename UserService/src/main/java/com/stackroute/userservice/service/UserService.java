package com.stackroute.userservice.service;

import java.util.List;

import com.stackroute.userservice.exception.InvalidCredentialsException;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.domain.User;
public interface UserService {

    /*
     * You Should not modify this interface. You have to implement these methods in
     * corresponding Impl classes
     */
    User registerUser(User user) throws UserAlreadyExistsException;

    User updateProfile(User user) throws UserNotFoundException;

    User login(User user) throws UserNotFoundException, InvalidCredentialsException;

    List<User> listAllUsers();



}