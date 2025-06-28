package com.codefilms.application.dao.impl;

import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.codefilms.application.controllers.ApplicationController;
import com.codefilms.application.dao.IUserDao;
import com.codefilms.application.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDao implements IUserDao {

	// jpa - inbuilt native hibernate vendor
	EntityManager entityManager;

	public UserDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional // fetchUserByUserId
	public User fetchUserByUserId(String userId) {
		// get the current hibernate session
		User tempUser = null;
		try {
			Session currentSession = entityManager.unwrap(Session.class);

			TypedQuery<User> query = currentSession
					.createQuery("select user FROM User user where user.userId = :userId", User.class);

			query.setParameter("userId", userId);

			tempUser = query.getSingleResult();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return tempUser;
	}

	@Override
	@Transactional
	public User createUser(User user) {

		try {
			// get current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);

			// save the user.
			user = currentSession.merge(user);

		} catch (Exception e) {

			log.error("exception -  UserDao layer", e);

		}

		return user;
	}

}
