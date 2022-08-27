package com.vicky.tsai.coinApiConvert.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.vicky.tsai.coinApiConvert.dao.CurrencyDao;
import com.vicky.tsai.coinApiConvert.vo.Currency;

@SpringBootTest
public class CurrencyServiceTest {

	@Autowired
	CurrencyDao currencyDao;
	
	@Autowired
	CurrencyService currencyService;
	
	//1. 測試呼叫查詢幣別對應表資料 API，並顯示其內容
	@Test
	void getOne() {
		System.out.println(currencyService.getOne("USD"));
	}
	
	@Test
	void gelALLTest() {
		System.out.println(currencyService.getALL());
	}
	
	//2. 測試呼叫新增幣別對應表資料 API。
	@Test
	void insertTest() {
		Currency currency = new Currency("NTD", "台幣");
		currencyService.insert(currency);
		System.out.println(currencyService.getALL());
	} 
	
	//3. 測試呼叫更新幣別對應表資料 API，並顯示其內容。
	@Test
	void updateTest() {
		Currency currency2 = new Currency("USD", "新美金");
		currencyService.update(currency2);
		System.out.println(currencyService.getOne("USD"));
	}
	

	//4. 測試呼叫刪除幣別對應表資料 API
	@Test
	void deleteTest() {
		currencyService.delete("USD");
		System.out.println(currencyService.getALL());
	}
}
