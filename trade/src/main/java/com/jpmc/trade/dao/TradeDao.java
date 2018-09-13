package com.jpmc.trade.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.jpmc.trade.domain.Trade;
import com.jpmc.trade.enums.BuySellIndicator;

public interface TradeDao {

	void createTrade(Trade trade);

	BigDecimal getAmountSettledByIndicator(BuySellIndicator buySellIndicator);
	
	BigDecimal getAmountSettledByDateAndIndicator(Date settlementDate, BuySellIndicator buySellIndicator);

	List<Trade> getTradeDetailsByIndicator(BuySellIndicator buySellIndicator);

	
}
