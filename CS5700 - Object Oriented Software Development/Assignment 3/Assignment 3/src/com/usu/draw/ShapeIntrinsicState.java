package com.usu.draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.lang.reflect.Type;

public class ShapeIntrinsicState extends Shape {
	
	public static Color selectedBackgroundColor = Color.WHITE;
    public String shapeType;
    public BufferedImage image;
    public BufferedImage toolImage;
    public BufferedImage toolImageSelected;
    
	@Override
	public void draw(Graphics2D graphics) {
		//throw new Exception("Cannot draw a shape with only intrinsic state");		
	}
	
	public void loadFromResource(String treeType, Type referenceTypeForAssembly) {
        if (treeType == null || treeType.isEmpty()) return;

       /* Assembly assembly = Assembly.GetAssembly(referenceTypeForAssembly);

        if (assembly == null) return;

        using (Stream stream = assembly.GetManifestResourceStream(treeType))
        {
            if (stream != null)
            {
                Image = new Bitmap(stream);
				ToolImage = new Bitmap(Image, ToolSize);
                ToolImageSelected = new Bitmap(ToolSize.Width, ToolSize.Height);

                Graphics g = Graphics.FromImage(ToolImageSelected);
				g.Clear(SelectionBackgroundColor);
				g.DrawImage(ToolImage, new Point() {X=0, Y = 0});
            }
        }*/
    }
}