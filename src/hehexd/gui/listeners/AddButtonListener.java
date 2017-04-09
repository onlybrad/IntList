package hehexd.gui.listeners;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.HTMLDocument;

import hehexd.config.*;
import hehexd.datastructure.*;

/**
 * When you're adding a kid by pressing "Add", the actionPerformed of this class will be
 * called.
 * 
 * @author Only Brad
 *
 */
public class AddButtonListener implements ActionListener {
	
	private JTextField name; // The place where you put the kid's name
	private JTextField reason; // The reason why he's going in the int list
	private JTextPane output; // To write outputs
	private AddCommand command; // the command

	/**
	 * 
	 * @param name The place where you put the kid's name
	 * @param reason The reason why he's going in the int list
	 * @param output To write outputs
	 * @param intList The fucking intlist
	 */
	AddButtonListener(JTextField name, 
			JTextField reason,
			JTextPane output,
			IntList intList) {
		
		this.name = name;
		this.reason = reason;
		this.output = output;
		this.command = new AddCommand(intList);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(isEmpty(name,reason))
			
			return; // can't do anything if one of the fields is empty
		
		/* set the command and execute it */
		GuiControler.commandManager.setCommand(this.command);
		
		if(GuiControler.commandManager.apply(new String[]{name.getText(),reason.getText()}))
			
			this.successOutput();
		
		else
			
			this.failOutput();
		
		
	}
	
	/**
	 * Write a message in the output indicating that the execution of the command was a failure
	 */
	private void failOutput() {
		
		String date = Config.getInstance().dateFormat.format(new Date());
		Document document = this.output.getDocument();
		try {
			document.insertString(document.getLength(),"Failed to add a kid to the intList @"+ date +"\n", null);
		} 
		catch (BadLocationException e) {}
	}

	/**
	 * Write a message in the output indicating that the execution of the command was a success
	 */
	private void successOutput() {
		
		String date = Config.getInstance().dateFormat.format(new Date());
		
		StyledDocument document = (StyledDocument) this.output.getStyledDocument();
		SimpleAttributeSet attributes = new SimpleAttributeSet();
	    attributes.addAttribute(StyleConstants.CharacterConstants.Bold, Boolean.TRUE);
	
		try {
			document.insertString(document.getLength(),this.command.toString()+" ",attributes);
			document.insertString(document.getLength(),"@ "+date+"\n",null);
		} 
		catch (BadLocationException e) {}
	}

	/**
	 * Verify if the TextFields are empty
	 * 
	 * @param JTextFields the text fields
	 * @return if the TextFields are empty
	 */
	private boolean isEmpty(JTextField ... JTextFields) {
		
		for(JTextField JTextField : JTextFields)
			
			if(JTextField.getText() == null || JTextField.getText().trim().isEmpty())
				
				return true;
		
		return false;
	}

}
