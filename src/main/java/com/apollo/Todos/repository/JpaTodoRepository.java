package com.apollo.Todos.repository;

import com.apollo.Todos.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaTodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUsername(String username);
}
