package com.akhadam.bookstore.service;

import com.akhadam.bookstore.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto save(UserDto userDto);

    UserDto findByEmail(String email);

}
