package com.stackroute.profileservice.controller;

import com.stackroute.profileservice.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.profileservice.domain.User;
import com.stackroute.profileservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin( origins = "*")
public class ProfileController {

    private ProfileService profileService;


    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;

    }

    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody User user) throws UserNotFoundException {
        return new ResponseEntity<>(profileService.updateProfile(user), HttpStatus.OK);
    }

    @GetMapping("{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) throws UserNotFoundException {
        return new ResponseEntity<>(profileService.getUserByEmail(email), HttpStatus.OK);
    }
}