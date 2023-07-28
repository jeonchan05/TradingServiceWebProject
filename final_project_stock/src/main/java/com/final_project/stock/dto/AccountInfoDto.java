package com.final_project.stock.dto;

public class AccountInfoDto {
	
	private String balanceevaluationamount;
	private String investmentincome;
	private String jejus;
	private String d1jejus;
	private String d2jejus;
	private String profitrate;
	
	public String getBalanceevaluationamount() {
		return balanceevaluationamount;
	}
	public void setBalanceevaluationamount(String balanceevaluationamount) {
		this.balanceevaluationamount = balanceevaluationamount;
	}
	public String getInvestmentincome() {
		return investmentincome;
	}
	public void setInvestmentincome(String investmentincome) {
		this.investmentincome = investmentincome;
	}
	public String getJejus() {
		return jejus;
	}
	public void setJejus(String jejus) {
		this.jejus = jejus;
	}
	public String getD1jejus() {
		return d1jejus;
	}
	public void setD1jejus(String d1jejus) {
		this.d1jejus = d1jejus;
	}
	public String getD2jejus() {
		return d2jejus;
	}
	public void setD2jejus(String d2jejus) {
		this.d2jejus = d2jejus;
	}
	public String getProfitrate() {
		return profitrate;
	}
	public void setProfitrate(String profitrate) {
		this.profitrate = profitrate;
	}
	
	@Override
	public String toString() {
		return "AccountInfoDto [balanceevaluationamount=" + balanceevaluationamount + ", investmentincome="
				+ investmentincome + ", jejus=" + jejus + ", d1jejus=" + d1jejus + ", d2jejus=" + d2jejus
				+ ", profitrate=" + profitrate + "]";
	}

	
	
	
}
