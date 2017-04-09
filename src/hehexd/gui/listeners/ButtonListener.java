package hehexd.gui.listeners;

import java.awt.event.*;
import javax.swing.*;
import hehexd.datastructure.*;

/**
 * All Button listeners of the IntList must implement this class. They all will access the same data
 * so might as well inherit from the same super class.
 * 
 * @author Only Brad
 *
 */
public abstract class ButtonListener implements ActionListener {

	protected JTextField name; // The place where you put the kid's name
	protected JTextField reason; // The reason why he's going in the int list
	protected JTextPane output; // To write outputs
	protected Command command; // the command

	/**
	 * 
	 * @param name The place where you put the kid's name
	 * @param reason The reason why he's going in the int list
	 * @param output To write outputs
	 * @param intList The fucking intlist
	 */
	protected ButtonListener(JTextField name, 
			JTextField reason,
			JTextPane output,
			IntList intList) {
		
		this.name = name;
		this.reason = reason;
		this.output = output;
		this.command = this.addCommand(intList);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* set the command and execute it */
		GuiControler.commandManager.setCommand(this.command);
		
		if(GuiControler.commandManager.apply(this.generateArgs()))
			
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
	protected abstract Command addCommand(IntList intList);
	
	/**
	 * Concrete ButtonListener must implement this to write a successful message inside the output
	 * object
	 */
	protected abstract void successOutput();
	
	/**
	 * Concrete ButtonListener must implement this to write a fail message inside the output object
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
	protected static boolean isEmpty(JTextField ... JTextFields) {
		
		for(JTextField JTextField : JTextFields)
			
			if(JTextField.getText() == null || JTextField.getText().trim().isEmpty())
				
				return true;
		
		return false;
	}

}
