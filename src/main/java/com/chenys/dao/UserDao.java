package com.chenys.dao;

import com.chenys.entity.User;

public interface UserDao {

	User getUserByEmail(String userEmail);

	int addUser(User user);

	int activeUser(String userEmail);

}
