package com.stackroute.profileservice.service;

import com.stackroute.profileservice.exception.UserNotFoundException;
import com.stackroute.profileservice.domain.User;
import com.stackroute.profileservice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    /*
     * Constructor Autowiring should be implemented for the ProfileRepository.
     */

    private ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    /*
     * Update an existing User by it's email. Throw UserNotFoundException if the
     * user with specified email does not exist.
     */
    @Override
    public User updateProfile(User user) throws UserNotFoundException {
        if (profileRepository.findById(user.getEmail()).isEmpty()) {
            throw new UserNotFoundException();
        }
        return profileRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) throws UserNotFoundException {
        if (profileRepository.findById(email).isEmpty()) {
            throw new UserNotFoundException();
        }
        return profileRepository.findById(email).get();
    }
}
