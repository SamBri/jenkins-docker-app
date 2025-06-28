package com.codefilms.application.service;

import com.codefilms.application.entity.User;

public interface IUserService {

	User fetchUserByUserId(String userId);
	
	User createUser(User userDto);
}
