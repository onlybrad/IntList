package hehexd.gui.menu.tablemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;

import hehexd.gui.IntListTable;


class RemoveMenuItem extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7492290520527379484L;
	
	private final IntListTable table;
	
	RemoveMenuItem(IntListTable table) {
		
		super("Remove row");
		this.table = table;
		this.addActionListener(new RemoveItemListener());
				
	}
	
	/**
	 * 
	 * Functional Interface to remove a row in the IntListTable
	 * 
	 * @author Only Brad
	 *
	 */
	class RemoveItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int selectedRow = RemoveMenuItem.this.table.getSelectedRow();
			DefaultTableModel model = (DefaultTableModel) RemoveMenuItem.this.table.getModel();
			model.removeRow(selectedRow);
			
		}
		
	}
	
	

}
