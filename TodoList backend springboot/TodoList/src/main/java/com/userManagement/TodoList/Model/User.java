package com.userManagement.TodoList.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "users")
public class User implements Serializable
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
   @Column(name="email")
	private String email;
   @Column(name="phone")
	private String phone;
   @Column(name="password")
  	private String password;
   
   @OneToMany(mappedBy = "userid")
   @JsonIgnore
	private Set<User> userid;
   
	public User()
	{
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<User> getUserid() {
		return userid;
	}

	public void setUserid(Set<User> userid) {
		this.userid = userid;
	}
	
}
