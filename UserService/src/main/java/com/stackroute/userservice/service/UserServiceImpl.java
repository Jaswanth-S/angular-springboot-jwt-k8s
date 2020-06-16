package com.stackroute.userservice.service;

import com.stackroute.userservice.exception.InvalidCredentialsException;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    /*
     * Constructor Autowiring should be implemented for the UserRepository.
     */

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
     * Register a new User. Throw UserAlreadyExistsException if the user with specified
     * email already exists.
     */
    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        if (userRepository.findById(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    /*
     * Update an existing User by it's email. Throw UserNotFoundException if the
     * user with specified email does not exist.
     */
    @Override
    public User updateProfile(User user) throws UserNotFoundException {
        if (userRepository.findById(user.getEmail()).isEmpty()) {
            throw new UserNotFoundException();
        }
        return userRepository.save(user);
    }


    /*
     * Retrieve all existing users
     */
    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User login(User user) throws UserNotFoundException, InvalidCredentialsException {
        if (userRepository.findById(user.getEmail()).isEmpty()) {
            throw new UserNotFoundException();
        }
        User retrievedUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (retrievedUser == null) {
            throw new InvalidCredentialsException();
        }
        return retrievedUser;
    }
}
