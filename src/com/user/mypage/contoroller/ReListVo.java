package com.user.mypage.contoroller;

public class ReListVo {
	String rName;
	String rPlace;
	String gInfo;
	String oriFile;
	String sysFile;
	String address;
	
	public ReListVo(){};
	public ReListVo(String rName, String rPlace, String gInfo, String oriFile, String sysFile, String address){
		this.rName=rName;
		this.rPlace=rPlace;
		this.gInfo=gInfo;
		this.oriFile=oriFile;
		this.sysFile=sysFile;
		this.address=address;
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

	public String getgInfo() {
		return gInfo;
	}

	public void setgInfo(String gInfo) {
		this.gInfo = gInfo;
	}

	public String getOriFile() {
		return oriFile;
	}

	public void setOriFile(String oriFile) {
		this.oriFile = oriFile;
	}

	public String getSysFile() {
		return sysFile;
	}

	public void setSysFile(String sysFile) {
		this.sysFile = sysFile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}

