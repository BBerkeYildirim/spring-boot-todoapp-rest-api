package com.berke.todoapp.api.controllers;

import com.berke.todoapp.dto.TodoCreateRequest;
import com.berke.todoapp.dto.TodoDto;
import com.berke.todoapp.dto.TodoUpdateRequest;
import com.berke.todoapp.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAll(){
        return ResponseEntity.ok(todoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(todoService.findTodoById(id));
    }

    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoCreateRequest todoCreateRequest){
        return ResponseEntity.ok(todoService.addTodo(todoCreateRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable(name = "id") int id,
                                              @RequestBody TodoUpdateRequest todoUpdateRequest){
        return ResponseEntity.ok(todoService.updateTodo(id,todoUpdateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable(name = "id") int id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<TodoDto> changeStatus(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(todoService.changeStatus(id));
    }
}
