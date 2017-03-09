package com.shop.service;

import java.util.List;

import com.shop.model.User;

public interface UserService {
	public User getUserById(int userId);

	public List<User> getuser();
}
