package com.apollo.Todos.controller;

import com.apollo.Todos.domain.Todo;
import com.apollo.Todos.service.JpaTodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class TodoController {

    private final JpaTodoService todoService;

    public TodoController(JpaTodoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping("/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        return todoService.findByUsername(username);
    }

    @GetMapping("/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String username,
                                   @PathVariable Long id) {
        return todoService.findById(id);
    }

    @DeleteMapping("/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,
                                       @PathVariable Long id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable String username,
                                           @PathVariable Long id,
                                           @RequestBody Todo todo) {
        todoService.updateTodo(todo);
        return todo;
    }

    @PostMapping("/{username}/todos")
    public Todo createTodo(@PathVariable String username,
                           @RequestBody Todo todo) {
        Todo createdTodo = todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return createdTodo;
    }

}
