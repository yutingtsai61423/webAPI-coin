package com.vicky.tsai.coinApiConvert.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.vicky.tsai.coinApiConvert.controller.JavaScriptMessageConverter;
import com.vicky.tsai.coinApiConvert.dao.CurrencyDao;
import com.vicky.tsai.coinApiConvert.vo.Coin;
import com.vicky.tsai.coinApiConvert.vo.CoinWithName;
import com.vicky.tsai.coinApiConvert.vo.Currency;
import com.vicky.tsai.coinApiConvert.vo.Currentprice;

@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {
	@Autowired
	CurrencyDao currencyDao;
	
	
	//呼叫coindeskAPI
	@Override
	public Currentprice callCoindeskAPI() {
		String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
		System.out.println("here");
		
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.getMessageConverters().add(new JavaScriptMessageConverter());
		
		Currentprice result = restTemplate.getForObject(url, Currentprice.class);
		return result;
	}
	
	//呼叫coindeskAPI並轉換
	@Override
	public Map<String, Object> convert() {
		Currentprice currentprice = callCoindeskAPI();
		Map<String, Object> map = new HashMap<>();
				
		map.put("更新時間", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
		
		Map<String, Coin> bpi = currentprice.getBpi();
		for(Entry<String, Coin> entry: bpi.entrySet()) {
			String name = entry.getKey();
			CoinWithName coinWithName = new CoinWithName(getOne(name).getZhname(), entry.getValue().getRate());
			map.put(name,coinWithName );
		}
			
		return map;
		
	}
	
	//查詢幣別
	@Override
	public List<Currency> getALL() {
		return	currencyDao.findAll();
	}
	//新增幣別
	@Override
	public void insert(Currency currency) {
		Optional<Currency> old = getALL().stream()
									.filter(c -> c.getCurrency().equals(currency.getCurrency()))
									.findFirst();
		if(old.isEmpty())
		currencyDao.save(currency);
	}
	//刪除幣別
	@Override
	public void delete(String idname) {
		currencyDao.deleteById(idname);
	}

	//修改幣別
	@Override
	public void update(Currency currency) {
		if(currency == null)
			return;
		Optional<Currency> cur = currencyDao.findById(currency.getCurrency());
		Currency update = cur.get();
		update.setCurrency(currency.getCurrency());
		update.setZhname(currency.getZhname());
		currencyDao.save(update);
	}
	
	//查詢指定幣別
	@Override
	public Currency getOne(String idname) {
		Optional<Currency> cur = currencyDao.findById(idname);
		return  cur.get();
	}

}
