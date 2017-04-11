package hehexd.gui.listeners;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import hehexd.config.*;
import hehexd.datastructure.*;
import hehexd.randomcrap.*;

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
	
	@Override
	protected void failOutput() {
		
		String date = Config.getInstance().dateFormat.format(new Date());
		Document document = this.output.getDocument();
		try {
			document.insertString(document.getLength(),"Failed to add a kid to the intList @"+ date +"\n", null);
		} 
		catch (BadLocationException e) {}
	}

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
			
			return GlobalMethods.addString(names, this.reason.getText());
		
		return GlobalMethods.addString(names,this.reason.getText());
		
	}
	


}
