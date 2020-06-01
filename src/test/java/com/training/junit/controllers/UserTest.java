package com.training.junit.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.training.junit.exceptions.EmailTooShortException;
import com.training.junit.exceptions.UserNotFoundException;
import com.training.junit.models.UserDAO;
import com.training.junit.services.User;
import com.training.junit.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {
	
	private UserService userService ;
	private UserController userController ;
	
	@Mock
	private UserDAO userDAO;
	
	@BeforeAll
	public void setup() throws UserNotFoundException {
		
		MockitoAnnotations.initMocks(this);

	}
	
	@Test
	public void testUpdateUser() throws UserNotFoundException {
		when(userDAO.delete("aayush")).thenReturn(true) ;
		assertTrue(userDAO.delete("aayush")) ;
	}

	@Test
	public void testDeleteUser() throws UserNotFoundException {
		when(userDAO.delete("aayush@training.com")).thenReturn(true) ;
		
		userService=new UserService(userDAO) ;
		userController=new UserController(userService) ;
		
		assertEquals("User deleted successfully",userController.deleteUser("aayush@training.com")) ;
	}
	
	@Test
	public void testDeleteUserThrowsException() throws UserNotFoundException {
		when(userDAO.delete("rahul@training.com")).thenThrow(UserNotFoundException.class) ;
		
		userService=new UserService(userDAO) ;
		userController=new UserController(userService) ;
		
		Assertions.assertThrows(UserNotFoundException.class, ()->{
			userController.deleteUser("rahul@training.com") ;
		}) ;
	}
}
