package com.jpmc.trade.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jpmc.trade.domain.Trade;
import com.jpmc.trade.enums.BuySellIndicator;

public interface TradeService {

	void createTrade(Trade trade);

	BigDecimal getAmountSettledByIndicator(BuySellIndicator buySellIndicator);
	
	BigDecimal getAmountSettledByDateAndIndicator(Date settlementDate, BuySellIndicator buySellIndicator);

	List<Trade> getTradeDetailsBasedOnRanking(BuySellIndicator buySellIndicator);
	
	Map<String, BigDecimal> getSettledAmountByDate(Date settlementDate);
	
}
