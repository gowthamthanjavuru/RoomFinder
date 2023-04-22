package com.twg.spring.fur.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twg.spring.fur.dao.UserDaoInterface;
import com.twg.spring.fur.entities.User;

@Component
public class UserBussinessInterfaceImpl implements UserBussinessInterface {

	@Autowired
	private UserDaoInterface userDaoInterface;
	
	public UserDaoInterface getUserDaoInterface() {
		return userDaoInterface;
	}

	public void setUserDaoInterface(UserDaoInterface userDaoInterface) {
		this.userDaoInterface = userDaoInterface;
	}

	public void save(User user) {
		userDaoInterface.save(user);

	}

	public void update(User user) {
		userDaoInterface.update(user);

	}

	public void delete(User user) {
		userDaoInterface.delete(user);

	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDaoInterface.findById(id);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDaoInterface.findAll();
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDaoInterface.findByUsername(username);
	}

}
