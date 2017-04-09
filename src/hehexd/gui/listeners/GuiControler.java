package hehexd.gui.listeners;

import javax.swing.*;
import javax.swing.JTextField;
import hehexd.api.*;
import hehexd.datastructure.*;
import hehexd.gui.*;

/**
 * Class that links the GUI to the ActionListener
 * Contains a pointer to a global (Package wise) CommandManager object
 * 
 * @author Only Brad
 *
 */
public class GuiControler {
	
	/* use this with the actionlistener of the hehexd.gui.listeners package */
	final static CommandManager commandManager = new CommandManager();
	private final IntList intList; // THE FUCKING INTLIST
	
	public GuiControler(IntList intList,IntListFrame frame) {
		
		this.intList = intList;
		
		JTextField name = frame.getTextName();
		JTextField reason = frame.getTextReason();
		JTextPane output = frame.getOutput();
		
		/* add the AddButtonListener to the "add" button */
		frame.getButtons()[0].addActionListener(new AddButtonListener(name, reason, output, intList));
		
	}
	
	IntList getIntList() {
		
		return this.intList;
	}

}
