package com.usu.stockMonitoring.forms;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.usu.simulatorCommunication.messages.SimulatorCommunicator;
import com.usu.stocks.Stock;

public class StockPriceMonitoringSystemControlForm {

	private JFrame frame;
	private JTextField txtHeaderInfo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			new SimulatorCommunicator().startUDPPacket();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Stock stock = new Stock();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockPriceMonitoringSystemControlForm window = new StockPriceMonitoringSystemControlForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StockPriceMonitoringSystemControlForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1146, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 70, 20);
		frame.getContentPane().add(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add");
		menuBar.add(mntmNewMenuItem);
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem.setBounds(0, 0, 129, 22);
		
		JMenuItem mntmNewMenuItem2 = new JMenuItem("Delete");
		menuBar.add(mntmNewMenuItem2);
		mntmNewMenuItem2.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem2.setBounds(0, 0, 129, 22);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(75, 0, 10, 20);
		frame.getContentPane().add(separator_1);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		txtHeaderInfo = new JTextField();
		txtHeaderInfo.setBounds(90, 0, 543, 20);
		frame.getContentPane().add(txtHeaderInfo);
		txtHeaderInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHeaderInfo.setEditable(false);
		txtHeaderInfo.setText("Header Info");
		txtHeaderInfo.setColumns(2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLUE);
		panel.setBounds(0, 25, 310, 30);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.RED, null, null));
		table.setAlignmentY(Component.TOP_ALIGNMENT);
		table.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(table);
		table.setBackground(Color.BLACK);
		table.setFillsViewportHeight(true);
		table.setShowGrid(true);
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Stock", "Current", "Bid", "Ask"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(320, 25, 310, 10);
		frame.getContentPane().add(panel_1);
		
		JTextPane textPane = new JTextPane();
		panel_1.add(textPane);
		textPane.setBackground(Color.PINK);
		textPane.setEditable(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(640, 25, 310, 10);
		frame.getContentPane().add(panel_2);
		
		JTextPane textPane_1 = new JTextPane();
		panel_2.add(textPane_1);
		textPane_1.setEditable(false);
		textPane_1.setBackground(Color.YELLOW);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 30, 310, 10);
		frame.getContentPane().add(panel_3);
		
		Canvas canvas = new Canvas();
		panel_3.add(canvas);
		canvas.setEnabled(false);
		canvas.setBackground(Color.MAGENTA);
		
		JMenu mnNewMenu = new JMenu("Stock");
		mnNewMenu.setHorizontalAlignment(SwingConstants.LEFT);
		
		JMenuItem mntmAdd = new JMenuItem("Add");
		mntmAdd.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmAdd);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmDelete);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
