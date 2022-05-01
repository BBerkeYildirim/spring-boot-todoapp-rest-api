package com.berke.todoapp.service;


import com.berke.todoapp.dto.UserCreateRequest;
import com.berke.todoapp.dto.UserDto;
import com.berke.todoapp.dto.UserDtoConverter;
import com.berke.todoapp.dto.UserUpdateRequest;
import com.berke.todoapp.model.User;
import com.berke.todoapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;


    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserDto> getAll(){
        return userRepository.findAll().stream().map(user -> userDtoConverter.convert(user)).collect(Collectors.toList());
    }

    public UserDto addUser(UserCreateRequest userCreateRequest){
        User toSave = userDtoConverter.convertToUser(userCreateRequest);
        return userDtoConverter.convert(userRepository.save(toSave));
    }

    public UserDto findUserById(int id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return userDtoConverter.convert(user);
        }
        return null;
    }

    public User findById(int id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return user;
        }
        return null;
    }

    public UserDto updateUser(int id, UserUpdateRequest userUpdateRequest){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setEmail(userUpdateRequest.getEmail());
            user.setPassword(userUpdateRequest.getPassword());
            user.setUsername(userUpdateRequest.getUsername());
            return userDtoConverter.convert(userRepository.save(user));
        }
        return null;
    }

    public void deleteUser(int id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            userRepository.delete(user);
        }
    }
}
