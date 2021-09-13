package com.userManagement.TodoList.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.userManagement.TodoList.Model.UserTodos;

public interface UserTodosRepo extends JpaRepository<UserTodos,Long>
{

	UserTodos findBystatus(boolean status);

	UserTodos findUserTodosByuser_id(Long user_id);

	//UserTodos findUserTodosBytodo_id(Long todo_id);

	
	 @Query(value="Select * from user_todos a where a.todo_id= :todo_id", nativeQuery=true)
	 UserTodos  findUserTodosBytodo_id(long todo_id);
	
}
