package com.jpmc.trade.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.jpmc.trade.enums.BuySellIndicator;
import com.jpmc.trade.enums.Currency;

public class Trade {

	private String entity;
	private BuySellIndicator buySellIndicator;
	private BigDecimal agreedFx;
	private Currency currency;
	private Date instructionDate;
	private Date settlementDate;
	private long units;
	private BigDecimal pricePerUnit;
	

	public Trade(String entity, BuySellIndicator buySellIndicator, BigDecimal agreedFx,
			Currency currency, Date instructionDate, Date settlementDate,
			long units, BigDecimal pricePerUnit) {
		super();
		this.entity = entity;
		this.buySellIndicator = buySellIndicator;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
	}


	public String getEntity() {
		return entity;
	}


	public void setEntity(String entity) {
		this.entity = entity;
	}

	public BuySellIndicator getBuySellIndicator() {
		return buySellIndicator;
	}


	public void setBuySellIndicator(BuySellIndicator buySellIndicator) {
		this.buySellIndicator = buySellIndicator;
	}


	public BigDecimal getAgreedFx() {
		return agreedFx;
	}


	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}


	public Currency getCurrency() {
		return currency;
	}


	public void setCurrency(Currency currency) {
		this.currency = currency;
	}


	public Date getInstructionDate() {
		return instructionDate;
	}


	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}


	public Date getSettlementDate() {
		return settlementDate;
	}


	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}


	public long getUnits() {
		return units;
	}


	public void setUnits(long units) {
		this.units = units;
	}


	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}


	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	public BigDecimal getTradeAmountInUSD() {
		return pricePerUnit.multiply(agreedFx).multiply(BigDecimal.valueOf(units));
	}
	
}
