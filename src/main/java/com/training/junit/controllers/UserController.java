package com.training.junit.controllers;

import com.training.junit.exceptions.EmailTooShortException;
import com.training.junit.exceptions.UserNotFoundException;
import com.training.junit.services.User;
import com.training.junit.services.UserService;

public class UserController {
	
	UserService userService ;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	public String insertUser(String email, String name, String password) throws EmailTooShortException {
		
		try {
			if(userService.insert(email,name,password)) {
				return new String("User inserted successfully") ;
			}
			
			else
			{
				return new String("Unable to insert user.") ;
			}
		}
		catch(EmailTooShortException e) {
			throw e ;
		}
		
	}
	
	public String updateUser(String email, String name, String password) throws UserNotFoundException {
		try {
			if(userService.update(email,name,password)) {
				return new String("User updated successfully") ;
			}
			
			else
			{
				return new String("Unable to update user.") ;
			}
		}
		catch(UserNotFoundException e) {
			throw e ;
		}
	}
	
	public String deleteUser(String email) throws UserNotFoundException {
		try {
			if(userService.delete(email)) {
				return new String("User deleted successfully") ;
			}
			
			else
			{
				return new String("Unable to delete user.") ;
			}
		}
		catch(UserNotFoundException e) {
			throw e ;
		}
	}
	
	public String getUser(String email) throws UserNotFoundException {
		try {
			User user=userService.getDetails(email) ;
			
			if(user!=null) {
				return user.toString() ;
			}
			
			else
			{
				return new String("Unable to get user details.") ;
			}
		}
		catch(UserNotFoundException e) {
			throw e ;
		}
	}
}
