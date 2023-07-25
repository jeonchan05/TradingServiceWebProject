package com.final_project.stock.dto;

public class StockPriceEmartDto {
	private String EmartClosePrice;

	public String getEmartClosePrice() {
		return EmartClosePrice;
	}

	public void setEmartClosePrice(String emartClosePrice) {
		EmartClosePrice = emartClosePrice;
	}

	@Override
	public String toString() {
		return EmartClosePrice;
	}
}
