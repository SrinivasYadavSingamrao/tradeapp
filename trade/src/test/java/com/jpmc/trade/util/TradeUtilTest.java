package com.jpmc.trade.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.jpmc.trade.enums.Currency;

public class TradeUtilTest {

	@Test
	public void testSettlementDateByCurrency_AED_Saturday() {
		Date date = TradeUtil.getSettlementDate(Currency.AED, TradeUtil.getDate(2018, 9, 8));
		assertEquals(date, TradeUtil.getDate(2018, 9, 9));
	}

	@Test
	public void testSettlementDateByCurrency_SAR_Friday() {
		Date date = TradeUtil.getSettlementDate(Currency.SAR, TradeUtil.getDate(2018, 9, 7));
		assertEquals(date, TradeUtil.getDate(2018, 9, 9));
	}
	
	@Test
	public void testSettlementDateByCurrency_SGP_Sunday() {
		Date date = TradeUtil.getSettlementDate(Currency.SGP, TradeUtil.getDate(2018, 9, 9));
		assertEquals(date, TradeUtil.getDate(2018, 9, 10));
	}
	
	@Test
	public void testSettlementDateByCurrency_SGP_Tuesday() {
		Date date = TradeUtil.getSettlementDate(Currency.SGP, TradeUtil.getDate(2018, 9, 11));
		assertEquals(date, TradeUtil.getDate(2018, 9, 11));
	}
	
	@Test
	public void testSettlementDateByCurrency_SGP_Saturday() {
		Date date = TradeUtil.getSettlementDate(Currency.SGP, TradeUtil.getDate(2018, 9, 8));
		assertEquals(date, TradeUtil.getDate(2018, 9, 10));
	}
}
