package com.usu.stocks.subjectObserver;

import com.usu.stockMonitoring.forms.StockPriceMonitoringSystemControlForm;

public abstract class StocksObserver extends StockPriceMonitoringSystemControlForm {

	StockSubject stock;

	public abstract void update();
}