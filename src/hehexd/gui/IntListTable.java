package hehexd.gui;

import java.awt.Color;
import java.awt.Component;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import hehexd.config.Config;
import hehexd.datastructure.*;
import hehexd.gui.menu.tablemenu.TableMenu;


/**
 * The IntList Table. Contains all the name/reason entries
 * This class observes the CommandManager in order to see what changes occured due to a Command
 * @author Only Brad
 *
 */
public class IntListTable extends JTable implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8307915124668883263L;
	
	IntListTable(IntList intList) {
		
		List<Object> names;
		List<Object> reasons;
		
		if(!intList.isEmpty()) {
			names = new ArrayList<>(intList.keySet());
			reasons = new ArrayList<>(intList.values());
		}
		
		else {
			names = new ArrayList<>();
			reasons = new ArrayList<>();
		}
		
		this.setModel(new IntListTableModel(names,reasons));
		this.setDefaultRenderer(String.class, new IntListTableCellRender());
		this.setComponentPopupMenu(new TableMenu(this));
	}

	@Override
	public void update(Observable o, Object arg) {
		
		/* Making sure the right class is updating the table */
		if(o instanceof CommandManager) {

			Object[] arr = (Object[]) arg;
			Class<?> commandClass = (Class<?>) arr[0];
			String[] arguments = (String[]) arr[1];
			updateTable(commandClass,arguments);
		}
		
		return;
		
	}
	
	/**
	 * Depending on the type of Command, an update will happen.
	 * 
	 * @param commandClass The class of the Command
	 * @param arguments The arguments passed to the Command
	 */
	private void updateTable(Class<?> commandClass, String[] arguments) {
				
		/* if it's an AddCommand */
		if(commandClass.equals(AddCommand.class))
			
			this.addNewEntry(arguments);
		
		/* if it's a RemoveCommand */
		else if(commandClass.equals(RemoveCommand.class))
			
			this.removeEntry(arguments);
		
		/* if it's a ClearCommand */
		else if(commandClass.equals(ClearCommand.class))
			
			this.clearTable();
	}
	
	/**
	 * This method will delete the entire Table. WHO THE FUCK WOULD DELETE AN INT LIST FFS.
	 */
	private void clearTable() {
		
		this.setModel(
				new IntListTableModel(
						new ArrayList<Object>(),
						new ArrayList<Object>()
						)
				);
		
	}

	/**
	 * <pre>This method will remove an entry from the Table model vector.
	 *  
	 * @param arguments The argument passed to the Command object
	 */
	private void removeEntry(String[] arguments) {
				
		IntListTableModel model = (IntListTableModel) this.getModel();
		
		for(int i=0;i<arguments.length;i++) {
			
			for(int j=0;j<model.getDataVector().size();j++) {
			
				if(model.getValueAt(j, IntListTableModel.NAME).equals(arguments[i])) {
				
						model.removeRow(j);
						break;
				}
				
			}
		}
		
		// update the row indexes
		for(int i=0;i<model.getRowCount();i++)
			
			model.setValueAt(i, i, 0);

	}
	
	/**
	 * This method will add a new entry to the Table model array
	 * 
	 * @param arguments The argument passed to the Command object
	 */
	private void addNewEntry(String[] arguments) {
		
		IntListTableModel model = (IntListTableModel) this.getModel();
		
		for(int i=0;i<arguments.length-1;i++)  {
				
			model.addRow(new Object[]{
					String.valueOf(this.getRowCount()), // #Entry
						arguments[i], // The name of the kid
						arguments[arguments.length-1] // the reason
						}
			);
				
		}
	}
	
}

// end of IntListTable class code


/**
 * The model table of the IntList table.
 * 
 * @author Only Brad
 *
 */
class IntListTableModel extends DefaultTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5160558076195370719L;
	static final int NB = 0; // number of the entry column
	static final int NAME = 1; // name column
	static final int REASON = 2; // reason column
	static final int REMOVE_BUTTON = 3; // remove button column

	/**
	 * If the IntList 
	 * 
	 * @param intList
	 */
	@SuppressWarnings("unchecked")
	IntListTableModel(List<Object> names, List<Object> reasons) {
		
		super(0,3);
				
		for(int i=0;i<names.size();i++) {
			
			Vector<Object> data = new Vector<>();
			data.add(i);
			data.add(names.get(i));
			data.add(reasons.get(i));
			
			this.dataVector.add(data);
		}
	}
	
	@Override
	public String getColumnName(int column) {
		
		switch(column) {
		case NB: return "#";
		case NAME: return "Name";
		case REASON: return "Reason";
		case REMOVE_BUTTON: return "buttons";
		default: return "";
		}
	}
	
	/**
	 * Can't edit it yet
	 */
	@Override
	public boolean isCellEditable(int row, int column) {

		return false;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		return String.class;
	}
	
	
}

// end of IntListTableModel class code

/**
 * 
 * The Table Cell Renderer of the Int List, this class will add a background color (LIGHT_GRAY)
 * to every 2 rows.
 * 
 * @author Only Brad
 *
 */
class IntListTableCellRender extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 589666527684456241L;
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		if(row % 2 == 1)
			
			cell.setBackground(Color.WHITE);
		
		else
			
			cell.setBackground(Config.getInstance().ALTERNATIVE_CELL_COLOR);

		cell.setForeground(Color.BLACK);
		
		return cell;
	}

	
}

// end of IntListTableCellRender class clode