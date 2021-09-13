package com.userManagement.TodoList.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userManagement.TodoList.Model.Todo;

import com.userManagement.TodoList.Repo.TodoRepo;


@Service
public class TodoService 
{
	private final TodoRepo todorepo;
	@Autowired
	public TodoService(TodoRepo todorepo)
	{
		this.todorepo=todorepo;
	}
	public Todo addTodo(Todo todo)
	{
		return todorepo.save(todo);
	}
	public List<Todo> findAllTodos()
	{
		return todorepo.findAll();
	}
	public Todo UpdateTodo(Todo user)
	{
		return todorepo.saveAndFlush(user);
	}
	public void DeleteTodo(Long Id)
	{
		todorepo.deleteById(Id);
		
	}
	public Optional<Todo> findTodoById(Long Id)
	{
		return todorepo.findById(Id);
		
	}
//	public Todo findTodoBystatus(boolean status)
//	{
//		//return todorepo.findBystatus(status);
//		//return todorepo.getAuthorsByFirstName(status);
//		
//	}
}
