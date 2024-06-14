package com.oebp.service;

import java.util.List;

import com.oebp.entities.User;
import com.oebp.exceptions.DuplicateUserException;
import com.oebp.exceptions.InvalidLoginCredentialException;


public interface UserService {

	public User registerUser(User user)throws DuplicateUserException;
    public User loginUser(User user) throws InvalidLoginCredentialException;
    public User forgetPassword(String username);
    public User emailPassword(String username);
    public User changePassword(User user,String np)throws InvalidLoginCredentialException;
    public User getUserById(Integer uid);
    public User getUserByUserName(String username);
    public List<User> getallUsers();
}