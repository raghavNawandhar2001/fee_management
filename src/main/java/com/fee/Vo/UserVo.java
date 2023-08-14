package com.fee.Vo;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserVo {

	@NotBlank
	private String userName;

	@NotBlank
	private String password;

	@NotBlank
	@Size(min = 4)
	private String name;

	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String emailId;

	@NotBlank
	@Size(min = 10, max = 10)
	private String mobileNumber;

	private LocalDate joiningDate;

	private int roleId;

	private int status;

	/*
	 * Getter and Setters :
	 */

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserVo [userName=" + userName + ", password=" + password + ", name=" + name + ", emailId=" + emailId
				+ ", mobileNumber=" + mobileNumber + ", joiningDate=" + joiningDate + ", roleId=" + roleId + ", status="
				+ status + "]";
	}

}
