package reserve;

import java.text.SimpleDateFormat;

public class ReserveVo {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	String rName; // 예약자 이름
	String rPhone; // 예약자 번호
	int rCode; // 숙소 코드
	int period; // 숙박 기간
	int payment; // 결제 수단(1:신용카드, 2:페이)
	int price; // 결제 가격
	String email; // 유저 아이디
	String checkIn; // 체크인 시간
	String checkOut; // 체크아웃 시간
	
	
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrPhone() {
		return rPhone;
	}
	public void setrPhone(String rPhone) {
		this.rPhone = rPhone;
	}
	public int getrCode() {
		return rCode;
	}
	public void setrCode(int rCode) {
		this.rCode = rCode;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
}
