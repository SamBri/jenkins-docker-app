package com.codefilms.application;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.codefilms.application.dao.impl.UserDao;
import com.codefilms.application.service.impl.UserService;

import jakarta.persistence.EntityManager;

@SpringBootTest
class JenkinsDockerApplicationImplementationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	EntityManager entityManager;

	// test that user record exist
	@Test
	void userExist() {

		UserDao userDao = new UserDao(entityManager);

		assertNotNull(userDao.fetchUserByUserId("eloise.rodriguez"), () -> "user record exist!");

	}

	@Test
	void userDoesNotExist() {

		UserDao userDao = new UserDao(entityManager);

		assertNull(userDao.fetchUserByUserId(null), () -> "user record does exist!");

	}

}
