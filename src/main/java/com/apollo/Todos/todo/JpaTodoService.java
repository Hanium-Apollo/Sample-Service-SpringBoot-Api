package com.apollo.Todos.todo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class JpaTodoService {
    private final JpaTodoRepository todoRepository;

    public List<Todo> findByUsername(String username) {
        return todoRepository.findByUsername(username);
    }

    public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(null, username, description, targetDate, done);
        return todoRepository.save(todo);
    }

    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }
}
