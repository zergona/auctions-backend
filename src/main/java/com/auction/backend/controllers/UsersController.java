package com.auction.backend.controllers;

import com.auction.backend.data.dtos.UserDto;
import com.auction.backend.data.models.User;
import com.auction.backend.repositories.UserRepository;
import com.auction.backend.services.UserService;
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
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable UUID id) {
        return userService.findById(id);
    }

    @GetMapping
    public ResponseEntity getAll() {
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody UserDto userDto) {
        return userService.postNewUser(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        return userService.deleteUser(id);
    }
}
