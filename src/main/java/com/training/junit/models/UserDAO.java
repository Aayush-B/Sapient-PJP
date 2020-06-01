package com.training.junit.models;

import com.training.junit.exceptions.UserNotFoundException;
import com.training.junit.services.User;

import contracts.IDAO;

public class UserDAO implements IDAO{

	@Override
	public boolean insert(User user) {
		return false;
	}

	@Override
	public boolean delete(String email) throws UserNotFoundException{
		return false;
	}

	@Override
	public boolean update(User user) throws UserNotFoundException{
		return false;
	}

	@Override
	public User getDetails(String email) throws UserNotFoundException{
		return null;
	}
}
