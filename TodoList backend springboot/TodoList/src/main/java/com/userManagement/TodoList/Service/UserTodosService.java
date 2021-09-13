package com.userManagement.TodoList.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userManagement.TodoList.Model.Todo;
import com.userManagement.TodoList.Model.UserTodos;
import com.userManagement.TodoList.Repo.TodoRepo;
import com.userManagement.TodoList.Repo.UserTodosRepo;

@Service
public class UserTodosService 
{
	private final UserTodosRepo usertodosrepo;
	@Autowired
	public UserTodosService(UserTodosRepo usertodosrepo)
	{
		this.usertodosrepo=usertodosrepo;
	}
	public UserTodos addUserTodos(UserTodos todo)
	{
		return usertodosrepo.save(todo);
	}
	public List<UserTodos> findAllUserTodos()
	{
		return usertodosrepo.findAll();
	}
	public UserTodos UpdateUserTodos(UserTodos usertodos)
	{
		return usertodosrepo.saveAndFlush(usertodos);
	}
	public void DeleteUserTodos(Long Id)
	{
		usertodosrepo.deleteById(Id);
		
	}
//	public void DeleteUserTodosByUserId(Long Id)
//	{
//		usertodosrepo.deleteByuser_id(Id);
//		
//	}
	public Optional<UserTodos> findTodoById(Long Id)
	{
		return usertodosrepo.findById(Id);
		
	}
	public UserTodos findTodoBystatus(boolean status)
	{
		return usertodosrepo.findBystatus(status);
		//return todorepo.getAuthorsByFirstName(status);
		
	}
	public UserTodos findUserTodosByUserId(Long Id)
	{
		return usertodosrepo.findUserTodosByuser_id(Id);
		
	}
	public UserTodos findUserTodosByTodoId(Long Id)
	{
		return usertodosrepo.findUserTodosBytodo_id(Id);
		
	}
}
