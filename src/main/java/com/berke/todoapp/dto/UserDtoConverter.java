package com.berke.todoapp.dto;

import com.berke.todoapp.model.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    private final TodoDtoConverter todoDtoConverter;

    public UserDtoConverter(TodoDtoConverter todoDtoConverter) {
        this.todoDtoConverter = todoDtoConverter;
    }

    public UserDto convert(User user){
        if(user.getTodos() != null)
            return new UserDto(user.getUsername(),user.getEmail(), user.getPassword(), user.getTodos().stream().map(todo ->
                    todoDtoConverter.convert(todo)).collect(Collectors.toList()));
        return new UserDto(user.getUsername(),user.getEmail(), user.getPassword(), null);
    }

    public User convertToUser(UserCreateRequest userCreateRequest){
        return new User(userCreateRequest.getUsername(),userCreateRequest.getEmail(), userCreateRequest.getPassword());
    }
}
