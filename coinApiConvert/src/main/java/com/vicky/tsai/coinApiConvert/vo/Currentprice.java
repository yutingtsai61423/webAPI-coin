package com.vicky.tsai.coinApiConvert.vo;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Currentprice {
	Time time;
	String disclaimer;
	String chartName;
	Map<String, Coin> bpi;
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	public String getChartName() {
		return chartName;
	}
	public void setChartName(String chartName) {
		this.chartName = chartName;
	}


	
	
	public Map<String, Coin> getBpi() {
		return bpi;
	}
	public void setBpi(Map<String, Coin> bpi) {
		this.bpi = bpi;
	}
	public Currentprice() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Currentprice [time=" + time + ", disclaimer=" + disclaimer + ", chartName=" + chartName + ", bpi=" + bpi
				+ "]";
	}
	
}
