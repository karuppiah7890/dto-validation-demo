package com.example.dtovalidation.controllers;

import com.example.dtovalidation.dtos.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @PostMapping(path = "/users")
    void createUser(@Valid @RequestBody UserDto userDto) {
        // create a user using the UserService
    }
}
