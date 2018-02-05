package com.chenys.service;

import java.util.Map;

import com.chenys.entity.User;


public interface UserService {

	Map sendSms(String userPhone);

	boolean getUserByEmail(String userEmail);

	boolean addUser(User user);

	Map activeUser(String userEmail, long time);


}
