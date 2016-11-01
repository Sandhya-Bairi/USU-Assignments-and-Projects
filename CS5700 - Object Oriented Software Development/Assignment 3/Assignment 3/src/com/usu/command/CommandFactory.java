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
        switch (commandType.trim().toUpperCase()) {
	        case "NEW":
	        	command = new NewCommand();
	        	break;
        	case "ADD":
                command = new AddCommand(commandParameters);
                break;
            case "REMOVE":
                command = new RemoveSelectedCommand();
                break;
            case "SELECT":
                command = new SelectCommand(commandParameters);
                break;
            case "DESELECT":
                command = new DeselectCommand();
                break;
            case "LOAD":
                command = new LoadCommand(commandParameters);
                break;
            case "SAVE":
                command = new SaveCommand(commandParameters);
                break;
            case "ZOOM":
                command = new ZoomCommand(commandParameters);
                break;
        }

        if (command!=null)
            command.targetDrawing = targetDrawing;

        return command;
    }
}
