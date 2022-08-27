package com.vicky.tsai.coinApiConvert.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicky.tsai.coinApiConvert.vo.Currency;

public interface CurrencyDao extends JpaRepository<Currency, String> {

}
