package hehexd.gui.listeners;

import java.util.Date;
import javax.swing.*;
import javax.swing.text.*;

import java.awt.event.*;
import hehexd.config.Config;
import hehexd.datastructure.*;


/**
 * Don't do that. This will wipe the whole IntList by pressing on the "Clear" button
 * 
 * @author Only Brad
 *
 */
public class ClearButtonListener extends ButtonListener {
	
	/**
	 * Since it's a removal command, we need to ask the user if he is sure he want to remove the kids
	 * from the int list. That's a confirmation is sent before applying the command. If he refuses then
	 * a special message (no the failure message) appears
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String title = "Dude what r u doing?";
		String message = "Are you sure you want to wipe the Intlist?\n"+
				"Some kids really deserve to get trolled and should never be removed for this list.";
		String[] options = new String[] {"KYS and wipe the list","Hell no, Imma keep inting in these kids' games"};
		
		int confirmation = JOptionPane.showOptionDialog(null,message,title,
				JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,options,false);
		
		if(confirmation == 0)
			
			super.actionPerformed(e);
		
		else
			
		this.cancelOutput();
	}										
	


	protected ClearButtonListener(JTextPane output, IntList intList) {
		super(null, null, output, intList);
	}

	@Override
	protected Command addCommand(IntList intList) {
		
		return new ClearCommand(intList);
	}

	@Override
	protected void successOutput() {
		
		String date = Config.getInstance().dateFormat.format(new Date());
		Document document = this.output.getDocument();

		try {
			document.insertString(document.getLength(), this.command.toString()+" @ "+date+"\n", null);
		} catch (BadLocationException e) {}

	}
	
	private void cancelOutput() {
		
		Document document = this.output.getDocument();
		
		try {
			document.insertString(document.getLength(),
					"You cancelled the wiping of the IntList, Good Job: Please keep inting in these retards' game\n",null);
		} catch (BadLocationException e) {}
		
	}

	@Override
	protected void failOutput() {
		
		Document document = this.output.getDocument();

		try {
			document.insertString(document.getLength(), 
					"Failed to wipe the IntList for some reason, shouldn't happen if you're not dumb\n", null);
		} catch (BadLocationException e) {}
	}

	@Override
	protected String[] generateArgs() {
		return null;
	}

	

}
