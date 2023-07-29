package com.final_project.stock.dto;

public class ExchangeDto {
	private String Date;
	private String USD;
	private String CNY;
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getUSD() {
		return USD;
	}
	public void setUSD(String uSD) {
		USD = uSD;
	}
	public String getCNY() {
		return CNY;
	}
	public void setCNY(String cNY) {
		CNY = cNY;
	}
	@Override
	public String toString() {
		return "ExchangeDto [Date=" + Date + ", USD=" + USD + ", CNY=" + CNY + "]";
	}
	
	
}
