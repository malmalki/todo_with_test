package com.mohammed.todo_mohammed.service;


import com.mohammed.todo_mohammed.model.Todo;
import com.mohammed.todo_mohammed.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;


    public List<Todo> all(){
        return todoRepo.findAll();
    }

    public void delete(Long id){
        todoRepo.deleteById(id);
    }


    public Todo post(Todo item) {
        return todoRepo.save(item);
    }


    public Todo findItemById(Long id){
        Optional<Todo> optionalTodo = todoRepo.findById(id);
        if (optionalTodo.isPresent()){
            return optionalTodo.get();
        } else {
            return null;
        }

    }
}
