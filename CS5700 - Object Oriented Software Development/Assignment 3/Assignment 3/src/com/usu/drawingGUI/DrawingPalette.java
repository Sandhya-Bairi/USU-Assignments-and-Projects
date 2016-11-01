package com.usu.drawingGUI;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.usu.draw.Shape;
import com.usu.draw.ShapeExtrinsicState;
import com.usu.draw.ShapeFactory;
import com.usu.draw.ShapeWithAllState;

public class DrawingPalette {

	Shape shape;
	
	public ShapeFactory shapeFactory;
	
	private List<Shape> shapes = new ArrayList<Shape>();
	
	private Object lock = new Object();
	
	public boolean isDirty;
	
	 public void add(Shape shape) {
         if (shape != null) {
        	 synchronized(lock) {
        		 shapes.add(shape);
                 isDirty = true;
             }
         }
     }
	 
	 public void clear() {
		 synchronized(lock) {
             shapes.clear();
             isDirty = true;
         }
     }
	 
	 public void removeShape(Shape shape) {
         if (shape != null) {
        	 synchronized(lock) {
                 if (this.shape == shape)
                	 this.shape = null;
                 shapes.remove(shape);
                 isDirty = true;
             }
         }
     }
	 
	 public boolean draw(Graphics2D graphics, JPanel mainPanel) {
         boolean didARedraw = false;
         synchronized(lock) {
             if (isDirty) {
                 for(Shape shape : shapes)
                	 shape.draw(graphics, mainPanel);
                 isDirty = true;
                 didARedraw = true;
             }
         }
         return didARedraw;
     }
	 
	 public Shape findShapeAtPosition(Point location) {
         Shape result;
         synchronized(lock) {
        	 for(Shape shape : shapes){
        		if(location.x >= shape.getLocation().x && location.x < (shape.getLocation().x + shape.getSize().width) && location.y >= shape.getLocation().y && location.y < (shape.getLocation().y + shape.getSize().height)) {
        			result = shape;
        			return result;
        		}
        	 }
         }
         return null;
     }
	 
	 public void deleteAllSelected() {
		 synchronized(lock) {
             shapes.removeIf(s -> s.isSelected);
             isDirty = true;
         }
     }
	 
	 public void loadFromString(String stream) {
		 /*ShapeExtrinsicState extrinsicStates = (List<ShapeExtrinsicState>)JsonSerializer.ReadObject(stream);
         if (extrinsicStates == null) return;

         synchronized(lock) {
             shapes.clear();
             for(ShapeExtrinsicState extrinsicState : extrinsicStates) {
                 Shape shape = shapeFactory.getShape(extrinsicState);
                 shapes.add(shape);
             }
             isDirty = true;
         }*/
     }
	 
	 public void save(String fileName, JPanel panel) {
         /*List<ShapeExtrinsicState> extrinsicStates = new ArrayList<ShapeExtrinsicState>();
         synchronized(lock) {
             for(Shape shape : shapes) {
                 ShapeWithAllState shapewithAllState = (ShapeWithAllState)shape;
                 if(shapewithAllState != null)
                     extrinsicStates.add(shapewithAllState.extrinsicState);                    
             }
         }*/
		 BufferedImage saveImage = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
		 panel.paintAll(saveImage.getGraphics());
		 try {
			ImageIO.write(saveImage, fileName.split("\\.")[1], new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
     }
	 
	 public void deselectAll() {
		 synchronized(lock) {
             for(Shape shape : shapes) {
                 shape.isSelected = false;
             }
             isDirty = true;
         }    
     }
	 
	 public void drawRectangle(Point location, JPanel mainPanel) {
		 for(Shape shape : shapes){
     		if(location.x >= shape.getLocation().x && location.x < (shape.getLocation().x + shape.getSize().width) && location.y >= shape.getLocation().y && location.y < (shape.getLocation().y + shape.getSize().height)) {
     			mainPanel.getGraphics().drawRect(shape.getLocation().x, shape.getLocation().y, shape.getSize().width, shape.getSize().height);
     		}
     	 }
	 }

	public List<Shape> getShapes() {
		return shapes;
	}
	
	/*private void removeRectangle(Shape shape, JPanel mainPanel) {
		mainPanel.getGraphics().drawRect(shape.getLocation().x, shape.getLocation().y, shape.getSize().width, shape.getSize().height);
		((Graphics2D)mainPanel.getGraphics()).setStroke(((Graphics2D)mainPanel.getGraphics()).getStroke());
	}*/
	
	public void changeScale(float newScale) {
		Shape newShape = null;
		int index = 0;
		Dimension shapeSize = new Dimension((int)Math.round(80 * newScale), (int)Math.round(80 * newScale));

		for (Shape shape : shapes) {
			index++;
			if(shape.isSelected) {
				newShape = shapeFactory.getShape(new ShapeExtrinsicState(((ShapeWithAllState)shape).extrinsicState.shapeType, new Point(shape.getLocation().x - shapeSize.width / 2, shape.getLocation().y - shapeSize.height / 2), shapeSize));
			}
		}
		
		if(newShape != null)
			shapes.add(index, newShape);
	}
}
