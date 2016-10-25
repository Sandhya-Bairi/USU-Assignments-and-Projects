package com.usu.command;

import com.usu.drawingGUI.DrawingPalette;

public class CommandFactory {
	public DrawingPalette targetDrawing;

	public DrawingPalette getTargetDrawing() {
		return targetDrawing;
	}

	public void setTargetDrawing(DrawingPalette targetDrawing) {
		this.targetDrawing = targetDrawing;
	}
	
	public Command create(String commandType, Object... commandParameters) {
        if (commandType == null || commandType.isEmpty()) return null;

        Command command=null;
        switch (commandType.trim().toUpperCase())
        {
        	case "ADD":
                command = new AddCommand(commandParameters);
                break;
            /*case "REMOVE":
                command = new RemoveSelectedCommand();
                break;
            case "SELECT":
                command = new SelectCommand(commandParameters);
                break;
            case "DESELECT":
                command = new DeselectAllCommand();
                break;
            case "LOAD":
                command = new LoadCommand(commandParameters);
                break;
            case "SAVE":
                command = new SaveCommand(commandParameters);
                break;*/
        }

        if (command!=null)
            command.targetDrawing = targetDrawing;

        return command;
    }
}