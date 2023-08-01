package com.final_project.stock.dto;

public class StockProfitDto {
	private String Datetime;
	private String shinprofit;
	private String shinfoodprofit;
	private String emartprofit;
	
	
	public String getDatetime() {
		return Datetime;
	}
	public void setDatetime(String datetime) {
		Datetime = datetime;
	}
	public String getShinprofit() {
		return shinprofit;
	}
	public void setShinprofit(String shinprofit) {
		this.shinprofit = shinprofit;
	}
	public String getShinfoodprofit() {
		return shinfoodprofit;
	}
	public void setShinfoodprofit(String shinfoodprofit) {
		this.shinfoodprofit = shinfoodprofit;
	}
	public String getEmartprofit() {
		return emartprofit;
	}
	public void setEmartprofit(String emartprofit) {
		this.emartprofit = emartprofit;
	}
	
	@Override
	public String toString() {
		return "StockProfitDto [Datetime=" + Datetime + ", shinprofit=" + shinprofit + ", shinfoodprofit="
				+ shinfoodprofit + ", emartprofit=" + emartprofit + "]";
	}
	
	

}
