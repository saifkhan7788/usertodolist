package com.userManagement.TodoList.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user_todos")
public class UserTodos implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="id",nullable=false,updatable=false)
     private Long id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="status")
	private boolean status;
	@Column(name="action")
	private boolean action;
	@Column(name="user_id",insertable=false,updatable=false)
	private Long user_id;
	@Column(name="todo_id",insertable=false,updatable=false)
	private Long todo_id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;
	@ManyToOne
	@JoinColumn(name="todo_id")
	@JsonIgnore
	private Todo todoid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getTodo_id() {
		return todo_id;
	}
	public void setTodo_id(Long todo_id) {
		this.todo_id = todo_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Todo getTodoid() {
		return todoid;
	}
	public void setTodoid(Todo todoid) {
		this.todoid = todoid;
	}
	public boolean isAction() {
		return action;
	}
	public void setAction(boolean action) {
		this.action = action;
	}
	
	
}
