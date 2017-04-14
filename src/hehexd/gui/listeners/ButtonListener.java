package hehexd.gui.listeners;

import java.awt.event.*;
import javax.swing.*;
import hehexd.datastructure.*;

/**
 * All Button listeners of the IntList must implement this class. They all will access the same data
 * and use (almost) the same GUI elements so might as well inherit from the same super class.
 * 
 * All sub-classes must implement a method that returns a Command object, two methods that write in the
 * output object when the Command succeeds or when it fails and a method to generate the list of arguments
 * to pass to the Command object.
 * 
 * @author Only Brad
 *
 */
abstract class ButtonListener implements ActionListener {
	
	protected JTextField name; // The place where you put the kid's name
	protected JTextField reason; // The reason why he's going in the int list
	protected JTextPane output; // To write outputs
	protected Command command; // the command

	/**
	 * 
	 * @param name The place where you put the kid's name
	 * @param reason The reason why he's going in the int list
	 * @param output To write outputs as a feedback to the Command's execution
	 * @param intList The fucking intlist
	 */
	protected ButtonListener(JTextField name, 
			JTextField reason,
			JTextPane output,
			IntList intList) {
		
		this.name = name;
		this.reason = reason;
		this.output = output;
		this.command = this.getCommand(intList);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* set the command and execute it */
		GuiController.commandManager.setCommand(this.command);
		
		if(GuiController.commandManager.apply(this.generateArgs()))
			
			this.successOutput();
		
		else
			
			this.failOutput();
	}
		
	/**
	 * Concrete ButtonListener must implement this to return the right command
	 * @param intList 
	 * 
	 * @return the command to execute when the button is pressed
	 */
	protected abstract Command getCommand(IntList intList);
	
	/**
	 * Concrete ButtonListener must implement this to write a successful message inside the output
	 * object. If you want to add a date, use the "@" character to separate the content from the date. 
	 * A custom StyledDocument is used in the output to format the text whenever it encounters the 
	 * "@" character.
	 */
	protected abstract void successOutput();
	
	/**
	 * Concrete ButtonListener must implement this to write a fail message inside the output object. 
	 * If you want to add a date, use the "@" character to separate the content from the date. 
	 * A custom StyledDocument is used in the output to format the text whenever it encounters the 
	 * "@" character.
	 */
	protected abstract void failOutput();
	
	/**
	 * Concrete ButtonListener must implement this to return the list of arguments to use in the
	 * Command object
	 */
    protected abstract String[] generateArgs();

	/**
	 * Verify if the TextFields are empty
	 * 
	 * @param JTextFields the text fields
	 * @return if the TextFields are empty
	 */
	protected static boolean isEmpty(JTextField jTextFields) {
		
		if(jTextFields.getText() == null || jTextFields.getText().trim().isEmpty())
				
			return true;
		
		return false;
	}
	
	/**
	 * Clear a specific JTextField
	 * 
	 * @param name
	 */
	protected static void clear(JTextField field) {
		
		field.setText("");
		
	}


}
