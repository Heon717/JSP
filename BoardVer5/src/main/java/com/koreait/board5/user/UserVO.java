package com.koreait.board5.user;

public class UserVO {
	private int iuser;
	private  String uid;
	private  String upw;
//	private  String upw2;
	private  String unm;
	private  int gender;
	private String regdt;
	
	public int getIuser() {
		return iuser;
	}
	public void setIuser(int iuser) {
		this.iuser = iuser;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
//	public String getUpw2() {
//		return upw2;
//	}
//	public void setUpw2(String upw2) {
//		this.upw2 = upw2;
//	}
	public String getUnm() {
		return unm;
	}
	public void setUnm(String unm) {
		this.unm = unm;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	
}