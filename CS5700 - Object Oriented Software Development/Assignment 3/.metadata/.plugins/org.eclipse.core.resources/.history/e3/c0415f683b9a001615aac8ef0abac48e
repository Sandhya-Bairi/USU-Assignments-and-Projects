package com.usu.draw;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.imageio.ImageIO;

public class ShapeWithAllState extends Shape {

	private ShapeIntrinsicState intrinsicState;
    public ShapeExtrinsicState extrinsicStatic;
    
	@Override
	public void draw(Graphics2D graphics) {
		if (graphics == null || intrinsicState == null) return;

        //graphics.draw(ImageIO.read(getClass().getResource("img/sun.jpeg")));

        if (extrinsicStatic.isSelected) {
            graphics.drawRect(extrinsicStatic.location.x, extrinsicStatic.location.y, extrinsicStatic.size.width, extrinsicStatic.size.height);

            DrawActionHandle(graphics, extrinsicStatic.location.x, extrinsicStatic.location.y);
            DrawActionHandle(graphics, extrinsicStatic.location.x + extrinsicStatic.size.width, extrinsicStatic.location.y);
            DrawActionHandle(graphics, extrinsicStatic.location.x, extrinsicStatic.location.y + extrinsicStatic.size.height);
            DrawActionHandle(graphics, extrinsicStatic.location.x + extrinsicStatic.size.width, extrinsicStatic.location.y + extrinsicStatic.size.height);
        }
	}
	
	ShapeWithAllState(ShapeIntrinsicState sharedPart, ShapeExtrinsicState nonsharedPart) {
        intrinsicState = sharedPart;
        extrinsicStatic = nonsharedPart;
    }
	
	private void DrawActionHandle(Graphics2D graphics, int x, int y) {
        graphics.fillRect(x/* - HandleHalfSize*/, y - handleHalfSize, handleHalfSize*2, handleHalfSize*2);
    }

}