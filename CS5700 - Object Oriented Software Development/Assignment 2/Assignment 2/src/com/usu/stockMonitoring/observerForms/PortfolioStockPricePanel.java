package com.usu.stockMonitoring.observerForms;
import com.usu.stocks.Stock;
import com.usu.stocks.subjectObserver.StocksObserver;

public class PortfolioStockPricePanel extends StocksObserver {

	public PortfolioStockPricePanel(Stock stock) {
		super(stock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		stock=null;//need to assign values later
	}
}