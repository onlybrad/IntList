package hehexd.gui.listeners;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import hehexd.config.*;
import hehexd.datastructure.*;

/**
 * When you're adding a kid by pressing "Add", the actionPerformed of this class will be
 * called.
 * 
 * @author Only Brad
 *
 */
class AddButtonListener extends ButtonListener {
	
	protected AddButtonListener(JTextField name, JTextField reason, JTextPane output, IntList intList) {
		super(name, reason, output, intList);
	}
	
	@Override
	protected Command addCommand(IntList intList) {
		return new AddCommand(intList);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(isEmpty(name))
			
			return; // can't do anything if there are no names
		
		super.actionPerformed(e);
		
		this.clearInput();
	}
	
	/**
	 * Write a message in the output indicating that the execution of the command was a failure
	 */
	@Override
	protected void failOutput() {
		
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
	@Override
	protected void successOutput() {
		
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

	@Override
	protected String[] generateArgs() {
		
		String[] names = this.name.getText().trim().split("\\s+");
		
		if(isEmpty(this.reason))
			
			return appendArgs(names,"Unspecified.");
		
		return appendArgs(names,this.reason.getText());
		
	}
	
	/**
	 * Append a string to the end of a String Array. Used to add the reason at the end of the names.
	 * 
	 * @param names The kids that you added to the int list
	 * @param reason the reason you added them
	 * @return the array containing both the kids and the reason
	 */
	private static String[] appendArgs(String[] names, String reason) {
		
		List<String> args = new ArrayList<>();
		args.addAll(Arrays.asList(names));
		args.addAll(Arrays.asList(reason));
		
		return args.toArray(new String[]{});
	}


}
