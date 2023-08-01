package com.final_project.stock.dto;

public class EmartNewsDto {
	private int emartnum;
	private String emartdate;
	private String emarttitle;
	private String emartcontent;
	private String emartpn;
	
	public int getEmartnum() {
		return emartnum;
	}
	public void setEmartnum(int emartnum) {
		this.emartnum = emartnum;
	}
	public String getEmartdate() {
		return emartdate;
	}
	public void setEmartdate(String emartdate) {
		this.emartdate = emartdate;
	}
	public String getEmarttitle() {
		return emarttitle;
	}
	public void setEmarttitle(String emarttitle) {
		this.emarttitle = emarttitle;
	}
	public String getEmartcontent() {
		return emartcontent;
	}
	public void setEmartcontent(String emartcontent) {
		this.emartcontent = emartcontent;
	}
	public String getEmartpn() {
		return emartpn;
	}
	public void setEmartpn(String emartpn) {
		this.emartpn = emartpn;
	}
	
	@Override
	public String toString() {
		return "EmartNewsDto [emartnum=" + emartnum + ", emartdate=" + emartdate + ", emarttitle=" + emarttitle
				+ ", emartcontent=" + emartcontent + ", emartpn=" + emartpn + "]";
	}
	
	
	
}
