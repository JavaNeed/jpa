package com.byteslounge.spring.tx.dao;

import java.util.List;

import com.byteslounge.spring.tx.model.User;

public interface UserDAO {
	void insertUser(User user);
	List<User> findAllUsers();
}
