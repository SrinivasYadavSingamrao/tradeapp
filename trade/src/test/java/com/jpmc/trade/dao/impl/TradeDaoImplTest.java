package com.jpmc.trade.dao.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jpmc.trade.dao.TradeDao;
import com.jpmc.trade.domain.Trade;
import com.jpmc.trade.enums.BuySellIndicator;
import com.jpmc.trade.enums.Currency;
import com.jpmc.trade.util.TradeUtil;

public class TradeDaoImplTest {

	TradeDao tradeDao;
	
	@Before
	public void setUp() throws Exception {
		
		tradeDao = new TradeDaoImpl();
		
		Trade trade = new Trade("foo1", BuySellIndicator.B, new BigDecimal("0.50"), Currency.SGP, 
				TradeUtil.getDate(2018, 9, 9), TradeUtil.getDate(2018, 9, 9), 200, new BigDecimal("100.25"));
		tradeDao.createTrade(trade);
		
		trade = new Trade("bar1", BuySellIndicator.S, new BigDecimal("0.22"), Currency.AED, 
				TradeUtil.getDate(2018, 9, 13), TradeUtil.getDate(2018, 9, 13), 450, new BigDecimal("150.5"));
		tradeDao.createTrade(trade);
		
		trade = new Trade("foo2", BuySellIndicator.B, new BigDecimal("0.50"), Currency.SGP, 
				TradeUtil.getDate(2018, 9, 9), TradeUtil.getDate(2018, 9, 9), 300, new BigDecimal("100.25"));
		tradeDao.createTrade(trade);
		
		trade = new Trade("bar2", BuySellIndicator.S, new BigDecimal("0.22"), Currency.AED, 
				TradeUtil.getDate(2018, 9, 13), TradeUtil.getDate(2018, 9, 7), 550, new BigDecimal("150.5"));
		tradeDao.createTrade(trade);
		
		trade = new Trade("foo3", BuySellIndicator.B, new BigDecimal("0.50"), Currency.SGP, 
				TradeUtil.getDate(2018, 9, 9), TradeUtil.getDate(2018, 9, 9), 400, new BigDecimal("100.25"));
		tradeDao.createTrade(trade);
		
		trade = new Trade("bar3", BuySellIndicator.S, new BigDecimal("0.22"), Currency.AED, 
				TradeUtil.getDate(2018, 9, 13), TradeUtil.getDate(2018, 9, 13), 650, new BigDecimal("150.5"));
		tradeDao.createTrade(trade);
		
		trade = new Trade("foo4", BuySellIndicator.B, new BigDecimal("0.50"), Currency.SGP, 
				TradeUtil.getDate(2018, 9, 9), TradeUtil.getDate(2018, 9, 9), 500, new BigDecimal("100.25"));
		tradeDao.createTrade(trade);
		
		trade = new Trade("bar4", BuySellIndicator.S, new BigDecimal("0.22"), Currency.AED, 
				TradeUtil.getDate(2018, 9, 13), TradeUtil.getDate(2018, 9, 13), 750, new BigDecimal("150.5"));
		tradeDao.createTrade(trade);
	
	}

	@Test
	public void testAmountSettledforBuy() {
		BigDecimal amount = tradeDao.getAmountSettledByIndicator(BuySellIndicator.B);
		assertEquals(new BigDecimal("70175.0000"), amount);
	}

	@Test
	public void testAmountSettledforSell() {
		BigDecimal amount = tradeDao.getAmountSettledByIndicator(BuySellIndicator.S);
		assertEquals(new BigDecimal("79464.000"), amount);
	}
	
	@Test
	public void testAmountSettledOnGivenDate() {
		BigDecimal amount = tradeDao.getAmountSettledByDateAndIndicator(TradeUtil.getDate(2018, 9, 9), BuySellIndicator.S);
		assertEquals(new BigDecimal("18210.500"), amount);
	}
	
	@Test
	public void testTradeDetailsByIndicator() {
		List<Trade> tradeList = tradeDao.getTradeDetailsByIndicator(BuySellIndicator.S);
		assertNotNull(tradeList);
		assertEquals(4, tradeList.size());
	}
}
