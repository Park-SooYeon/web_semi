package com.user.mypage.contoroller;

import java.util.Date;

public class LogVo {
	Date logDate;
	String rName;
	String rPlace;
	String sysFile;
	
	public LogVo() {};
	public LogVo(Date logDate, String rName, String rPlace, String sysFile) {
		this.logDate=logDate;
		this.rName=rName;
		this.rPlace=rPlace;
		this.sysFile=sysFile;
	}
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrPlace() {
		return rPlace;
	}
	public void setrPlace(String rPlace) {
		this.rPlace = rPlace;
	}
	public String getSysFile() {
		return sysFile;
	}
	public void setSysFile(String sysFile) {
		this.sysFile = sysFile;
	};
	
	
}
