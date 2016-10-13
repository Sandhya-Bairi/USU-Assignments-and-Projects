package com.usu.stocks.subjectObserver;

import com.usu.stockMonitoring.forms.StockPriceMonitoringSystemControlForm;
import com.usu.stocks.Stock;

public abstract class StocksObserver extends StockPriceMonitoringSystemControlForm {

	public StockSubject stock;
	
	private int observerId = 0;

	public abstract void update();
	
	public StocksObserver(Stock stock) {
		observerId++;
		this.stock = stock;
		stock.registerStockOberserver(this);
	}
}