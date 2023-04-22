package com.twg.spring.fur.bussiness;

import java.util.List;

import com.twg.spring.fur.entities.User;

public interface UserBussinessInterface {
	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public User findById(int id);
	public List<User> findAll();
	public User findByUsername(String username);
}
