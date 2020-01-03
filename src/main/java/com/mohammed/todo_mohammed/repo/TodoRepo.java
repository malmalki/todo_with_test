package com.mohammed.todo_mohammed.repo;

import com.mohammed.todo_mohammed.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo, Long> {

}
