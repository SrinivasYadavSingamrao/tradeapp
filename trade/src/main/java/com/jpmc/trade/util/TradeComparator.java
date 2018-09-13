package com.jpmc.trade.util;

import java.util.Comparator;

import com.jpmc.trade.domain.Trade;

public class TradeComparator implements Comparator<Trade> {

	public int compare(Trade trade1, Trade trade2) {
		return trade2.getTradeAmountInUSD().compareTo(trade1.getTradeAmountInUSD());
	}

	

}
