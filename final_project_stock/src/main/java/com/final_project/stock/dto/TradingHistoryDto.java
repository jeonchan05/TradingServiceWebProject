package com.final_project.stock.dto;

public class TradingHistoryDto {

	private String datetime;
	private String odrnum;
	private String stcode;
	private String stname;
	private String odrqty;
	private String trallqty;
	private String trqty;
	private String trprice;
	private String odrgubun;
	private String trgubun
	
	
;
	public String getdatetime() {
		return datetime;
	}
	public void setdatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getOdrnum() {
		return odrnum;
	}
	public void setOdrnum(String odrnum) {
		this.odrnum = odrnum;
	}
	public String getStcode() {
		return stcode;
	}
	public void setStcode(String stcode) {
		this.stcode = stcode;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getOdrqty() {
		return odrqty;
	}
	public void setOdrqty(String odrqty) {
		this.odrqty = odrqty;
	}
	public String getTrallqty() {
		return trallqty;
	}
	public void setTrallqty(String tr_allqty) {
		this.trallqty = tr_allqty;
	}
	public String getTrqty() {
		return trqty;
	}
	public void setTrqty(String trqty) {
		this.trqty = trqty;
	}
	public String getTrprice() {
		return trprice;
	}
	public void setTrprice(String trprice) {
		this.trprice = trprice;
	}
	public String getOdrgubun() {
		return odrgubun;
	}
	public void setOdrgubun(String odrgubun) {
		this.odrgubun = odrgubun;
	}
	public String getTrgubun() {
		return trgubun;
	}
	public void setTrgubun(String trgubun) {
		this.trgubun = trgubun;
	}
	
	@Override
	public String toString() {
		return "TradingHistoryDto [datetime=" + datetime + ", odrnum=" + odrnum + ", stcode=" + stcode + ", stname="
				+ stname + ", odrqty=" + odrqty + ", trallqty=" + trallqty + ", trqty=" + trqty + ", trprice=" + trprice
				+ ", odrgubun=" + odrgubun + ", trgubun=" + trgubun + "]";
	}
	
}
