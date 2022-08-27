package com.vicky.tsai.coinApiConvert.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vicky.tsai.coinApiConvert.service.CurrencyService;
import com.vicky.tsai.coinApiConvert.vo.Coin;
import com.vicky.tsai.coinApiConvert.vo.Currency;
import com.vicky.tsai.coinApiConvert.vo.Currentprice;


@RestController
@RequestMapping(path = {"/api/currencyapi"})
public class CurrencyApiController {
	@Autowired
	CurrencyService currencyService;
	
	//資料轉換的 API
	@GetMapping(path = {"/convert"})
	public Map<String, Object> convert(){
		try {
			return currencyService.convert();
		} catch (Exception e) {
			e.printStackTrace();
			return  null;
		}
	}
	
	//查詢幣別對應表資料 API
	@GetMapping(path = {"/get/{idname}"})
	public ResponseEntity<?> getOne(@PathVariable("idname") String idname){
		try {
			Currency info = currencyService.getOne(idname);
			ResponseEntity<Currency> response = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(info);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			ResponseEntity<String> response = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("exception: no value");
			return response;
		}
	}
	
	//刪除幣別對應表資料 API
	@GetMapping(path = {"/delete/{idname}"})
	public ResponseEntity<?> delete(@PathVariable("idname") String idname){
 		
		try {
			currencyService.delete(idname);
			ResponseEntity<String> response = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("success");
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			ResponseEntity<String> response = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("exception");

			return response;
		}
	}
	
	//新增幣別對應表資料 API
	@PostMapping(path = {"/insert"})
	public ResponseEntity<?> insert(@RequestBody Currency currency){
		try {
			System.out.println("currency = " + currency);
			currencyService.insert(currency);
			ResponseEntity<Currency> response = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(currency);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			ResponseEntity<String> response = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("exception");
			return response;
		}
	}
	
	//更新幣別對應表資料 API
	@PostMapping(path = {"/update"})
	public ResponseEntity<?> update(@RequestBody Currency currency){
		try {
			System.out.println("currency = " + currency);
			currencyService.update(currency);
			ResponseEntity<Currency> response = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(currency);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			ResponseEntity<String> response = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("exception: no value can update, please insert");
			return response;
		}
	}

	
	
}
