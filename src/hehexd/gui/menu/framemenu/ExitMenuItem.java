package hehexd.gui.menu.framemenu;

import java.awt.event.*;
import javax.swing.*;
import hehexd.datastructure.RagequitCommand;

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
		
		super("Rage Quit");
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new RagequitCommand().apply(null);	
			}
		});
	}
}