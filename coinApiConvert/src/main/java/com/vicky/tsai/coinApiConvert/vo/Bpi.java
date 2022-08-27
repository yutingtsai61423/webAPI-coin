package com.vicky.tsai.coinApiConvert.vo;

import org.springframework.stereotype.Component;

@Component
public class Bpi {
	Coin USD;
	Coin GBP;
	Coin EUR;
	public Coin getUSD() {
		return USD;
	}
	public void setUSD(Coin uSD) {
		USD = uSD;
	}
	public Coin getGBP() {
		return GBP;
	}
	public void setGBP(Coin gBP) {
		GBP = gBP;
	}
	public Coin getEUR() {
		return EUR;
	}
	public void setEUR(Coin eUR) {
		EUR = eUR;
	}
	public Bpi(Coin uSD, Coin gBP, Coin eUR) {
		super();
		USD = uSD;
		GBP = gBP;
		EUR = eUR;
	}
	public Bpi() {
		super();
	}
	@Override
	public String toString() {
		return "Bpi [USD=" + USD + ", GBP=" + GBP + ", EUR=" + EUR + "]";
	}
	
	
}
