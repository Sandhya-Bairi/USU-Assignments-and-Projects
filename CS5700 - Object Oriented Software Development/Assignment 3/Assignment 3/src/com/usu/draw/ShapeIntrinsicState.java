package com.usu.draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

import javax.imageio.ImageIO;

public class ShapeIntrinsicState extends Shape {

	public static Color selectedBackgroundColor;
	public String shapeType;
	public BufferedImage image;
	public BufferedImage toolImage;
	//public BufferedImage toolImageSelected;
	
	public String shapeName;

	@Override
	public void draw(Graphics2D graphics) {
		//throw new Exception("Cannot draw a shape with only intrinsic state");		
	}

	public void loadFromResource(String shapeName, Type referenceTypeForAssembly) {
		if (shapeName == null || shapeName.isEmpty()) return;
		
		this.shapeName = shapeName;
		try {
			image = ImageIO.read(new File(shapeName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		toolImage = new BufferedImage(toolSize.width, toolSize.height, BufferedImage.TYPE_INT_RGB);
		//toolImageSelected = new Bitmap(toolSize.width, toolSize.height);
		
		Graphics2D g = toolImage.createGraphics();
		
		/*Graphics.FromImage(ToolImageSelected);
		g.Clear(SelectionBackgroundColor);*/
		//g.drawImage(toolImage, 0, 0, null);

	}
}