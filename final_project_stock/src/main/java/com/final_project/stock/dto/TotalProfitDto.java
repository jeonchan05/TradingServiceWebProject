package com.final_project.stock.dto;

public class TotalProfitDto {
	
	private String Datetime;
	private String TotalProfit;
	
	public String getDatetime() {
		return Datetime;
	}
	public void setDatetime(String datetime) {
		Datetime = datetime;
	}
	public String getTotalProfit() {
		return TotalProfit;
	}
	public void setTotalProfit(String totalProfit) {
		TotalProfit = totalProfit;
	}
	
	@Override
	public String toString() {
		return "TotalProfitDto [Datetime=" + Datetime + ", TotalProfit=" + TotalProfit + "]";
	}
	
}
