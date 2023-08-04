package com.final_project.stock.dto;

public class EmartPredictDto {
	
	private String emartpreddate;
	private String emartpredresult;
	
	public String getEmartpreddate() {
		return emartpreddate;
	}
	public void setEmartpreddate(String emartpreddate) {
		this.emartpreddate = emartpreddate;
	}
	public String getEmartpredresult() {
		return emartpredresult;
	}
	public void setEmartpredresult(String emartpredresult) {
		this.emartpredresult = emartpredresult;
	}
	
	@Override
	public String toString() {
		return "EmartPredictDto [emartpreddate=" + emartpreddate + ", emartpredresult=" + emartpredresult + "]";
	}

}
