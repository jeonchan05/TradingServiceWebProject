package com.final_project.stock.dto;

public class ShinFoodPredictDto {
	
	private String shinfoodpreddate;
	private String shinfoodpredresult;
	
	public String getShinfoodpreddate() {
		return shinfoodpreddate;
	}
	public void setShinfoodpreddate(String shinfoodpreddate) {
		this.shinfoodpreddate = shinfoodpreddate;
	}
	public String getShinfoodpredresult() {
		return shinfoodpredresult;
	}
	public void setShinfoodpredresult(String shinfoodpredresult) {
		this.shinfoodpredresult = shinfoodpredresult;
	}
	
	@Override
	public String toString() {
		return "ShinFoodPredictDto [shinfoodpreddate=" + shinfoodpreddate + ", shinfoodpredresult=" + shinfoodpredresult
				+ "]";
	}

	

}
