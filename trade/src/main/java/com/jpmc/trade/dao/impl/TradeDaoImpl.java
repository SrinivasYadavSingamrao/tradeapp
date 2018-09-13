package com.jpmc.trade.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jpmc.trade.dao.TradeDao;
import com.jpmc.trade.domain.Trade;
import com.jpmc.trade.enums.BuySellIndicator;
import com.jpmc.trade.util.TradeUtil;

public class TradeDaoImpl implements TradeDao {

	private List<Trade> tradeList = new ArrayList<Trade>();
	
	
	public void createTrade(Trade trade) {
		//Persists if not null
		if(trade != null){
			tradeList.add(trade);
		}
	}

	public BigDecimal getAmountSettledByIndicator(BuySellIndicator buySellIndicator) {
		
		BigDecimal total = BigDecimal.ZERO;
		
		for(Trade trade : getTradeList()){
			if(trade.getBuySellIndicator() == buySellIndicator){
				total = total.add(trade.getTradeAmountInUSD());
			}
		}
		return total;
	}

	public BigDecimal getAmountSettledByDateAndIndicator(Date settlementDate, BuySellIndicator buySellIndicator) {
		
		BigDecimal total = BigDecimal.ZERO;
		
		for(Trade trade : getTradeList()){
			if (TradeUtil.getSettlementDate(trade.getCurrency(),
					trade.getSettlementDate()).equals(settlementDate)
					&& trade.getBuySellIndicator() == buySellIndicator) {
				total = total.add(trade.getTradeAmountInUSD());
			}
		}
		return total;
	}

	public List<Trade> getTradeList() {
		return tradeList;
	}

	public List<Trade> getTradeDetailsByIndicator(BuySellIndicator buySellIndicator) {
		List<Trade> tradesList = new ArrayList<Trade>();
		
		for(Trade trade : getTradeList()){
			if(trade.getBuySellIndicator() == buySellIndicator){
				tradesList.add(trade);
			}
		}
		return tradesList;
	}
	
}
