package com.berke.todoapp.dto;

import com.berke.todoapp.model.Todo;
import org.springframework.stereotype.Component;


@Component
public class TodoDtoConverter {

    public TodoDto convert(Todo todo){
        return new TodoDto(todo.getTitle(),todo.getContent(),todo.isStatus(),todo.getUser().getId());
    }

}
