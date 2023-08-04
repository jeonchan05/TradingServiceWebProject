package com.final_project.stock.dto;

public class ShinPredictDto {
	private String shinpreddate;
	private String shinpredresult;
	
	public String getShinpreddate() {
		return shinpreddate;
	}
	public void setShinpreddate(String shinpreddate) {
		this.shinpreddate = shinpreddate;
	}
	public String getShinpredresult() {
		return shinpredresult;
	}
	public void setShinpredresult(String shinpredresult) {
		this.shinpredresult = shinpredresult;
	}
	
	@Override
	public String toString() {
		return "ShinPredictDto [shinpreddate=" + shinpreddate + ", shinpredresult=" + shinpredresult + "]";
	}
	
	
}
