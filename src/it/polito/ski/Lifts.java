package it.polito.ski;

public class Lifts {
	private String code;
	private String category;
	private Integer seatsNum;
	
	public Lifts(String code, String category, Integer seatsNum) {
		super();
		this.code = code;
		this.category = category;
		this.seatsNum = seatsNum;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getSeatsNum() {
		return seatsNum;
	}
	public void setSeatsNum(Integer seatsNum) {
		this.seatsNum = seatsNum;
	}
	
	
	
	
}
