package com.auction.backend.services;

import com.auction.backend.data.dtos.UserDto;
import com.auction.backend.data.models.User;
import com.auction.backend.repositories.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> findAll() {
        Iterable<User> all = userRepository.findAll();
        return new ResponseEntity(all, HttpStatus.OK);
    }

    public ResponseEntity<User> findById(@PathVariable UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity(new UserDto(user.get()), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<User> postNewUser(@RequestBody UserDto userDto) {
        userRepository.save(new User(userDto.getFirstName(), userDto.getLastName()));
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<User> updateUser(UUID id, UserDto userDto) {
        User user = userRepository.findById(id).get();
        if (user != null) {
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            userRepository.save(user);
            return new ResponseEntity(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<User> deleteUser(UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}

