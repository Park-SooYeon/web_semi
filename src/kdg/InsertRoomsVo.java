package kdg;

import java.util.Date;

public class InsertRoomsVo {
	String rName;//숙소이름
	String address;//상세주소
	String rPlace;//구이름
	String gInfo;//숙소소개
	int aType;//숙소타입
	int kind;//등급,종류
	Date checkin;//체크인시간
	Date checkout;//체크아웃시간
	String OriFile;//사진 이름
	String SysFile;//사진 가져오기
	
	int stars;//별점
	
	int pet;//동물동반
	int smoke;//객실내 흡연
	int noSmoke;//금연
	int parking;//주차
	int breakfast;//조식
	
	int pt;//피트니스
	int swim;//수영장
	int rest;//레스토랑
	int cafe;//카페
	int bar;//바
	
	int washer;//세탁기
	int lounge;//라운지
	int kitchen;//주방
	int dryer;//건조기
	int talsu;//탈수기
	
	String ceo;//사장이름

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getaType() {
		return aType;
	}

	public void setaType(int aType) {
		this.aType = aType;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public String getOriFile() {
		return OriFile;
	}

	public void setOriFile(String oriFile) {
		OriFile = oriFile;
	}

	public String getSysFile() {
		return SysFile;
	}

	public void setSysFile(String sysFile) {
		SysFile = sysFile;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getPet() {
		return pet;
	}

	public void setPet(int pet) {
		this.pet = pet;
	}

	public int getSmoke() {
		return smoke;
	}

	public void setSmoke(int smoke) {
		this.smoke = smoke;
	}

	public int getNoSmoke() {
		return noSmoke;
	}

	public void setNoSmoke(int noSmoke) {
		this.noSmoke = noSmoke;
	}

	public int getParking() {
		return parking;
	}

	public void setParking(int parking) {
		this.parking = parking;
	}

	public int getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(int breakfast) {
		this.breakfast = breakfast;
	}

	public int getPt() {
		return pt;
	}

	public void setPt(int pt) {
		this.pt = pt;
	}

	public int getSwim() {
		return swim;
	}

	public void setSwim(int swim) {
		this.swim = swim;
	}

	public int getRest() {
		return rest;
	}

	public void setRest(int rest) {
		this.rest = rest;
	}

	public int getCafe() {
		return cafe;
	}

	public void setCafe(int cafe) {
		this.cafe = cafe;
	}

	public int getBar() {
		return bar;
	}

	public void setBar(int bar) {
		this.bar = bar;
	}

	public int getWasher() {
		return washer;
	}

	public void setWasher(int washer) {
		this.washer = washer;
	}

	public int getLounge() {
		return lounge;
	}

	public void setLounge(int lounge) {
		this.lounge = lounge;
	}

	public int getKitchen() {
		return kitchen;
	}

	public void setKitchen(int kitchen) {
		this.kitchen = kitchen;
	}

	public int getDryer() {
		return dryer;
	}

	public void setDryer(int dryer) {
		this.dryer = dryer;
	}

	public int getTalsu() {
		return talsu;
	}

	public void setTalsu(int talsu) {
		this.talsu = talsu;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	
}
