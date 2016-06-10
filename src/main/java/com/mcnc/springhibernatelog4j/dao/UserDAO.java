package com.mcnc.springhibernatelog4j.dao;

import java.util.List;

import com.mcnc.springhibernatelog4j.domain.User;

public interface UserDAO {
	
	List<User> findAll();

	User findOne(Integer id);

	void create(User user);
	
	void delete(User user);

	void update(User user);
}
