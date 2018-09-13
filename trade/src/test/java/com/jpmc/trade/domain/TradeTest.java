package com.jpmc.trade.domain;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.jpmc.trade.enums.BuySellIndicator;
import com.jpmc.trade.enums.Currency;
import com.jpmc.trade.util.TradeUtil;

public class TradeTest {


	@Test
	public void testTradeAmountForSGP() {
		Trade trade = new Trade("bar", BuySellIndicator.S, new BigDecimal("0.22"), Currency.AED, 
				TradeUtil.getDate(2018, 9, 13), TradeUtil.getDate(2018, 9, 13), 450, new BigDecimal("150.5"));
		BigDecimal amount = trade.getTradeAmountInUSD();
		assertEquals(new BigDecimal("14899.500"), amount);
	}	

}
