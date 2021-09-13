package com.userManagement.TodoList.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.userManagement.TodoList.Model.User;
import com.userManagement.TodoList.Model.UserTodos;

public  interface UserRepo extends JpaRepository<User,Long>
{

	//User findUserByEmailAndPassword(String email, String password);
	 @Query(value="select * from users a where a.email= :email And a.password=:password", nativeQuery=true)
	 User findUserByEmailAndPassword(String email, String password);
	//User findUserByid(Long id);

	//void deleteUserById(Long Id);

	//User findUserById(Long Id);

}
