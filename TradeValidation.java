package com.trade.trade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TradeValidation {
	// for Data Base will maintain list

	TradeStore trade1 = new TradeStore();
	TradeStore trade2 = new TradeStore();
	TradeStore trade3 = new TradeStore();
	Date todayDate =new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
	
	ArrayList<TradeStore> listOftrade = new ArrayList<>();
	
	{
		// first trade in database
		trade1.setTrade_Id("T1");
		trade1.setBook_Id("B1");
		trade1.setVersion(2);
		trade1.setCounterParty_Id("CP-1");
		trade1.setCreated_Date(new Date());
		try {
			trade1.setMaturity_Date(formatter.parse("20/05/2020"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trade1.setExpired("N");

		// second trade in database
		trade2.setTrade_Id("T2");
		trade2.setBook_Id("B2");
		trade2.setVersion(3);
		trade2.setCounterParty_Id("CP-2");
		trade2.setCreated_Date(new Date());
		try {
			trade2.setMaturity_Date(formatter.parse("20/05/2021"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trade2.setExpired("N");

		// third trade in Database
		trade3.setTrade_Id("T3");
		trade3.setBook_Id("B3");
		trade3.setVersion(4);
		trade3.setCounterParty_Id("CP-3");
		trade3.setCreated_Date(new Date());
		try {
			trade3.setMaturity_Date(formatter.parse("20/05/2014"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trade3.setExpired("N");

		listOftrade.add(trade1);
		listOftrade.add(trade2);
		listOftrade.add(trade3);
		
		
		
	}

	public String transmission(TradeStore trade) throws ParseException {
		 Date today=formatter.parse(formatter.format(new Date()));
        if(trade.getMaturity_Date().compareTo(today)<0) {
        	return "Rejected";
        	
        }else if (checkVersion(trade.getVersion(),trade) == 1) {
			return "Updated";

		}else {
			listOftrade.add(trade);
		}
		return "Success";

	}

	private Integer checkVersion(Integer version, TradeStore trade) {
		for (TradeStore tradeStore : listOftrade) {

			if (tradeStore.getVersion() > version) {
				throw new RuntimeException("lower Version");
			} else if (tradeStore.getVersion() == version) {
				tradeStore=trade;
				return 1;
			}

		}
		return 2;
	}
	public Boolean UpdateExpiry() {
		Boolean flag=false;
		for (TradeStore tradeStore : listOftrade) {
			if(tradeStore.getMaturity_Date().compareTo(new Date())>0) {
				tradeStore.setExpired("Y");
				return true;
			}
			
		}
		return flag ;
		
	}
}
