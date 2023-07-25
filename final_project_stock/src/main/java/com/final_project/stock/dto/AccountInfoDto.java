package com.final_project.stock.dto;

public class AccountInfoDto {
	
	private String odrbqty;
	private String trbqty;
	private String avalpri;
	private String valgalo;
	private String garate;

	public String getOdrbqty() {
		return odrbqty;
	}

	public void setOdrbqty(String odrbqty) {
		this.odrbqty = odrbqty;
	}

	public String getTrbqty() {
		return trbqty;
	}

	public void setTrbqty(String trbqty) {
		this.trbqty = trbqty;
	}

	public String getAvalpri() {
		return avalpri;
	}

	public void setAvalpri(String avalpri) {
		this.avalpri = avalpri;
	}

	public String getValgalo() {
		return valgalo;
	}

	public void setValgalo(String valgalo) {
		this.valgalo = valgalo;
	}

	public String getGarate() {
		return garate;
	}

	public void setGarate(String garate) {
		this.garate = garate;
	}

	@Override
	public String toString() {
		return "AccountInfo [odrbqty=" + odrbqty + ", trbqty=" + trbqty + ", avalpri=" + avalpri + ", valgalo="
				+ valgalo + ", garate=" + garate + "]";
	}
	
}
