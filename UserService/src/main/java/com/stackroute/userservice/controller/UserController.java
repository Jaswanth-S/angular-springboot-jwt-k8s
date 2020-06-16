package com.stackroute.userservice.controller;

import com.stackroute.userservice.exception.InvalidCredentialsException;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.security.SecurityTokenGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin( origins = "*")
public class UserController {

    private UserService userService;

    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService,SecurityTokenGenerator securityTokenGenerator ){
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }


    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws InvalidCredentialsException, UserNotFoundException {

        Map<String, String> map = null;

        User retrievedUser = userService.login(user);

        if (retrievedUser != null) {
            map = securityTokenGenerator.generateToken(retrievedUser);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody User user) throws UserNotFoundException {
        return new ResponseEntity<>(userService.updateProfile(user), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> listAllUsers() {
        return new ResponseEntity<>(userService.listAllUsers(), HttpStatus.OK);
    }

}