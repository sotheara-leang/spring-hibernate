package com.mcnc.springhibernatelog4j.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcnc.springhibernatelog4j.dao.UserDAO;
import com.mcnc.springhibernatelog4j.domain.User;
import com.mcnc.springhibernatelog4j.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public User findOne(Integer id) {
		return userDAO.findOne(id);
	}
	
	@Override
	public void create(User user) {
		userDAO.create(user);
	}

	@Override
	public void delete(User user) {
		userDAO.delete(user);
	}

	@Override
	public void update(User user) {
		userDAO.update(user);
	}
}
