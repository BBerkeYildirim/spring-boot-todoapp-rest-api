package com.berke.todoapp.service;


import com.berke.todoapp.dto.TodoCreateRequest;
import com.berke.todoapp.dto.TodoDto;
import com.berke.todoapp.dto.TodoDtoConverter;
import com.berke.todoapp.dto.TodoUpdateRequest;
import com.berke.todoapp.model.Todo;
import com.berke.todoapp.model.User;
import com.berke.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoDtoConverter todoDtoConverter;
    private final UserService userService;

    public TodoService(TodoRepository todoRepository, TodoDtoConverter todoDtoConverter, UserService userService) {
        this.todoRepository = todoRepository;
        this.todoDtoConverter = todoDtoConverter;
        this.userService = userService;
    }

    public List<TodoDto> getAll(){
        return todoRepository.findAll().stream().map(todo -> todoDtoConverter.convert(todo)).collect(Collectors.toList());
    }

    public TodoDto findTodoById(int id){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if(optionalTodo.isPresent()){
            Todo todo = optionalTodo.get();
            return todoDtoConverter.convert(todo);
        }
        return null;
    }

    public TodoDto addTodo(TodoCreateRequest todoCreateRequest){
        User user = userService.findById(todoCreateRequest.getUserId());
        if(user == null)
            return null;
        Todo todo = new Todo(todoCreateRequest.getTitle(),todoCreateRequest.getContent(),todoCreateRequest.isStatus(),
               user);
        return todoDtoConverter.convert(todoRepository.save(todo));
    }

    public TodoDto updateTodo(int id, TodoUpdateRequest todoUpdateRequest){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if(optionalTodo.isPresent()){
            Todo todo = optionalTodo.get();
            todo.setTitle(todoUpdateRequest.getTitle());
            todo.setContent(todoUpdateRequest.getContent());
            todo.setStatus(todoUpdateRequest.isStatus());
            return todoDtoConverter.convert(todoRepository.save(todo));
        }
        return null;
    }

    public void deleteTodo(int id){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if(optionalTodo.isPresent()){
            Todo todo = optionalTodo.get();
            todoRepository.delete(todo);
        }
    }

    public TodoDto changeStatus(int id){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if(optionalTodo.isPresent()){
            Todo todo = optionalTodo.get();
            todo.setStatus(!todo.isStatus());
            todoRepository.save(todo);
            return todoDtoConverter.convert(todo);
        }
        return null;
    }
}
