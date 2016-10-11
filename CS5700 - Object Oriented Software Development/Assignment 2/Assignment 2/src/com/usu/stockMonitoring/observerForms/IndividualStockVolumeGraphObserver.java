package com.usu.stockMonitoring.observerForms;
import com.usu.stocks.Stock;
import com.usu.stocks.subjectObserver.StocksObserver;

public class IndividualStockVolumeGraphObserver extends StocksObserver {

	public IndividualStockVolumeGraphObserver(Stock stock) {
		super(stock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		stock=null;//need to assign values later
	}
}