package com.fee.Vo;

public class StudentResponseVo {

	private StudentVo studentVo;

	private String message;

	private int status;

	public StudentVo getStudentVo() {
		return studentVo;
	}

	public void setStudentVo(StudentVo studentVo) {
		this.studentVo = studentVo;
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
		return "StudentResponseVo [studentVo=" + studentVo + ", message=" + message + ", status=" + status + "]";
	}
}
