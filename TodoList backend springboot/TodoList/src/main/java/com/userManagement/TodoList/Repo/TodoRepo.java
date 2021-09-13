package com.userManagement.TodoList.Repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.userManagement.TodoList.Model.Todo;

public interface TodoRepo extends JpaRepository <Todo,Long>
{

	//Todo findBystatus(boolean status);
	// @Query(value="select * from Todo a where a.status= :status", nativeQuery=true)
	   // Todo getAuthorsByFirstName(boolean status);
}
