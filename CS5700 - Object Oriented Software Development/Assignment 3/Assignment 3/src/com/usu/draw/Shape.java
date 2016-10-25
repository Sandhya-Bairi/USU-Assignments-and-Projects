package com.usu.draw;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public abstract class Shape {
	
	/*public static Pen SelectedPen = new Pen(Color.DarkGray);
    public static Brush HandlesBrush = new SolidBrush(Color.Black);*/
    public static int handleHalfSize = 3;
    public static Dimension toolSize = new Dimension(64,64);

    public Point location = new Point(0, 0);
    public Dimension size = new Dimension(0, 0);
    public boolean isSelected = false;

    public abstract void draw(Graphics2D graphics);
}