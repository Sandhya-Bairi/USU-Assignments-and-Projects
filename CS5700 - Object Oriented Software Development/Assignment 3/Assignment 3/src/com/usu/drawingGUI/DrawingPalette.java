package com.usu.drawingGUI;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.usu.draw.Shape;
import com.usu.draw.ShapeFactory;

public class DrawingPalette {

	Shape shape;
	
	public ShapeFactory shapeFactory;
	
	//private static JSONSerializer jsonSerializer = new JSONSerializer();
	
	private List<Shape> shapes = new ArrayList<Shape>();
	
	public boolean isDirty;
	
	 public void add(Shape shape) {
         if (shape != null) {
        	 synchronized(this) {
        		 shapes.add(shape);
                 isDirty = true;
             }
         }
     }
	 
	 public void clear() {
		 synchronized(this) {
             shapes.clear();
             isDirty = true;
         }
     }
	 
	 public void removeShape(Shape shape) {
         if (shape != null) {
        	 synchronized(this) {
                 if (this.shape == shape)
                	 this.shape = null;
                 shapes.remove(shape);
                 isDirty = true;
             }
         }
     }
	 
	 public boolean draw(Graphics2D graphics)
     {
         boolean didARedraw = false;
         synchronized(this) {
             if (isDirty) {
                 //graphics.clear(Color.WHITE);
                 for(Shape shape : shapes)
                	 shape.draw(graphics);
                 isDirty = false;
                 didARedraw = true;
             }
         }
         return didARedraw;
     }
}