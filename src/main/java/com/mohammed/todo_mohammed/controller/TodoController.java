package com.mohammed.todo_mohammed.controller;


import com.mohammed.todo_mohammed.model.Todo;
import com.mohammed.todo_mohammed.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;


    @GetMapping("/todo")
    public List<Todo> allTodos(){
        return todoService.all();
    }

    @RequestMapping(value = "/todo/{id}" , method = RequestMethod.GET)
    public Todo todo(@PathVariable("id") Long id){
        return todoService.findItemById(id);
    }

    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.delete(id);
    }

    @RequestMapping(value = "/todo" , method = RequestMethod.POST)
    public  Todo create(@RequestBody Todo todo) {
            return todoService.post(todo);
    }

}
