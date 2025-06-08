package com.codefilms.application.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.codefilms.application.dao.IUserDao;
import com.codefilms.application.entity.User;
import com.codefilms.application.service.IUserService;
import com.google.common.hash.Hashing;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements IUserService {

	@Value("${user.profile.url}")
	private String userProfileUrl;

	IUserDao userDao;

	public UserService(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User fetchUserByUserId(String userId) {

		User tempUser = null;
		try {
			tempUser = userDao.fetchUserByUserId(userId);
		} catch (Exception e) {
			log.error("exception generated, fetchUserByUserId - UserService layer {}", e);
		}

		return tempUser;
	}

	@Override
	public User createUser(User requestDto) {

		User theCreatedUser = new User();
		theCreatedUser.setName(requestDto.getName());
		theCreatedUser.setBio(requestDto.getBio());
		theCreatedUser.setEmailAddress(requestDto.getEmailAddress());
		theCreatedUser.setFirstName(requestDto.getFirstName());
		theCreatedUser.setLastName(requestDto.getLastName());
		theCreatedUser.setOtherNames(requestDto.getOtherNames());
		theCreatedUser.setFullName((requestDto.getOtherNames() != null && !requestDto.getOtherNames().isEmpty())
				? requestDto.getFirstName().concat(" ").concat(requestDto.getOtherNames()).concat(" ")
						.concat(requestDto.getLastName())
				: requestDto.getFirstName().concat(" ").concat(requestDto.getLastName()));
		theCreatedUser.setMobileNumber(requestDto.getMobileNumber());
		theCreatedUser.setNationalId(requestDto.getNationalId());
		theCreatedUser.setUserId(requestDto.getFirstName().concat(".").concat(requestDto.getLastName()).toLowerCase());
		theCreatedUser.setUserName(requestDto.getUserName());
		theCreatedUser.setUserRefNo(UUID.randomUUID().toString().substring(0, 18));
		theCreatedUser
				.setPassword(Hashing.sha256().hashString(requestDto.getPassword(), StandardCharsets.UTF_8).toString());
		// theCreatedUser.setImage(requestDto.getImage().toString());
		theCreatedUser.setMentionTag("@".concat(theCreatedUser.getUserId()));

		String site = userProfileUrl.replace(":USER_ID", theCreatedUser.getMentionTag());

		// theCreatedUser.setSite(site);

		try {
			theCreatedUser = userDao.createUser(theCreatedUser);
		} catch (Exception e) {

			log.error("exception generated, createUser - UserService layer {}", e);
		}

		return theCreatedUser;
	}

}
