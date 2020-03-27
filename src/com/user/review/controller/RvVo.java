package com.user.review.controller;

public class RvVo {
	int rNo;
	int rCode;
	String eMail;
	String rContent;
	String rDate;
	int rGroup;
	int rStep;
	int rIndent;
	int stars;
	int cnt;
	
	public RvVo() {};
	public RvVo(int rNo, int rCode, String eMail, String rContent, String rDate, int rGroup, int rStep, int rIndent, int stars) {
		this.rNo=rNo;
		this.rCode=rCode;
		this.eMail=eMail;
		this.rContent=rContent;
		this.rDate=rDate;
		this.rGroup=rGroup;
		this.rStep=rStep;
		this.rIndent=rIndent;
		this.stars=stars;
	}
	
	public int getrNo() {
		return rNo;
	}
	public void setrNo(int rNo) {
		this.rNo = rNo;
	}
	public int getrCode() {
		return rCode;
	}
	public void setrCode(int rCode) {
		this.rCode = rCode;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public String getrDate() {
		return rDate;
	}
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	public int getrGroup() {
		return rGroup;
	}
	public void setrGroup(int rGroup) {
		this.rGroup = rGroup;
	}
	public int getrStep() {
		return rStep;
	}
	public void setrStep(int rStep) {
		this.rStep = rStep;
	}
	public int getrIndent() {
		return rIndent;
	}
	public void setrIndent(int rIndent) {
		this.rIndent = rIndent;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
}