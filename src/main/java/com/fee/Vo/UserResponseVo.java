package com.fee.Vo;

public class UserResponseVo {

	private UserVo userVo;

	private String message;

	private int status;

	public UserVo getStudentVo() {
		return userVo;
	}

	public void setStudentVo(UserVo userVo) {
		this.userVo = userVo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StudentResponseVo [studentVo=" + userVo + ", message=" + message + ", status=" + status + "]";
	}
}
