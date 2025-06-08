package com.codefilms.application.dao;

import java.util.List;

import com.codefilms.application.entity.User;

public interface IUserDao {

	User fetchUserByUserId(String userId);

	User createUser(User user);

}
