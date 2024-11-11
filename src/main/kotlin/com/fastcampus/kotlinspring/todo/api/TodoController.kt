package com.fastcampus.kotlinspring.todo.api

import com.fastcampus.kotlinspring.todo.api.model.TodoListResponse
import com.fastcampus.kotlinspring.todo.api.model.TodoRequest
import com.fastcampus.kotlinspring.todo.api.model.TodoResponse
import com.fastcampus.kotlinspring.todo.service.TodoService
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todos")
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping
    fun getAll() = ok(TodoListResponse.of(todoService.findAll()))

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) = ok(TodoResponse.of(todoService.findById(id)))

    @PostMapping
    fun create(@RequestBody request: TodoRequest) = ok(TodoResponse.of(todoService.create(request)))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: TodoRequest) = ok(TodoResponse.of(todoService.update(id, request)))
}