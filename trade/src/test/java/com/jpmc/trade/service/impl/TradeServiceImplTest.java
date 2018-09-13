package com.jpmc.trade.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jpmc.trade.dao.TradeDao;
import com.jpmc.trade.domain.Trade;
import com.jpmc.trade.enums.BuySellIndicator;
import com.jpmc.trade.enums.Currency;
import com.jpmc.trade.service.TradeService;
import com.jpmc.trade.util.TradeUtil;

@RunWith(MockitoJUnitRunner.class)
public class TradeServiceImplTest {

	@Mock
	TradeDao tradeDao;
	TradeService tradeService;
	
	
	@Before
	public void setUp() throws Exception {
		tradeService = new TradeServiceImpl(tradeDao);
	}

	
	@Test
	public void testAmountSettledforBuy() {
		when(tradeDao.getAmountSettledByIndicator(BuySellIndicator.B)).thenReturn(new BigDecimal("10050.50"));
		BigDecimal amount = tradeService.getAmountSettledByIndicator(BuySellIndicator.B);
		assertEquals(new BigDecimal("10050.50"),amount);
	}

	@Test
	public void testAmountSettledforSell() {
		when(tradeDao.getAmountSettledByIndicator(BuySellIndicator.S)).thenReturn(new BigDecimal("24550.50"));
		BigDecimal amount = tradeService.getAmountSettledByIndicator(BuySellIndicator.S);
		assertEquals(new BigDecimal("24550.50"),amount);
	}
	
	@Test
	public void testAmountSettledOnGivenDate() {
		when(tradeDao.getAmountSettledByDateAndIndicator(TradeUtil.getDate(2018, 9, 9), BuySellIndicator.S)).thenReturn(new BigDecimal("18210.500"));
		BigDecimal amount = tradeService.getAmountSettledByDateAndIndicator(TradeUtil.getDate(2018, 9, 9), BuySellIndicator.S);
		assertEquals(new BigDecimal("18210.500"), amount);
		
	}
	
	@Test
	public void testTradesDetailsBasedOnRanking() {
		List<Trade> tradeList = new ArrayList<Trade>();
		Trade trade = new Trade("foo1", BuySellIndicator.B, new BigDecimal("0.50"), Currency.SGP, 
				TradeUtil.getDate(2018, 9, 9), TradeUtil.getDate(2018, 9, 9), 200, new BigDecimal("100.25"));
		tradeList.add(trade);
		
		trade = new Trade("foo2", BuySellIndicator.B, new BigDecimal("0.50"), Currency.SGP, 
				TradeUtil.getDate(2018, 9, 9), TradeUtil.getDate(2018, 9, 9), 300, new BigDecimal("100.25"));
		tradeList.add(trade);
		
		when(tradeDao.getTradeDetailsByIndicator(BuySellIndicator.B)).thenReturn(tradeList);
		List<Trade> list = tradeService.getTradeDetailsBasedOnRanking(BuySellIndicator.B);
		assertEquals("foo2", list.get(0).getEntity());
	}

	@Test
	public void testSettledAmountByDate() {
		when(tradeDao.getAmountSettledByDateAndIndicator(TradeUtil.getDate(2018, 9, 9), BuySellIndicator.S)).thenReturn(new BigDecimal("18210.500"));
		when(tradeDao.getAmountSettledByDateAndIndicator(TradeUtil.getDate(2018, 9, 9), BuySellIndicator.B)).thenReturn(new BigDecimal("42350.500"));
		
		Map<String, BigDecimal> settledAmountMap = tradeService.getSettledAmountByDate(TradeUtil.getDate(2018, 9, 9));
		
		assertEquals(new BigDecimal("42350.500"), settledAmountMap.get("OutgoingAmount"));
		assertEquals(new BigDecimal("18210.500"), settledAmountMap.get("IncomingAmount"));
	}
}
