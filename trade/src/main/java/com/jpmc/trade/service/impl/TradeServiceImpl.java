package com.jpmc.trade.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jpmc.trade.dao.TradeDao;
import com.jpmc.trade.domain.Trade;
import com.jpmc.trade.enums.BuySellIndicator;
import com.jpmc.trade.service.TradeService;
import com.jpmc.trade.util.TradeComparator;

public class TradeServiceImpl implements TradeService {
	
	private TradeDao tradeDao;
	
	

	public TradeServiceImpl(TradeDao tradeDao) {
		this.tradeDao = tradeDao;
	}

	public void createTrade(Trade trade) {
		tradeDao.createTrade(trade);
	}

	public BigDecimal getAmountSettledByIndicator(BuySellIndicator buySellIndicator) {
		return tradeDao.getAmountSettledByIndicator(buySellIndicator);
	}

	public BigDecimal getAmountSettledByDateAndIndicator(Date settlementDate,
			BuySellIndicator buySellIndicator) {
		return tradeDao.getAmountSettledByDateAndIndicator(settlementDate, buySellIndicator);
	}

	public List<Trade> getTradeDetailsBasedOnRanking(BuySellIndicator buySellIndicator) {
		List<Trade> tradesList = tradeDao.getTradeDetailsByIndicator(buySellIndicator);
		if(tradesList!=null) {
			Collections.sort(tradesList, new TradeComparator());
		}
		return tradesList;
	}

	public Map<String, BigDecimal> getSettledAmountByDate(Date settlementDate) {
		Map<String, BigDecimal> settledAmountMap = new HashMap<String, BigDecimal>();
		BigDecimal incomingAmount = this.getAmountSettledByDateAndIndicator(settlementDate, BuySellIndicator.S);
		BigDecimal outgoingAmount = this.getAmountSettledByDateAndIndicator(settlementDate, BuySellIndicator.B);
		settledAmountMap.put("IncomingAmount", incomingAmount);
		settledAmountMap.put("OutgoingAmount", outgoingAmount);
		return settledAmountMap;
	}

}
