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
@RequestMapping("/UserTodolist")
@CrossOrigin(origins = "*")
@RestController
public class UserTodosController 
{

private TodoService todoservice;
private UserService userservice;
private UserTodosService usertodosservice;
public UserTodosController(TodoService todoservice,UserService userservice,UserTodosService usertodosservice)
{
	this.todoservice=todoservice;
	this.userservice=userservice;
	this.usertodosservice=usertodosservice;
}

@GetMapping ("/getAllUserTodos")
public ResponseEntity<List<UserTodos>> getAllUserTodos()
{
	List<UserTodos> todo=usertodosservice.findAllUserTodos();
	return new ResponseEntity<>(todo,HttpStatus.OK);
}
@GetMapping ("/getUserTodosByStatus/{status}")
public ResponseEntity<UserTodos> getTodosByStatus(@PathVariable boolean status)
{
	UserTodos todo=usertodosservice.findTodoBystatus(status);
	return new ResponseEntity<>(todo,HttpStatus.OK);
}
@GetMapping ("/getTodosByUserId/{user_id}")
public ResponseEntity<UserTodos> getTodosByStatus(@PathVariable Long user_id)
{
	UserTodos todo=usertodosservice.findUserTodosByUserId(user_id);
	if(todo==null)
	{
		return new ResponseEntity<>(todo,HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(todo,HttpStatus.OK);
}
@PostMapping ("/addUserTodos")
public ResponseEntity<UserTodos> addUserTodos(@RequestBody UserTodos todo)
{
	Optional<User> user=userservice.findUserById(todo.getUser_id());
	todo.setUser(user.get());
	Optional<Todo> todo1=todoservice.findTodoById(todo.getTodo_id());
	todo.setTodoid(todo1.get());
	UserTodos newtodo=usertodosservice.addUserTodos(todo);
	return new ResponseEntity<>(newtodo,HttpStatus.CREATED);
}
@PostMapping ("/updateUserTodos")
public ResponseEntity<UserTodos> updateTodo(@RequestBody UserTodos todo)
{
	Optional<User> user=userservice.findUserById(todo.getUser_id());
	todo.setUser(user.get());
	Optional<Todo> todo1=todoservice.findTodoById(todo.getTodo_id());
	todo.setTodoid(todo1.get());
	
UserTodos j=usertodosservice.findUserTodosByTodoId(todo1.get().getId());
	j.setAction(todo.isAction());
	UserTodos newtodo=usertodosservice.UpdateUserTodos(j);
	
	return new ResponseEntity<>(newtodo,HttpStatus.CREATED);
}
@GetMapping ("/deleteUserTodos/{id}")
public ResponseEntity<?> deleteUserTodos(@PathVariable long id)
{
	
	usertodosservice.DeleteUserTodos(id);
	return new ResponseEntity<>(HttpStatus.OK);
}
}
