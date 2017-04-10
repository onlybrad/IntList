package hehexd.gui.listeners;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.text.*;
import hehexd.config.Config;
import hehexd.datastructure.*;

/**
 * If for some dumb reason you want to remove a kid by pressing the "Remove" button, the actionPerformed
 * of this class will be called.
 * 
 * @author Only Brad
 *
 */
class RemoveButtonListener extends ButtonListener {
	
	protected RemoveButtonListener(JTextField name, JTextPane output, IntList intList) {
		super(name, null, output, intList);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(isEmpty(name))
			
			return; // can't do anything if there are no name
		
		super.actionPerformed(e);
		
		this.clearInput();
	}

	@Override
	protected Command addCommand(IntList intList) {
		return new RemoveCommand(intList);
	}

	@Override
	protected void successOutput() {
		
		String date = Config.getInstance().dateFormat.format(new Date());
		
		StyledDocument document = (StyledDocument) this.output.getStyledDocument();
		SimpleAttributeSet attributes = new SimpleAttributeSet();
	    attributes.addAttribute(StyleConstants.CharacterConstants.Foreground, Color.RED);
	
		try {
			document.insertString(document.getLength(),this.command.toString()+" ",attributes);
			document.insertString(document.getLength(),"@ "+date+"\n",null);
		} 
		catch (BadLocationException e) {}
		
	}

	@Override
	protected void failOutput() {
			
		Document document = this.output.getDocument();
		
		try{
			document.insertString(document.getLength(),"No kid was removed from the IntList.\n", null);
		}
		catch (BadLocationException e) {}
	}

	@Override
	protected String[] generateArgs() {
		
		return this.name.getText().trim().split("\\s+");
	}

}
