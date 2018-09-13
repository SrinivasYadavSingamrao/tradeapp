package com.jpmc.trade.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.jpmc.trade.enums.Currency;

public class TradeUtil {

	public static Date getSettlementDate(Currency currency, Date settlementDate) {
		GregorianCalendar gc = new GregorianCalendar();
		
		if(settlementDate != null) {
			gc.setTime(settlementDate);
			
			if(currency == Currency.SGP){
				if(gc.get(Calendar.DAY_OF_WEEK) == 1){
					gc.set(Calendar.DAY_OF_YEAR, gc.get(Calendar.DAY_OF_YEAR)+1);
				}
				if(gc.get(Calendar.DAY_OF_WEEK) == 7){
					gc.set(Calendar.DAY_OF_YEAR, gc.get(Calendar.DAY_OF_YEAR)+2);
				}
			} else {
				if(gc.get(Calendar.DAY_OF_WEEK) == 6){
					gc.set(Calendar.DAY_OF_YEAR, gc.get(Calendar.DAY_OF_YEAR)+2);
				}
				if(gc.get(Calendar.DAY_OF_WEEK) == 7){
					gc.set(Calendar.DAY_OF_YEAR, gc.get(Calendar.DAY_OF_YEAR)+1);
				}
			}
		}
		
		return gc.getTime();
	}
	
	public static Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
