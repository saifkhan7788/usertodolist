package com.userManagement.TodoList.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "todo")
public class Todo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="id",nullable=false,updatable=false)
     private Long id;
	@Column(name="name")
private String name;
	@Column(name="description")
private String description;


@OneToMany(mappedBy = "todoid")
@JsonIgnore
	private Set<Todo>todoid;


public Set<Todo> getTodoid() {
	return todoid;
}
public void setTodoid(Set<Todo> todoid) {
	this.todoid = todoid;
}

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




}
