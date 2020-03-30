package search;

public class SearchVo {
	int rCode;
	String rName;
	String rPlace;
	
	
	String toJSON() {
		String json = "";
		String temp = "{"
					+ "\"rCode\":" + rCode
					+ ",\"rName\":" + rName
					+ ",\"rPlace\":" + rPlace
					+ "}";
		json = "[" + temp + "]";
		return json;
	}
	
	public int getrCode() {
		return rCode;
	}
	public void setrCode(int rCode) {
		this.rCode = rCode;
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
}
