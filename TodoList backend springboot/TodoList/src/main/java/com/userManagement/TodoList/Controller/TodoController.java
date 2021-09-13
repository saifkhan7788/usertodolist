package com.userManagement.TodoList.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userManagement.TodoList.Model.Todo;
import com.userManagement.TodoList.Model.User;
import com.userManagement.TodoList.Model.UserTodos;
import com.userManagement.TodoList.Service.TodoService;
import com.userManagement.TodoList.Service.UserService;
import com.userManagement.TodoList.Service.UserTodosService;

@RestController
@RequestMapping("/UserTodolist")
@CrossOrigin(origins = "*")
public class TodoController 
{
private TodoService todoservice;
private UserService userservice;
private UserTodosService usertodosservice;

public TodoController(TodoService todoservice,UserService userservice,UserTodosService usertodosservice)
{
	this.todoservice=todoservice;
	this.userservice=userservice;
	this.usertodosservice=usertodosservice;
}

@GetMapping ("/getAllTodos")
public ResponseEntity<List<Todo>> getAllTodos()
{
	List<Todo> todo=todoservice.findAllTodos();
	return new ResponseEntity<>(todo,HttpStatus.OK);
}

@PostMapping ("/addTodo")
public ResponseEntity<Todo> addTodo(@RequestBody Todo todo)
{
	
	Todo newtodo=todoservice.addTodo(todo);
	return new ResponseEntity<>(newtodo,HttpStatus.CREATED);
}
@PostMapping ("/updateTodo")
public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo)
{
	
	Todo newtodo=todoservice.UpdateTodo(todo);
	return new ResponseEntity<>(newtodo,HttpStatus.CREATED);
}
@GetMapping ("/deleteTodo/{id}")
public ResponseEntity<?> deleteTodo(@PathVariable long id)
{
	UserTodos todos=usertodosservice.findUserTodosByTodoId(id);
	if(todos!=null) 
	{
		usertodosservice.DeleteUserTodos(todos.getId());
	}
	todoservice.DeleteTodo(id);
	
	
	return new ResponseEntity<>(HttpStatus.OK);
}
}
