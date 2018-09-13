package com.jpmc.trade;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.jpmc.trade.dao.TradeDao;
import com.jpmc.trade.dao.impl.TradeDaoImpl;
import com.jpmc.trade.domain.Trade;
import com.jpmc.trade.enums.BuySellIndicator;
import com.jpmc.trade.enums.Currency;
import com.jpmc.trade.service.TradeService;
import com.jpmc.trade.service.impl.TradeServiceImpl;
import com.jpmc.trade.util.TradeUtil;


public class App 
{
    public static void main( String[] args )
    {
        TradeDao tradeDao = new TradeDaoImpl();
        TradeService tradeService = new TradeServiceImpl(tradeDao);
        
		Trade trade = new Trade("foo1", BuySellIndicator.B, new BigDecimal("0.50"), Currency.SGP, 
				TradeUtil.getDate(2018, 9, 11), TradeUtil.getDate(2018, 9, 11), 200, new BigDecimal("100.25"));
		tradeService.createTrade(trade);
		
		trade = new Trade("bar1", BuySellIndicator.S, new BigDecimal("0.22"), Currency.AED, 
				TradeUtil.getDate(2018, 9, 11), TradeUtil.getDate(2018, 9, 11), 450, new BigDecimal("150.5"));
		tradeService.createTrade(trade);
		
		trade = new Trade("foo2", BuySellIndicator.B, new BigDecimal("0.50"), Currency.SGP, 
				TradeUtil.getDate(2018, 9, 11), TradeUtil.getDate(2018, 9, 11), 300, new BigDecimal("100.25"));
		tradeService.createTrade(trade);
		
		trade = new Trade("bar2", BuySellIndicator.S, new BigDecimal("0.22"), Currency.AED, 
				TradeUtil.getDate(2018, 9, 11), TradeUtil.getDate(2018, 9, 11), 550, new BigDecimal("150.5"));
		tradeService.createTrade(trade);
		
		trade = new Trade("foo3", BuySellIndicator.B, new BigDecimal("0.50"), Currency.SGP, 
				TradeUtil.getDate(2018, 9, 11), TradeUtil.getDate(2018, 9, 11), 400, new BigDecimal("100.25"));
		tradeService.createTrade(trade);
		
		trade = new Trade("bar3", BuySellIndicator.S, new BigDecimal("0.22"), Currency.AED, 
				TradeUtil.getDate(2018, 9, 11), TradeUtil.getDate(2018, 9, 11), 650, new BigDecimal("150.5"));
		tradeService.createTrade(trade);
		
		trade = new Trade("foo4", BuySellIndicator.B, new BigDecimal("0.50"), Currency.SGP, 
				TradeUtil.getDate(2018, 9, 11), TradeUtil.getDate(2018, 9, 11), 500, new BigDecimal("100.25"));
		tradeService.createTrade(trade);
		
		trade = new Trade("bar4", BuySellIndicator.S, new BigDecimal("0.22"), Currency.AED, 
				TradeUtil.getDate(2018, 9, 11), TradeUtil.getDate(2018, 9, 11), 750, new BigDecimal("150.5"));
		tradeService.createTrade(trade);
		
		Map<String, BigDecimal> settledAmountMap = tradeService.getSettledAmountByDate(TradeUtil.getDate(2018, 9, 11));
		System.out.println(settledAmountMap);
		
		List<Trade> incomingTradeRecords = tradeService.getTradeDetailsBasedOnRanking(BuySellIndicator.S);
		System.out.println("Incoming Trades In Order of Rank");
		for(Trade incomingTrade : incomingTradeRecords){
			System.out.println(incomingTrade.getEntity());
		}
		
		List<Trade> outgoingTradeRecords = tradeService.getTradeDetailsBasedOnRanking(BuySellIndicator.B);
		System.out.println("Outgoing Trades In Order of Rank");
		for(Trade outgoingTrade : outgoingTradeRecords){
			System.out.println(outgoingTrade.getEntity());
		}
		
		
    }
}
