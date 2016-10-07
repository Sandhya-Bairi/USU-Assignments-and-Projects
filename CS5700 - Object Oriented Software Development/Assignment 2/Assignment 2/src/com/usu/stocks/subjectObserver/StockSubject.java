package com.usu.stocks.subjectObserver;

public abstract class StockSubject {
	/**
	 * 
	 * @param addNewObserver
	 */
	public abstract void registerStockOberserver(StocksObserver addNewObserver);

	/**
	 * 
	 * @param deleteObserver
	 */
	public abstract void removeStockObserver(StocksObserver deleteObserver);

	/**
	 * 
	 */
	public abstract void notifyStockObserver();

}