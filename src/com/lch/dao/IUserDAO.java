package com.lch.dao;

import java.util.List;

import com.lch.entity.User;

public interface IUserDAO {
	public User findById(Integer id);
	public List findByUsername(Object username);
	public void save(User u);
}
