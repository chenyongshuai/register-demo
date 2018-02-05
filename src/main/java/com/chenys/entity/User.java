package com.chenys.entity;

public class User {
	private int userId;
	private String userEmail;
	private String userPassword;
	private String userPhone;
	private int userRole;
	private int userState=0;
	
	public int getUserState() {
		return userState;
	}
	public void setUserState(int userState) {
		this.userState = userState;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userPhone=" + userPhone
				+ ", userRole=" + userRole + ", userState=" + userState + "]";
	}
	
}
