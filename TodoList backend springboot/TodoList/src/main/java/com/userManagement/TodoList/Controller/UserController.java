package com.userManagement.TodoList.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userManagement.TodoList.Model.LoginModel;
import com.userManagement.TodoList.Model.User;
import com.userManagement.TodoList.Model.UserTodos;
import com.userManagement.TodoList.Service.UserService;
import com.userManagement.TodoList.Service.UserTodosService;

@RestController
@RequestMapping("/UserTodolist")
@CrossOrigin(origins = "*")
public class UserController 
{
private UserService userservice;
private UserTodosService usertodosservice;

public UserController(UserService userservice, UserTodosService usertodosservice)
{
	this.userservice=userservice;
	this.usertodosservice=usertodosservice;
}
@PostMapping ("/login")
public ResponseEntity<User> login(@RequestBody LoginModel login)
{
	User newuser=userservice.findUserByEmailAndPassword(login.getEmail(), login.getPassword());
	if(newuser==null)
	{
		return new ResponseEntity<>(newuser,HttpStatus.UNAUTHORIZED);
	}
	return new ResponseEntity<>(newuser,HttpStatus.OK);
}
@GetMapping ("/getAllUsers")
public ResponseEntity<List<User>> getAllUsers()
{
	List<User> users=userservice.findAllUsers();
	return new ResponseEntity<>(users,HttpStatus.OK);
}
@PostMapping ("/addUser")
public ResponseEntity<User> addUser(@RequestBody User user)
{
	User newuser=userservice.addUser(user);
	return new ResponseEntity<>(newuser,HttpStatus.CREATED);
}
@PostMapping ("/updateUser")
public ResponseEntity<User> updateUser(@RequestBody User user)
{
	User newuser=userservice.UpdateUser(user);
	return new ResponseEntity<>(newuser,HttpStatus.CREATED);
}
@GetMapping ("/deleteUser/{id}")
public ResponseEntity<?> deleteUser(@PathVariable long id)
{
	UserTodos todos=usertodosservice.findUserTodosByUserId(id);
	if(todos!=null) 
	{
		usertodosservice.DeleteUserTodos(todos.getId());
	}
	userservice.DeleteUser(id);
	return new ResponseEntity<>(HttpStatus.OK);
}
}
