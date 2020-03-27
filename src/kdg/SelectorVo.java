package kdg;

public class SelectorVo {
	String place ="";	//호옥시 지역 선택했니?
	int aType = 0;		//숙소타입
	int nowPage =1;		//페이징
	String target ="";	//보낼 페이지
	String sort ="";	//가격 정렬 뭘로할거니
	//라디오 버튼이 만약 null로 들어온다면 초기값을 5로할거다
	int kind = 5;		//호텔 타입?
	int maxPeople =0;	//최대인원?
	int bedtype =5;		//베드 타입?
	//공용시설
	int pt = 0;			//피스니스가 있니?
	int swim =0;		//수영장이 있니?
	int rest=0;			//레스토랑이 있니?
	int cafe=0;			//카페가 있니?
	int bar=0;			//BAR가 있니?
	//객실내 시설
	int tv=0;			//tv가 있니?
	int wifi=0;			//wifi가 있니?
	int spa=0;			//spa가 있니
	int tub=0;			//tub가 있니
	int iron=0;			//iron이 있니
	int computer=0;		//컴퓨터가 있니
	int refr=0;			//냉장고가 있니
	int aircon=0;		//에어컨이 있니
	int socket=0;		//콘센트가 있니
	//기타
	int pet=0;			//pet이 있니
	int smoke=0;		//흡연룸이니
	int noSmoke=0;		//금연룸이니
	int parking=0;		//주차장이 있니
	int breakfast=0;	//조식이 있니
	//공용(게하)
	int washer=0;		//세탁기가 있니
	int lounge=0;		//라운지가 있니
	int kitchen=0;		//주방이 있니
	int dryer=0;		//건조기가 있니
	int talsu=0;		//탈수기가 있니
	public SelectorVo() {}
	public SelectorVo(String place , int aType , int nowPage, String sort , int kind,int maxPeople,int bedtype,int pt,int swim,int rest,int cafe,int bar,
						int tv,int wifi,int spa,int tub,int iron,int computer,int refr,int aircon,int socket,int pet,int smoke,int noSmoke,int parking,
						int breakfast,int washer,int lounge,int kitchen,int dryer,int talsu) { 
		this.place = place;
		this.aType = aType;
		this.nowPage = nowPage;
		this.sort = sort;
		this.kind = kind;
		this.maxPeople = maxPeople;
		this.bedtype = bedtype;
		this.pt = pt;
		this.swim = swim;
		this.rest = rest;
		this.cafe = cafe;
		this.bar = bar;
		this.tv = tv;
		this.wifi = wifi;
		this.spa = spa;
		this.tub = tub;
		this.iron =iron;
		this.computer = computer;
		this.refr = refr;
		this.aircon = aircon;
		this.socket = socket;
		this.pet = pet;
		this.smoke = smoke;
		this.noSmoke = noSmoke;
		this.parking = parking;
		this.breakfast = breakfast;
		this.washer = washer;
		this.lounge = lounge;
		this.kitchen = kitchen;
		this.dryer = dryer;
		this.talsu = talsu;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getaType() {
		return aType;
	}
	public void setaType(int aType) {
		this.aType = aType;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	public int getBedtype() {
		return bedtype;
	}
	public void setBedtype(int bedtype) {
		this.bedtype = bedtype;
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
	public int getTv() {
		return tv;
	}
	public void setTv(int tv) {
		this.tv = tv;
	}
	public int getWifi() {
		return wifi;
	}
	public void setWifi(int wifi) {
		this.wifi = wifi;
	}
	public int getSpa() {
		return spa;
	}
	public void setSpa(int spa) {
		this.spa = spa;
	}
	public int getTub() {
		return tub;
	}
	public void setTub(int tub) {
		this.tub = tub;
	}
	public int getIron() {
		return iron;
	}
	public void setIron(int iron) {
		this.iron = iron;
	}
	public int getComputer() {
		return computer;
	}
	public void setComputer(int computer) {
		this.computer = computer;
	}
	public int getRefr() {
		return refr;
	}
	public void setRefr(int refr) {
		this.refr = refr;
	}
	public int getAircon() {
		return aircon;
	}
	public void setAircon(int aircon) {
		this.aircon = aircon;
	}
	public int getSocket() {
		return socket;
	}
	public void setSocket(int socket) {
		this.socket = socket;
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
	
	
}
