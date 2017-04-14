package hehexd.gui.listeners;

import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.text.*;
import hehexd.datastructure.*;

public class CheckButtonListener extends ButtonListener {

	protected CheckButtonListener(JTextField name, JTextPane output, IntList intList) {
		super(name, null, output, intList);
	}

	@Override
	protected Command getCommand(IntList intList) {
		
		return new CheckCommand(intList);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(isEmpty(name))
			
			return; // can't do anything if there are no names
		
		super.actionPerformed(e);
		
		clear(this.name);
	}

	@Override
	protected void successOutput() {
		
		Document document = this.output.getDocument();

		try {
			document.insertString(document.getLength(),this.command.getCommandString().toSuccessString()+"\n",null);
		} catch (BadLocationException e) {}

	}

	@Override
	protected void failOutput() {}

	@Override
	protected String[] generateArgs() {
		
		String[] name = this.name.getText().trim().split("\\s+");
		
		return new String[]{name[0]};
	}

}
