package com.trade.trade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TradestoreApplicationTests {
	TradeValidation tradeValidation = new TradeValidation();
	TradeStore trade1 = new TradeStore();
	TradeStore trade2 = new TradeStore();
	TradeStore trade3 = new TradeStore();
	TradeStore trade4 = new TradeStore();
	SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
	ArrayList<TradeStore> listOftrade = new ArrayList<>();

	@BeforeEach
	public void setUp() {
		// first trade
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

		// second trade
		trade2.setTrade_Id("T2");
		trade2.setBook_Id("B2");
		trade2.setVersion(1);
		trade2.setCounterParty_Id("CP-2");
		trade2.setCreated_Date(new Date());
		try {
			trade2.setMaturity_Date(formatter.parse("20/05/2021"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trade2.setExpired("N");

		// third trade
		trade3.setTrade_Id("T3");
		trade3.setBook_Id("B3");
		trade3.setVersion(3);
		trade3.setCounterParty_Id("CP-3");
		trade3.setCreated_Date(new Date());
		try {
			trade3.setMaturity_Date(formatter.parse("20/05/2025"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trade3.setExpired("N");

		listOftrade.add(trade1);
		listOftrade.add(trade2);
		listOftrade.add(trade3);

		// dummy object
		trade4.setTrade_Id("T4");
		trade4.setBook_Id("B4");
		trade4.setVersion(6);
		trade4.setCounterParty_Id("CP-4");
		trade4.setCreated_Date(new Date());
		try {
			trade4.setMaturity_Date(formatter.parse("20/05/2021"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trade4.setExpired("N");

		listOftrade.add(trade1);
		listOftrade.add(trade2);
		listOftrade.add(trade3);

	}

	@Test
	public void test_Transmission_SuccessfulTrade_Return_Success() throws ParseException {
		String actualValue = tradeValidation.transmission(trade4);
		 assertEquals("Success", actualValue);

	}
	
	
	
	
	@Test
	public void test_Transmission_Rejected_If_MaturityDate_LessThan_todayDate() throws ParseException {
		String actualValue = tradeValidation.transmission(trade1);
		 assertEquals("Rejected", actualValue);

	}
   
	
	@Test
	public void test_Transmission_UpdatedRecords_If_Version_matched_Return_Updated() throws ParseException {
		String actualValue = tradeValidation.transmission(trade3);
		 assertEquals("Updated", actualValue);

	}
	
	@Test
	public void test_Transmission_For_Version_Is_lower_throw_Exception() throws ParseException {
		try {
		String actualValue = tradeValidation.transmission(trade2);
		}catch (Exception e) {
			e.printStackTrace();
		}
	

	}
	
	
	
}
