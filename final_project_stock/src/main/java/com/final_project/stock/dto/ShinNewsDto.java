package com.final_project.stock.dto;

public class ShinNewsDto {
	
	private int shinnum;
	private String shindate;
	private String shintitle;
	private String shincontent;
	private String shinpn;
	
	public int getShinnum() {
		return shinnum;
	}
	public void setShinnum(int shinnum) {
		this.shinnum = shinnum;
	}
	public String getShindate() {
		return shindate;
	}
	public void setShindate(String shindate) {
		this.shindate = shindate;
	}
	public String getShintitle() {
		return shintitle;
	}
	public void setShintitle(String shintitle) {
		this.shintitle = shintitle;
	}
	public String getShincontent() {
		return shincontent;
	}
	public void setShincontent(String shincontent) {
		this.shincontent = shincontent;
	}
	public String getShinpn() {
		return shinpn;
	}
	public void setShinpn(String shinpn) {
		this.shinpn = shinpn;
	}
	
	@Override
	public String toString() {
		return "ShinNewsDto [shinnum=" + shinnum + ", shindate=" + shindate + ", shintitle=" + shintitle
				+ ", shincontent=" + shincontent + ", shinpn=" + shinpn + "]";
	}
	
	

}
