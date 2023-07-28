package com.final_project.stock.dto;

public class TradingHistoryDto {

	private String ordertime;
	private String excepttime;
	private String ordernum;
	private String stockname;
	private String orderprice;
	private String exceptprice;
	private String exceptqty;
	private String gubun;
	
	
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getExcepttime() {
		return excepttime;
	}
	public void setExcepttime(String excepttime) {
		this.excepttime = excepttime;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public String getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(String orderprice) {
		this.orderprice = orderprice;
	}
	public String getExceptprice() {
		return exceptprice;
	}
	public void setExceptprice(String exceptprice) {
		this.exceptprice = exceptprice;
	}
	public String getExceptqty() {
		return exceptqty;
	}
	public void setExceptqty(String exceptqty) {
		this.exceptqty = exceptqty;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	@Override
	public String toString() {
		return "TradingHistoryDto [ordertime=" + ordertime + ", excepttime=" + excepttime + ", ordernum=" + ordernum
				+ ", stockname=" + stockname + ", orderprice=" + orderprice + ", exceptprice=" + exceptprice
				+ ", exceptqty=" + exceptqty + ", gubun=" + gubun + "]";
	}
	
	

	
}
