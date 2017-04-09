package hehexd.gui.menu;

import java.awt.event.*;
import javax.swing.*;

/**
 * an Exit menu item
 * 
 * @author Only Brad
 *
 */
class ExitMenuItem extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 739945018682258457L;

	ExitMenuItem() {
		
		super("Exit");
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(420);	
			}
		});
	}
}