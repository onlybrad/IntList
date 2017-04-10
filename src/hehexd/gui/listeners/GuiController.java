package hehexd.gui.listeners;

import javax.swing.*;
import javax.swing.JTextField;
import hehexd.api.*;
import hehexd.datastructure.*;
import hehexd.gui.*;
import java.awt.event.*;

import static hehexd.gui.CommandPanel.*;


/**
 * Class that links the GUI to the ActionListener
 * Contains a pointer to a global (Package wise) CommandManager object
 * 
 * @author Only Brad
 *
 */
public class GuiController {
	
	/* use this with the actionlistener of the hehexd.gui.listeners package */
	final static CommandManager commandManager = new CommandManager();
	private final IntList intList; // THE FUCKING INTLIST
	private final AppFrame frame; // The frame
	
	public GuiController(IntList intList,AppFrame frame) {
		
		this.intList = intList;
		this.frame = frame;
	}
	
	public void start() {
		
		JTextField name = frame.getTextName();
		JTextField reason = frame.getTextReason();
		JTextPane output = frame.getOutput();
		
		/* add the AddButtonListener to the "add" button */
		frame.getButtons()[ADD_BUTTON].addActionListener(new AddButtonListener(name, reason, output, intList));
		
		/* add the RemoveButtonListener to the "remove" button */
		frame.getButtons()[REMOVE_BUTTON].addActionListener(new RemoveButtonListener(name,output,intList));
		
		/* add the ClearButtonListener to the "clear" button */
		frame.getButtons()[CLEAR_BUTTON].addActionListener(new ClearButtonListener(output, intList));
		
		/* add The TabListener to the tabs of the JTabbedPane in the frame */
		MouseAdapter listener = new TabListener();
		frame.getTabbedPane().addMouseListener(listener);
		frame.getTabbedPane().addMouseMotionListener(listener);
	}
	
	IntList getIntList() {
		
		return this.intList;
	}

}
