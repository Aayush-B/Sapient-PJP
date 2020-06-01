package com.training.junit.services;

import com.training.junit.exceptions.EmailTooShortException;
import com.training.junit.exceptions.UserNotFoundException;
import com.training.junit.models.UserDAO;

import contracts.IService;

public class UserService implements IService{
	
	UserDAO userDAO ;

	public UserService(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	@Override
	public boolean insert(String email, String name, String password) throws EmailTooShortException{
		
		if(name.length()<4) {
			throw new EmailTooShortException() ;
		}
		
		User user=new User(email,name,password) ;
		
		return userDAO.insert(user) ;
	}

	@Override
	public boolean update(String email, String name, String password) throws UserNotFoundException{
		
		User user=new User(email,name,password) ;
		
		return userDAO.update(user) ;
	}

	@Override
	public boolean delete(String email) throws UserNotFoundException{
		
		return userDAO.delete(email) ;
		
	}

	@Override
	public User getDetails(String email) throws UserNotFoundException {
		return userDAO.getDetails(email) ;
	}
}