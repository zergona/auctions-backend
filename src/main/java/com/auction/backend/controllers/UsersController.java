package com.auction.backend.controllers;

import com.auction.backend.data.dtos.UserDto;
import com.auction.backend.data.models.User;
import com.auction.backend.repositories.UserRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable UUID id){

        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity(new UserDto(user.get()), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity getAll(){
        Iterable<User> all = userRepository.findAll();
        return new ResponseEntity(all, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody UserDto userDto){
        // TODO: Add
        return null;
    }

    @PutMapping
    public ResponseEntity update(@RequestBody UserDto userDto){
        // TODO: Update
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        // TODO: Delete
        return null;
    }

}
