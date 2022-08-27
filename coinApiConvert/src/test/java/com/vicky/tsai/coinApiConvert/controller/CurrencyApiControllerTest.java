package com.vicky.tsai.coinApiConvert.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vicky.tsai.coinApiConvert.service.CurrencyService;
import com.vicky.tsai.coinApiConvert.vo.Currency;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyApiControllerTest {
	@Autowired
	MockMvc mockMvc;

//	//1. 測試呼叫查詢幣別對應表資料 API，並顯示其內容
//	@Test
//	void getOneTest() {
//		String url = "/api/currencyapi/get/USD";
//		HttpHeaders headers = new HttpHeaders();
//		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url)
//		.headers(headers);
//		
//	    try {
//			mockMvc.perform(requestBuilder)
//			.andDo(print())
//			.andReturn();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	//2. 測試呼叫新增幣別對應表資料 API。
//	@Test
//	void insertTest() {
//		try {
//			String url = "/api/currencyapi/insert";
//			Currency currency = new Currency("NTD", "台幣");
//			HttpHeaders headers = new HttpHeaders();
//			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//			RequestBuilder requestBuilder = MockMvcRequestBuilders.post(url)
//														.headers(headers)
//														.content(new ObjectMapper().writeValueAsString(currency));
//			
//			mockMvc.perform(requestBuilder)
//				.andDo(print())
//				.andReturn();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	


//	// 3. 測試呼叫更新幣別對應表資料 API，並顯示其內容。
//	@Test
//	void updateTest() {
//		try {
//			String url = "/api/currencyapi/update";
//			Currency currency = new Currency("USD", "新美金");
//			HttpHeaders headers = new HttpHeaders();
//			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//			RequestBuilder requestBuilder = MockMvcRequestBuilders.post(url)
//														.headers(headers)
//														.content(new ObjectMapper().writeValueAsString(currency));
//			
//			mockMvc.perform(requestBuilder)
//				.andDo(print())
//				.andReturn();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
//	//4. 測試呼叫刪除幣別對應表資料 API
//	@Test
//	void deleteTest() {
//		String url = "/api/currencyapi/delete/USD";
//		HttpHeaders headers = new HttpHeaders();
//		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url)
//																.headers(headers);
//		
//	    try {
//			mockMvc.perform(requestBuilder)
//			.andDo(print())
//			.andReturn();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Autowired
	CurrencyService currencyService;
	
//  //5. 測試呼叫 coindesk API，並顯示其內容。
	@Test
	void testCoinApi() {
		System.out.println(currencyService.callCoindeskAPI());
	}
	
//	//6. 測試呼叫資料轉換的 API，並顯示其。容。	
	@Test
	void convertTset() {
		String url = "/api/currencyapi/convert";
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url)
																.headers(headers);
		
	    try {
			mockMvc.perform(requestBuilder)
			.andDo(print())
			.andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
