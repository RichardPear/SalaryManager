package com.lch.service;

import com.lch.entity.User;

public interface IUserService {
	public User getUserBuId(Integer id);
	public User getUserByUsername(String username);
	public void addUser(User u);
}
