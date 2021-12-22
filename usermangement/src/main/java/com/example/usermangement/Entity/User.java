package com.example.usermangement.Entity;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	@Id
	private String id;
	private String email;
	private String password;
	private boolean loginStatus;
	private UserDetails detail;
	
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isLoginStatus() {
		return loginStatus;
	}


	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}


	public UserDetails getDetail() {
		return detail;
	}


	public void setDetail(UserDetails detail) {
		this.detail = detail;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email)
				&& Objects.equals(password, other.password);
	}
	
	
	//CHECK FOR TWO CLASS EQUALITY
	public void checker(User u) 
	{
		if(u.getEmail()!=null)
		{
		  this.email=u.getEmail();
		}
		
		if(u.getPassword()!=null) 
		{
		  this.password=u.password;
		}
		
		if(u.getDetail()!=null) 
		{
			if(this.detail==null)
			  this.detail=new UserDetails();
			
			if(u.getDetail().getName()!=null) 
			{
			  this.detail.setName(u.getDetail().getName());	
			}
			
			if(u.getDetail().getAge()!=null) 
			{
			  this.detail.setName(u.getDetail().getAge());	
			}
			
			if(u.getDetail().getOccupation()!=null) 
			{
			  this.detail.setName(u.getDetail().getOccupation());	
			}
		
		}
		
	}
	
	
	

}
