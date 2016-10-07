package com.usu.stocks;

import java.util.List;

import com.usu.simulatorCommunication.messages.TickerMessage;
import com.usu.stocks.subjectObserver.StockSubject;
import com.usu.stocks.subjectObserver.StocksObserver;

public class Stock extends StockSubject {

	private List<StocksObserver> stockObserverList;
	
	public String symbol;
    public long messageTimestamp;
    public int openingPrice;
    public int previousClosingPrice;
    public int currentPrice;
    public int bidPrice;
    public int askPrice;
    public int currentVolume;
    public int averageVolume;

	@Override
	public void registerStockOberserver(StocksObserver addNewObserver) {
		if(addNewObserver == null)
			throw new NullPointerException("Null Observer");
		synchronized (new Object()) {
			if(!stockObserverList.contains(addNewObserver))
				stockObserverList.add(addNewObserver);
		}
	}

	@Override
	public void removeStockObserver(StocksObserver deleteObserver) {
		synchronized (new Object()) {
			stockObserverList.remove(deleteObserver);
			}
	}

	@Override
	public void notifyStockObserver() {
		for (StocksObserver stocksObserver : stockObserverList) {
			stocksObserver.update();
		}
	}

	public List<StocksObserver> getStockObserverList() {
		return stockObserverList;
	}

	public void setStockObserverList(List<StocksObserver> stockObserverList) {
		this.stockObserverList = stockObserverList;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public long getMessageTimestamp() {
		return messageTimestamp;
	}

	public void setMessageTimestamp(long messageTimestamp) {
		this.messageTimestamp = messageTimestamp;
	}

	public int getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(int openingPrice) {
		this.openingPrice = openingPrice;
	}

	public int getPreviousClosingPrice() {
		return previousClosingPrice;
	}

	public void setPreviousClosingPrice(int previousClosingPrice) {
		this.previousClosingPrice = previousClosingPrice;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}

	public int getAskPrice() {
		return askPrice;
	}

	public void setAskPrice(int askPrice) {
		this.askPrice = askPrice;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(int currentVolume) {
		this.currentVolume = currentVolume;
	}

	public int getAverageVolume() {
		return averageVolume;
	}

	public void setAverageVolume(int averageVolume) {
		this.averageVolume = averageVolume;
	}
	
	public void update(TickerMessage message) {
		//send the stock value to ui using observer
	}

}