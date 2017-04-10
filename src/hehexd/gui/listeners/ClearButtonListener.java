package hehexd.gui.listeners;

import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import hehexd.config.Config;
import hehexd.datastructure.*;


/**
 * Don't do that. This will wipe the whole IntList by pressing on the "Clear" button
 * 
 * @author Only Brad
 *
 */
public class ClearButtonListener extends ButtonListener {

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
