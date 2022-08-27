package com.vicky.tsai.coinApiConvert.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "currency")
public class Currency {
	@Id
	@Column(name = "currency", nullable = false)
	String currency;
	
	@Column(name = "zhname", nullable = false)
	String zhname;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getZhname() {
		return zhname;
	}

	public void setZhname(String zhname) {
		this.zhname = zhname;
	}

	public Currency(String currency, String zhname) {
		super();
		this.currency = currency;
		this.zhname = zhname;
	}

	public Currency() {
		super();
	}

	@Override
	public String toString() {
		return "Currency [currency=" + currency + ", zhname=" + zhname + "]";
	}
	
	
}
