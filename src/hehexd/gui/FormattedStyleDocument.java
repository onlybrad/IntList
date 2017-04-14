package hehexd.gui;

import javax.swing.text.*;

/**
 * This class is a DefaultStyledDocument that formats the text to show all the dates aligned in the same
 * column. To make this possible, a monospace font must be used in the JComponent that uses this DefaultStyledDocument.
 * 
 * 
 * @author Only Brad
 *
 */
class FormattedStyleDocument extends DefaultStyledDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MIN_CHAR_OUTPUT = 100;
	
	/**
	 * Modify the insertString method to add a formatted text in it. Every time the character "@" is used, that
	 * means we are adding a date : all dates should appear perfectly lined one after the other.
	 */
	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		

		int index = str.indexOf("@");
	
		if(index >= 0) {
			

			String leftSubstring = str.substring(0, index);
			String rightSubstring = str.substring(index, str.length());
			String space = "";
			int nbOfChar = MIN_CHAR_OUTPUT - leftSubstring.length();
			
			
			for(int i=0;i<nbOfChar;i++)
				
				space += ' ';
			
			rightSubstring = space+rightSubstring;
				
			str = leftSubstring+rightSubstring;
			
		}
		super.insertString(offs, str, a);
	}
	
	
}
