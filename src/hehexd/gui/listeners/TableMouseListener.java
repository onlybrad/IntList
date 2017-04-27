package hehexd.gui.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.SwingUtilities;

import hehexd.datastructure.CommandManager;

/**
 * Makes a right click change focus to a specific row.
 * 
 * @author Only Brad
 *
 */
public class TableMouseListener extends MouseAdapter {
	
	@Override
	/**
	 * When right clicking on a row, sets it as selected.
	 */
	public void mousePressed(MouseEvent e) {
		
		if(SwingUtilities.isRightMouseButton(e)) {
		
			JTable table = (JTable) e.getSource();
			int rowIndex = table.rowAtPoint(e.getPoint());
			table.setRowSelectionInterval(rowIndex,rowIndex);
			
		}
	}
	
}
