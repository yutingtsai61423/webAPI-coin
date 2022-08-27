package com.vicky.tsai.coinApiConvert.vo;

import org.springframework.stereotype.Component;

@Component
public class CoinWithName {
	String name;
	String rate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "CoinWithName [name=" + name + ", rate=" + rate + "]";
	}
	public CoinWithName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CoinWithName(String name, String rate) {
		super();
		this.name = name;
		this.rate = rate;
	}
	
	
}
