package com.berke.todoapp.dto;

import com.berke.todoapp.model.Todo;

import java.util.List;

public class UserDto {
    private String username;
    private String email;
    private String password;
    private List<TodoDto> todos;

    public UserDto(String username, String email, String password, List<TodoDto> todos) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.todos = todos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TodoDto> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoDto> todos) {
        this.todos = todos;
    }
}
