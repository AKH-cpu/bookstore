package com.akhadam.bookstore.ws.controller;

import com.akhadam.bookstore.dto.UserDto;
import com.akhadam.bookstore.requests.UserRequest;
import com.akhadam.bookstore.responses.UserResponse;
import com.akhadam.bookstore.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest) {

        UserDto userDto = modelMapper.map(userRequest, UserDto.class);
        UserDto createdUser = userService.save(userDto);

        UserResponse userResponse = modelMapper.map(createdUser, UserResponse.class);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
    }
}
