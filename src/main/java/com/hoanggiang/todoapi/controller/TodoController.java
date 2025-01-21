package com.hoanggiang.todoapi.controller;

import com.hoanggiang.todoapi.domain.Todo;
import com.hoanggiang.todoapi.exception.ValidException;
import com.hoanggiang.todoapi.repository.TodoRepository;
import com.hoanggiang.todoapi.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todoitems")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // get all items
    @GetMapping
    public ResponseEntity<List<Todo>> getAllItems() {
        return ResponseEntity.ok(this.todoService.getAllTodos());
    }

    // get completed items
    @GetMapping("/complete")
    public ResponseEntity<List<Todo>> getCompletedItems() {
        return ResponseEntity.ok(this.todoService.getCompletedTodos());
    }

    // get item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getItem(@PathVariable Long id) throws ValidException{
        Todo existingTodo = this.todoService.getTodoById(id);
        if(existingTodo==null){
            throw new ValidException("ID may not exist");
        }
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.todoService.getTodoById(id));
    }

    // create new item
    @PostMapping
    public ResponseEntity<Todo> createItem(@Valid @RequestBody Todo todo) throws ValidException{
        if(this.todoService.todoExists(todo)){
            throw new ValidException("Name may already exist");
        }
        return ResponseEntity.ok(this.todoService.createTodo(todo));
    }

    // update item
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateItem(@PathVariable("id") Long id, @Valid @RequestBody Todo inputTodo) throws ValidException {
        Todo existingTodo = this.todoService.getTodoById(id);
        if(existingTodo==null){
            throw new ValidException("ID may not exist");
        }
        return ResponseEntity.ok(this.todoService.updateTodo(id,inputTodo));
    }

    // delete item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable("id") Long id) throws ValidException{
        Todo existingTodo = this.todoService.getTodoById(id);
        if(existingTodo==null){
            throw new ValidException("ID may not exist");
        }
        this.todoService.deleteTodo(id);
        return ResponseEntity.ok(null);
    }

    // search item
    @GetMapping("/search")
    public ResponseEntity<List<Todo>> searchTasksByName(@RequestParam String name) {
        return ResponseEntity.ok(this.todoService.searchTasksByName(name));
    }
}
