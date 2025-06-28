package com.codefilms.application.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="users")
public class User implements Serializable {

	private static final long serialVersionUID = -3033100134899564077L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userId;

	private String userRefNo;

	private String userName;

	// add name
	private String name;

	// private String image; // bytea

	private String firstName;

	private String lastName;

	private String otherNames;

	private String nationalId;

	private String fullName;

	private String emailAddress;

	private String mobileNumber;

	private String password;

	private String countryOfOrigin;

	// encapsulate as mentionTag for user.
	// private String userIdMentionTag;
	private String mentionTag;

	// user site - location on the internet
//	private String site;

	private String bio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserRefNo() {
		return userRefNo;
	}

	public void setUserRefNo(String userRefNo) {
		this.userRefNo = userRefNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getMentionTag() {
		return mentionTag;
	}

	public void setMentionTag(String mentionTag) {
		this.mentionTag = mentionTag;
	}

//	public String getSite() {
//		return site;
//	}
//
//	public void setSite(String site) {
//		this.site = site;
//	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", userRefNo=" + userRefNo + ", userName=" + userName
				+ ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName + ", otherNames="
				+ otherNames + ", nationalId=" + nationalId + ", fullName=" + fullName + ", emailAddress="
				+ emailAddress + ", mobileNumber=" + mobileNumber + ", password=" + password + ", countryOfOrigin="
				+ countryOfOrigin + ", mentionTag=" + mentionTag + ", bio=" + bio + "]";
	}
	
	

}
