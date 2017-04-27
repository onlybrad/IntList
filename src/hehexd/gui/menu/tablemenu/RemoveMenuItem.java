package hehexd.gui.menu.tablemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import hehexd.datastructure.Command;
import hehexd.datastructure.CommandManager;
import hehexd.datastructure.IntList;
import hehexd.datastructure.RemoveCommand;
import hehexd.gui.IntListTable;
import hehexd.gui.listeners.GuiController;
import hehexd.randomcrap.TableModelConstants;


class RemoveMenuItem extends JMenuItem implements TableModelConstants {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7492290520527379484L;

	RemoveMenuItem(IntList intList) {
		
		super("Remove row");
		this.addActionListener(new RemoveItemListener(intList));
				
	}
	
	/**
	 * 
	 * Functional Interface to remove a row in the IntListTable
	 * 
	 * @author Only Brad
	 *
	 */
	class RemoveItemListener implements ActionListener {
		
		private IntList intList;

		private RemoveItemListener(IntList intList) {
			
			this.intList = intList;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			TableMenu menu = (TableMenu) RemoveMenuItem.this.getParent();
			IntListTable table = (IntListTable) menu.getInvoker();
			
			//Get the name of the selected row
			int rowIndex = table.getSelectedRow();
			String name = (String) table.getValueAt(rowIndex, NAME);
			
			// Create a RemoveCommand object to remove an entry from the intlist
			Command command = new RemoveCommand(this.intList);
			CommandManager manager = GuiController.getInstance().commandManager;
			
			manager.setCommand(command);
			manager.apply(new String[]{name});
			
		}
		
	}
	
	

}
