package com.akhadam.bookstore.serviceImpl;

import com.akhadam.bookstore.dto.UserDto;
import com.akhadam.bookstore.entity.UserEntity;
import com.akhadam.bookstore.repository.UserRepository;
import com.akhadam.bookstore.service.UserService;
import com.akhadam.bookstore.shared.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utils utils;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserDto save(UserDto userDto) {

        UserEntity foundedUser = userRepository.findByEmail(userDto.getEmail());

        if (foundedUser != null) throw new RuntimeException("user already exists");

        UserEntity user = modelMapper.map(userDto, UserEntity.class);

        user.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        user.setUserId(utils.generateId(30));

        UserEntity newUser = userRepository.save(user);

        return modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public UserDto findByEmail(String email) {
        UserEntity foundedUser = userRepository.findByEmail(email);
        if (foundedUser == null) throw new RuntimeException("user not found");
        return modelMapper.map(foundedUser, UserDto.class);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException(email);
        return new User(user.getEmail(), user.getEncryptedPassword(), new ArrayList<>());
    }
}
