package com.usu.stockMonitoring.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import com.usu.stocks.Portfolio;
import com.usu.stocks.Stock;

public class AddStocksForms {

	private JFrame frmSelectStocks;
	static Portfolio selectedPortfolio = new Portfolio();

	/**
	 * Create the application.
	 */
	public AddStocksForms(Portfolio portfolios) {
		initialize(portfolios);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Portfolio portfolios) {
		frmSelectStocks = new JFrame();
		frmSelectStocks.setTitle("Select Stocks");
		frmSelectStocks.setResizable(false);
		frmSelectStocks.setBounds(100, 100, 410, 330);
		frmSelectStocks.getContentPane().setLayout(null);
		frmSelectStocks.setVisible(true);
		
		JList<String> list = new JList(portfolios.keySet().toArray(new String[portfolios.size()]));
		list.setBounds(10, 10, 160, 250);
		frmSelectStocks.getContentPane().add(list);
		
		JList<String> list_1 = new JList<String>(new DefaultListModel<>());
		list_1.setBounds(230, 10, 160, 250);
		frmSelectStocks.getContentPane().add(list_1);
		
		JButton button = new JButton(">");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(String selectedValue : list.getSelectedValuesList()) {
					((DefaultListModel)list_1.getModel()).addElement(selectedValue);
				}
			}
		});
		button.setBounds(180, 70, 45, 30);
		frmSelectStocks.getContentPane().add(button);
		
		JButton button_1 = new JButton("<");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(String selectedValue : list_1.getSelectedValuesList()) {
					((DefaultListModel)list_1.getModel()).removeElement(selectedValue);
				}
			}
		});
		button_1.setBounds(180, 170, 45, 30);
		frmSelectStocks.getContentPane().add(button_1);
		
		JButton btnOk = new JButton("Stock Added");
		btnOk.setBounds(280, 270, 110, 25);
		frmSelectStocks.getContentPane().add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(String selectedStockSymbol : list_1.getSelectedValuesList()) {
					selectedPortfolio.put(selectedStockSymbol, new Stock());
				}
				frmSelectStocks.setVisible(false);
			}
		});
	}
}
