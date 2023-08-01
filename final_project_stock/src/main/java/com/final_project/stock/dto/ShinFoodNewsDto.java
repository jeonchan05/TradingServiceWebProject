package com.final_project.stock.dto;

public class ShinFoodNewsDto {
	private int shinfoodnum;
	private String shinfooddate;
	private String shinfoodtitle;
	private String shinfoodcontent;
	private String shinfoodpn;
	
	
	public int getShinfoodnum() {
		return shinfoodnum;
	}
	public void setShinfoodnum(int shinfoodnum) {
		this.shinfoodnum = shinfoodnum;
	}
	public String getShinfooddate() {
		return shinfooddate;
	}
	public void setShinfooddate(String shinfooddate) {
		this.shinfooddate = shinfooddate;
	}
	public String getShinfoodtitle() {
		return shinfoodtitle;
	}
	public void setShinfoodtitle(String shinfoodtitle) {
		this.shinfoodtitle = shinfoodtitle;
	}
	public String getShinfoodcontent() {
		return shinfoodcontent;
	}
	public void setShinfoodcontent(String shinfoodcontent) {
		this.shinfoodcontent = shinfoodcontent;
	}
	public String getShinfoodpn() {
		return shinfoodpn;
	}
	public void setShinfoodpn(String shinfoodpn) {
		this.shinfoodpn = shinfoodpn;
	}
	
	@Override
	public String toString() {
		return "ShinFoodNewsDto [shinfoodnum=" + shinfoodnum + ", shinfooddate=" + shinfooddate + ", shinfoodtitle="
				+ shinfoodtitle + ", shinfoodcontent=" + shinfoodcontent + ", shinfoodpn=" + shinfoodpn + "]";
	}
	
	

}
