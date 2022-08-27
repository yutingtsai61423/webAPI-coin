package com.vicky.tsai.coinApiConvert.service;

import java.util.List;
import java.util.Map;

import com.vicky.tsai.coinApiConvert.vo.Currency;
import com.vicky.tsai.coinApiConvert.vo.Currentprice;

public interface CurrencyService {
	List<Currency> getALL();
	
	void insert(Currency currency);
	
	void delete(String idname);
	
	void update(Currency currency);
	
	Currency getOne(String idname);
	
	Map<String, Object> convert();
	
	Currentprice callCoindeskAPI();
	
}
