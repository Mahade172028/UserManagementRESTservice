package com.example.usermangement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.usermangement.Entity.Response;
import com.example.usermangement.Entity.User;
import com.example.usermangement.Repository.UserRepository;

@Service
public class UserService 
{
	
	@Autowired
	UserRepository userRepository;
	
	//CREATING A NEW USER
	public Response create(User user) 
	{
		Response response=new Response();
		
		User userSave=userRepository.save(user);
		
		response.setUser(userSave);
		response.setMessage("User Created Successfully...");
		
		return response;
	}
	
	
	//FIND ALL USER
	public List<User> getAllUser()
	{
		
		List<User> users=userRepository.findAll();
		
		return users;
	}
	
	
	//FIND USER BY USER ID
	public Response getUser(String id) 
	{
	  Response response=new Response();
	  User user=userRepository.findById(id).get();
	  if(user!=null)
	  {
		  response.setUser(user);
		  response.setMessage("User Found Sucessfully...");
	  }
	  else
	  {
		response.setMessage("Sorry User Not Found ...");  
	  }
	  
	  return response;
	}
	
	
	//LOGIN A USER
	public Response userLogin(String id,User user) 
	{
		Response response=new Response();
		User testUser=userRepository.findById(id).get();
		//if(testUser.getEmail().equals(user.getEmail()) && testUser.getPassword().equals(user.getPassword())) 
		if(testUser.equals(user)&&testUser!=null)
		{
			testUser.setLoginStatus(true);
			User respUser=userRepository.save(testUser);
			response.setUser(respUser);
			response.setMessage("User Successfully Logged in...");
		}
		else 
		{
			response.setMessage("User Not Found Try Again Please...");
			
		}
		
		return response;
	 }
	
	
	//LOGOUT A USER
	public Response userLogout(String id,User user) 
	{
		Response response=new Response();
		User testUser=userRepository.findById(id).get();
		//if(testUser.getEmail().equals(user.getEmail()) && testUser.getPassword().equals(user.getPassword())) 
		if(testUser.equals(user)&&testUser!=null)
		{
			testUser.setLoginStatus(false);
			User respUser=userRepository.save(testUser);
			response.setUser(respUser);
			response.setMessage("User Successfully Logged Out...");
		}
		else 
		{
			response.setMessage("User Not Found Try Again Please...");
			
		}
		
		return response;
	 }
	
	
	//UPDATE A USER
	public Response updateUser(String id, User user)
	{
		Response response=new Response();
		
		User testUser=userRepository.findById(id).get();
		
		if(testUser!=null) 
		{
			testUser.checker(user);
			User respSave=userRepository.save(testUser);
			response.setUser(respSave);
			response.setMessage("User Update Successfully...");
		}
		else
		{
			response.setMessage("Sorry User Not Found For Update...");
		}
		
		return response;
	}
	
	
	//GEING ALL USER BY PAGING 
	public Page<User> getAllUserPaging(int pageNumber,int pageSize)
	{
		Pageable pagin=PageRequest.of(pageNumber, pageSize);
		Page<User> users=userRepository.findAll(pagin);
		
		return users;
	}
	
	

}
