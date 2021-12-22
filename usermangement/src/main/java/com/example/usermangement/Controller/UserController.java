package com.example.usermangement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.usermangement.Entity.Response;
import com.example.usermangement.Entity.User;
import com.example.usermangement.Service.UserService;

@RestController
@RequestMapping("/services")
public class UserController 
{
	
	@Autowired
	UserService userService;
	
	Response response;
	
	//FOR CREATING A USER
	@PostMapping("/users/create")
	public Response userCreation(@RequestBody User user)
	{
		
		user.setLoginStatus(false);
		response=userService.create(user);
		
		return response;
	}
	
	
	//FOR UPDATE A USER
	@PutMapping("/users/{id}/update")
	public Response updateUser(@PathVariable String id,@RequestBody User user)
	{
	   response=userService.updateUser(id, user);
	   
	   return response;
	}
	
	
	//FOR GETTING ALL USER
	@GetMapping("/users")
	public List<User> allUser() 
	{
		List<User> users=userService.getAllUser();
		
		return users;
	}
	
	//FOR GETTING USER BY ID
	@GetMapping("/users/{id}")
	public Response getUser(@PathVariable String id) 
	{
		response=userService.getUser(id);
		
		return response;
	}
	
	//FOR LOGGED IN A USER
	@PostMapping("/users/{id}/login")
	public Response Login(@PathVariable String id,@RequestBody User user)
	{
		response=userService.userLogin(id, user);
		
		return response;
	}
	
	//FOR LOGOUT A USER
	@PostMapping ("/users/{id}/logout")
	public Response Logout(@PathVariable String id,@RequestBody User user)
	{
		response=userService.userLogout(id, user);
		
		return response;
		
	}
	
	
	//FOR GETTING ALL DATA BY PAGEABLE
	@PostMapping("/users/pagin")
	public List<User> getAllByPage(
			@RequestParam(value="pageNum",defaultValue="0") Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="5") Integer pageSize
			)
	{
		
		Page<User> users=userService.getAllUserPaging(pageNum,pageSize);		
		return users.toList();
	}
	

}
