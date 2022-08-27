package com.vicky.tsai.coinApiConvert.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Component
public class Time {
//	@JsonSerialize(using = LocalDateTimeSerializer.class)
//	@JsonFormat(locale = "en", timezone = "GMT+8",*/ pattern ="MMM dd, yyyy HH:mm:ss z")
//	LocalDateTime  updated;
//	
//	@JsonSerialize(using = LocalDateTimeSerializer.class)
//	@JsonFormat(locale = "en", timezone = "GMT+8", pattern ="yyyy-MM-dd'T'HH:mm:ssXXX")
//	
//	LocalDateTime updatedISO;
//	@JsonSerialize(using = LocalDateTimeSerializer.class)
//	@JsonFormat(locale = "en", timezone = "GMT", pattern ="MMM dd, yyyy 'at' HH:mm z")
//	LocalDateTime updateduk;
	
	String updated;
	String updatedISO;
	String updateduk;
	
	

	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getUpdatedISO() {
		return updatedISO;
	}
	public void setUpdatedISO(String updatedISO) {
		this.updatedISO = updatedISO;
	}
	public String getUpdateduk() {
		return updateduk;
	}
	public void setUpdateduk(String updateduk) {
		this.updateduk = updateduk;
	}
	public Time() {
		super();
	}
//	public LocalDateTime getUpdated() {
//		return updated;
//	}
//	public void setUpdated(LocalDateTime updated) {
//		this.updated = updated;
//	}
//	public LocalDateTime getUpdatedISO() {
//		return updatedISO;
//	}
//	public void setUpdatedISO(LocalDateTime updatedISO) {
//		this.updatedISO = updatedISO;
//	}
//	public LocalDateTime getUpdateduk() {
//		return updateduk;
//	}
//	public void setUpdateduk(LocalDateTime updateduk) {
//		this.updateduk = updateduk;
//	}
	@Override
	public String toString() {
		return "Time [updated=" + updated + ", updatedISO=" + updatedISO + ", updateduk=" + updateduk + "]";
	}
	
	
}
