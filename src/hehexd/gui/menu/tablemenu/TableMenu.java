package hehexd.gui.menu.tablemenu;

import javax.swing.JPopupMenu;

import hehexd.gui.IntListTable;

/**
 * 
 * The menu that appears when you left click a row in the IntListTable
 * 
 * @author Only Brad
 *
 */
public class TableMenu extends JPopupMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5825868235658396047L;
	
	public TableMenu(IntListTable table) {
		
		this.add(new RemoveMenuItem(table));
	}
}
