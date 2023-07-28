package com.final_project.stock.dto;

public class StockPriceShinDto {

	private String ShinClosePrice;
	
	public String getShinClosePrice() {
		return ShinClosePrice;
	}

	public void setShinClosePrice(String shinClosePrice) {
		ShinClosePrice = shinClosePrice;
	}

	@Override
	public String toString() {
		return ShinClosePrice ;
	}

}
