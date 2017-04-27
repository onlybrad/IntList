package hehexd.gui.menu.framemenu;

import javax.swing.*;

/**
 * The Menu "File" in a MenuBar
 * 
 * @author Only Brad
 *
 */
class FileMenu extends JMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4969863525226656553L;

	FileMenu() {
		
		super("File");
		this.add(new ExitMenuItem());
	}
}
