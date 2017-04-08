package hehexd.gui.menu;

import javax.swing.*;

/**
 * The Menu "File" in a MenuBar
 * 
 * @author Only Brad
 *
 */
public class FileMenu extends JMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4969863525226656553L;

	FileMenu() {
		
		this.add(new ExitMenuItem());
	}
}
