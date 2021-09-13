package com.userManagement.TodoList.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userManagement.TodoList.Exception.UserNotFoundException;
import com.userManagement.TodoList.Model.User;
import com.userManagement.TodoList.Repo.UserRepo;
@Service
public class UserService
{
private final UserRepo userrepo;
@Autowired
public UserService(UserRepo userrepo)
{
	this.userrepo=userrepo;
}
public User addUser(User user)
{
	return userrepo.save(user);
}
public List<User> findAllUsers()
{
	return userrepo.findAll();
}
public User UpdateUser(User user)
{
	return userrepo.save(user);
}
public void DeleteUser(Long Id)
{
	userrepo.deleteById(Id);
}
public Optional<User> findUserById(Long Id)
{
	return userrepo.findById(Id);
	//return userrepo.findUserById(Id).orElseThrow(()->new UserNotFoundException("User by id "+Id+"+was not found"));
}
public User findUserByEmailAndPassword(String email,String password)
{
	//return userrepo.findById(Id);
	return userrepo.findUserByEmailAndPassword(email,password);
}
}
