package com.usu.draw;

import java.awt.Dimension;
import java.awt.Point;

public class ShapeExtrinsicState {

	public String shapeType;
	public Point location;
	public Dimension size;
	public boolean isSelected;

	public String getShapeType() {
		return shapeType;
	}

	public void setShapeType(String shapeType) {
		this.shapeType = shapeType;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public ShapeExtrinsicState() {
	}
	
	public ShapeExtrinsicState(String shapeType, Point location, Dimension size) {
		this.shapeType = shapeType;
		this.location = location;
		this.size = size;
	}
}