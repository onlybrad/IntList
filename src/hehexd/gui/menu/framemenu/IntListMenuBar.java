package hehexd.gui.menu.framemenu;

import javax.swing.*;

/**
 * It's the Menu Bar
 * 
 * @author Only Brad
 *
 */
public class IntListMenuBar extends JMenuBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5543890997182956873L;
	
	public IntListMenuBar() {
		
		super();
		this.add(new FileMenu());

	}

}
