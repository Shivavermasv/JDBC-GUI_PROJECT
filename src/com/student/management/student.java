package com.student.management;

public class student {
	private int studentid;
	private String studentname;
	private String studentphn;
	private String studentcity;

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentphn() {
		return studentphn;
	}

	public void setStudentphn(String studentphn) {
		this.studentphn = studentphn;
	}

	public String getStudentcity() {
		return studentcity;
	}

	public void setStudentcity(String studentcity) {
		this.studentcity = studentcity;
	}

	public student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public student(int studentid, String studentname, String studentphn, String studentcity) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentphn = studentphn;
		this.studentcity = studentcity;
	}

	public student(String studentname, String studentphn, String studentcity) {
		super();
		this.studentname = studentname;
		this.studentphn = studentphn;
		this.studentcity = studentcity;
	}

	@Override
	public String toString() {
		return "student [studentid=" + studentid + ", studentname=" + studentname + ", studentphn=" + studentphn
				+ ", studentcity=" + studentcity + "]";
	}

}
