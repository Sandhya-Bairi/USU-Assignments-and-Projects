package com.usu.draw;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
	
	public String resourceNamePattern;
    public Type referenceType;

    private Map<String, ShapeIntrinsicState> sharedShapes = new HashMap<String, ShapeIntrinsicState>();

    public ShapeWithAllState getShape(ShapeExtrinsicState extrinsicState) {
        String resourceName = String.format(resourceNamePattern, extrinsicState.shapeType);

        ShapeIntrinsicState treeWithIntrinsicState;
        if (sharedShapes.containsKey(extrinsicState.shapeType))
            treeWithIntrinsicState = sharedShapes.get(extrinsicState.shapeType);
        else {
            treeWithIntrinsicState = new ShapeIntrinsicState();
            treeWithIntrinsicState.loadFromResource(resourceName, referenceType);
            sharedShapes.put(extrinsicState.shapeType, treeWithIntrinsicState);
        }

        return new ShapeWithAllState(treeWithIntrinsicState, extrinsicState);
    }
}
