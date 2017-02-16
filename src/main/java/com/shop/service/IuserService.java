package com.shop.service;

import java.util.List;

import com.shop.model.user;

public interface IuserService {
	public user getUserById(int userId);

	public List<user> getuser();
}
