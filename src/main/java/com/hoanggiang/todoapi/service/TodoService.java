package com.hoanggiang.todoapi.service;

import com.hoanggiang.todoapi.domain.Todo;
import com.hoanggiang.todoapi.exception.ValidException;
import com.hoanggiang.todoapi.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return this.todoRepository.findAll();
    }

    public List<Todo> getCompletedTodos() {
        return this.todoRepository.findByComplete(true);
    }

    public Todo getTodoById(Long id) {
        return this.todoRepository.findById(id).orElse(null);
    }

    public Todo createTodo(Todo todo) {
        return this.todoRepository.save(todo);
    }

    public boolean todoExists(Todo todo){
        return this.todoRepository.existsByName(todo.getName());
    }

    public Todo updateTodo(Long id, Todo todo) {
        Todo existingTodo = getTodoById(id);
        existingTodo.setName(todo.getName());
        existingTodo.setComplete(todo.isComplete());
        return todoRepository.save(existingTodo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> searchTasksByName(String name) {
        return this.todoRepository.findAll(TodoSpecs.nameLike(name));
    }
}
