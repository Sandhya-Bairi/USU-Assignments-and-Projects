package com.usu.stockMonitoring.forms;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class AddObserverDialog extends JDialog {
	
	public AddObserverDialog() {
		radioButtonsValue();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3581910287982341819L;
	private final JPanel contentPanel = new JPanel();
	
	static boolean radioButtonsValue[] = new boolean[3];

	/**
	 * Create the dialog.
	 */
	public void radioButtonsValue() {
		setTitle("Select Observer");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		setVisible(true);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Portfolio Stock Prices");
		rdbtnNewRadioButton.setBounds(134, 75, 200, 23);
		contentPanel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Individual Stock Price Graph");
		rdbtnNewRadioButton_1.setBounds(134, 101, 200, 23);
		contentPanel.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Individual Stock Volume Graph");
		rdbtnNewRadioButton_2.setBounds(134, 127, 200, 23);
		contentPanel.add(rdbtnNewRadioButton_2);

		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 225, 434, 33);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(buttonPane);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnNewRadioButton.isSelected()) {
					radioButtonsValue[0] = true;
				} else if(rdbtnNewRadioButton_1.isSelected()) {
					radioButtonsValue[1] = true;
				} else if(rdbtnNewRadioButton_2.isSelected()) {
					radioButtonsValue[2] = true;
				} else {
					radioButtonsValue[0] = false;
					radioButtonsValue[1] = false;
					radioButtonsValue[2] = false;
				}
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}

}
