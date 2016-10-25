package com.usu.draw;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShapeWithAllState extends Shape {

	private ShapeIntrinsicState intrinsicState;
    public ShapeExtrinsicState extrinsicState;
    
	@Override
	public void draw(Graphics2D graphics) {
		if (graphics == null || intrinsicState == null) return;

        try {
			graphics.drawImage(ImageIO.read(new File(intrinsicState.shapeName)), 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

        if (extrinsicState.isSelected) {
            graphics.drawRect(extrinsicState.location.x, extrinsicState.location.y, extrinsicState.size.width, extrinsicState.size.height);

            DrawActionHandle(graphics, extrinsicState.location.x, extrinsicState.location.y);
            DrawActionHandle(graphics, extrinsicState.location.x + extrinsicState.size.width, extrinsicState.location.y);
            DrawActionHandle(graphics, extrinsicState.location.x, extrinsicState.location.y + extrinsicState.size.height);
            DrawActionHandle(graphics, extrinsicState.location.x + extrinsicState.size.width, extrinsicState.location.y + extrinsicState.size.height);
        }
	}
	
	ShapeWithAllState(ShapeIntrinsicState sharedPart, ShapeExtrinsicState nonsharedPart) {
        intrinsicState = sharedPart;
        extrinsicState = nonsharedPart;
    }
	
	private void DrawActionHandle(Graphics2D graphics, int x, int y) {
        graphics.fillRect(x/* - HandleHalfSize*/, y - handleHalfSize, handleHalfSize*2, handleHalfSize*2);
    }

}