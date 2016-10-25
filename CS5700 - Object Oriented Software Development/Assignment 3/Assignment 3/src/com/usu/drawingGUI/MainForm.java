package com.usu.drawingGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.usu.command.CommandFactory;
import com.usu.draw.ShapeFactory;
import com.usu.draw.ShapeIntrinsicState;

public class MainForm extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2097974806888496538L;
	
	private JPanel contentPane;
	
	private String currentShapeResourceSelected;
	
	private DrawingPalette drawingPalette;
	
	float currentScale = 1;
	
	CommandFactory commandFactory;
	
	JPanel panel_1;
	
	private BufferedImage imageBuffer;
    private Image imageBufferGraphics;
    private Graphics2D panelGraphics;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm mainForm = new MainForm();
					mainForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainForm() {
		createFrame();
		commandFactory = new CommandFactory();
		drawingPalette = new DrawingPalette();
		commandFactory.targetDrawing = drawingPalette;
		drawingPalette.shapeFactory = new ShapeFactory();
		drawingPalette.shapeFactory.resourceNamePattern = "img/%s.jpg";
	}
	
	private void createFrame() {
		setTitle("Drawing");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 40, 100, 640);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (currentShapeResourceSelected != null && !currentShapeResourceSelected.isEmpty()) {
                    commandFactory.create("add", currentShapeResourceSelected, arg0.getLocationOnScreen(), currentScale).execute();
                    displayDrawing();
				} else {
					commandFactory.create("select", arg0.getLocationOnScreen()).execute();
				}
			}
		});
		panel_1.setBounds(120, 40, 825, 640);
		panel_1.setBackground(Color.WHITE);
		//graphics = (Graphics2D)panel_1.getGraphics();
		contentPane.add(panel_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 10, 40, 20);
		contentPane.add(menuBar);
		
		JMenu mnDraw = new JMenu("Draw");
		mnDraw.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnDraw);
		
		JMenuItem menuItem = new JMenuItem("New");
		menuItem.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem.setMnemonic(KeyEvent.VK_N);
		KeyStroke keyStrokeToNew = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
		menuItem.setAccelerator(keyStrokeToNew);
		mnDraw.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.removeAll();
				Color newColor = JColorChooser.showDialog(null, "Choose a color", panel_1.getBackground());
				if(newColor != null)
					panel_1.setBackground(newColor);
				ShapeIntrinsicState.selectedBackgroundColor = newColor;
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem.setMnemonic(KeyEvent.VK_O);
		KeyStroke keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
		mntmNewMenuItem.setAccelerator(keyStrokeToOpen);
		mnDraw.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_1.setMnemonic(KeyEvent.VK_S);
		KeyStroke keyStrokeToSave = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
		mntmNewMenuItem_1.setAccelerator(keyStrokeToSave);
		mnDraw.add(mntmNewMenuItem_1);
		
		//Sun
		JButton buttonSun = new JButton();
		buttonSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clearOtherSelectedTools(btnSun);

            	currentShapeResourceSelected = "sun";
            	buttonSun.getModel().setPressed(true);
			}
		});
		buttonSun.setBounds(15, 20, 70, 40);
		buttonSun.setIcon(new ImageIcon(new ImageIcon("img/sun.jpg").getImage().getScaledInstance(buttonSun.getWidth(), buttonSun.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		panel.add(buttonSun);
		
		//Cloud
		JButton buttonCloud = new JButton();
		buttonCloud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeResourceSelected = "cloud";
				buttonCloud.getModel().setPressed(true);
			}
		});
		buttonCloud.setBounds(15, 80, 70, 40);
		buttonCloud.setIcon(new ImageIcon(new ImageIcon("img/cloud.jpg").getImage().getScaledInstance(buttonCloud.getWidth(), buttonCloud.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		panel.add(buttonCloud);
		
		//Mountain
		JButton buttonMountain = new JButton();
		buttonMountain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeResourceSelected = "mountain";
				buttonMountain.getModel().setPressed(true);
			}
		});
		buttonMountain.setBounds(15, 140, 70, 40);
		buttonMountain.setIcon(new ImageIcon(new ImageIcon("img/mountain.jpg").getImage().getScaledInstance(buttonMountain.getWidth(), buttonMountain.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		panel.add(buttonMountain);
		
		//River
		JButton buttonRiver = new JButton();
		buttonRiver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeResourceSelected = "river";
				buttonRiver.getModel().setPressed(true);
			}
		});
		buttonRiver.setBounds(15, 200, 70, 40);
		buttonRiver.setIcon(new ImageIcon(new ImageIcon("img/river.jpg").getImage().getScaledInstance(buttonRiver.getWidth(), buttonRiver.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		panel.add(buttonRiver);
		
		//Tree
		JButton buttonTree = new JButton();
		buttonTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeResourceSelected = "tree";
				buttonTree.getModel().setPressed(true);
			}
		});
		buttonTree.setBounds(15, 260, 70, 40);
		buttonTree.setIcon(new ImageIcon(new ImageIcon("img/tree.jpg").getImage().getScaledInstance(buttonTree.getWidth(), buttonTree.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		panel.add(buttonTree);
		
		//Land
		JButton buttonLand = new JButton();
		buttonLand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeResourceSelected = "land";
				buttonLand.getModel().setPressed(true);
			}
		});
		buttonLand.setBounds(15, 320, 70, 40);
		buttonLand.setIcon(new ImageIcon(new ImageIcon("img/land.jpg").getImage().getScaledInstance(buttonLand.getWidth(), buttonLand.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		panel.add(buttonLand);
		
		//Pointer
		JButton buttonPointer = new JButton();
		buttonPointer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeResourceSelected = "";
				buttonPointer.getModel().setPressed(true);
			}
		});
		buttonPointer.setBounds(15, 380, 70, 40);
		buttonPointer.setIcon(new ImageIcon(new ImageIcon("img/pointerIcon.jpg").getImage().getScaledInstance(buttonPointer.getWidth(), buttonPointer.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		panel.add(buttonPointer);
		
		//Undo
		JButton buttonUndo = new JButton();
		buttonUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonUndo.getModel().setPressed(true);
			}
		});
		buttonUndo.setBounds(15, 535, 70, 40);
		buttonUndo.setIcon(new ImageIcon(new ImageIcon("img/undo.jpg").getImage().getScaledInstance(buttonUndo.getWidth(), buttonUndo.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		panel.add(buttonUndo);
		
		//Reset
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.removeAll();
				panel_1.setBackground(Color.WHITE);
			}
		});
		btnReset.setBounds(15, 600, 70, 25);
		panel.add(btnReset);
	}
	
	private void displayDrawing() {
		if (imageBuffer == null) {
            imageBuffer = new BufferedImage(panel_1.getWidth(), panel_1.getHeight(), BufferedImage.TYPE_INT_ARGB);
            imageBufferGraphics = panel_1.createImage(panel_1.getWidth(), panel_1.getHeight());
            panelGraphics = imageBuffer.createGraphics();
        }

        drawingPalette.draw(panelGraphics);
//            panelGraphics.DrawImageUnscaled(imageBuffer, 0, 0);
	}
}