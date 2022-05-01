package com.berke.todoapp.api.controllers;


import com.berke.todoapp.dto.UserCreateRequest;
import com.berke.todoapp.dto.UserDto;
import com.berke.todoapp.dto.UserUpdateRequest;
import com.berke.todoapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserCreateRequest userCreateRequest){
        return ResponseEntity.ok(userService.addUser(userCreateRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(name = "id") int id,
                                              @RequestBody UserUpdateRequest userUpdateRequest){
        return ResponseEntity.ok(userService.updateUser(id,userUpdateRequest));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id")int id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
