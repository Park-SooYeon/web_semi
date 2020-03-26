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
	int star;
	
	public RvVo() {};
	public RvVo(int rNo, int rCode, String eMail, String rContent, String rDate, int rGroup, int rStep, int rIndent, int star) {
		this.rNo=rNo;
		this.rCode=rCode;
		this.eMail=eMail;
		this.rContent=rContent;
		this.rDate=rDate;
		this.rGroup=rGroup;
		this.rStep=rStep;
		this.rIndent=rIndent;
		this.star=star;
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
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	
}
