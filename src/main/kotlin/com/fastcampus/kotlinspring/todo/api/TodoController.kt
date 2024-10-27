package com.fastcampus.kotlinspring.todo.api

import com.fastcampus.kotlinspring.todo.api.model.TodoResponse
import com.fastcampus.kotlinspring.todo.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/todos")
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<TodoResponse>> {
        val todoList = todoService.findAll().map { todo -> TodoResponse.of(todo) }
        return ResponseEntity.ok(todoList)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<TodoResponse> {
        return ResponseEntity.ok(TodoResponse.of(todoService.findById(id)))
    }
}