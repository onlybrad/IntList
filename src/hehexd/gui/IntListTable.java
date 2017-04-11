package hehexd.gui;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import hehexd.api.CommandManager;
import hehexd.datastructure.*;


/**
 * The IntList Table. Contains all the name/reason entries
 * This class observes the CommandManager in order to see what changes occured due to a Command
 * @author Only Brad
 *
 */
class IntListTable extends JTable implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8307915124668883263L;
	IntListTable(IntList intList) {

		this.setModel(new IntListTableModel(intList));
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
		if(commandClass.getClass().equals(AddCommand.class))
			
			this.addNewEntry(arguments);
		
		/* if it's a RemoveCommand */
		if(commandClass.getClass().equals(RemoveCommand.class))
			
			this.removeEntry(arguments);
		
		/* if it's a ClearCommand */
		if(commandClass.getClass().equals(ClearCommand.class))
			
			this.clearTable();
	}
	
	/**
	 * This method will delete the entire Table. WHO THE FUCK WOULD DELETE AN INT LIST FFS.
	 */
	private void clearTable() {
		
		this.setModel(new IntListTableModel());
		
	}

	/**
	 * This method will remove an entry from the Table model array and update its Map copy of the IntList
	 * 
	 * @param arguments The argument passed to the Command object
	 */
	private void removeEntry(String[] arguments) {
		
		IntListTableModel model = (IntListTableModel) this.getModel();
		
		for(int i=0;i<arguments.length;i++) {
			
			int j = model.names.indexOf(arguments[i]);
			model.removeRow(j);
			model.names.remove(j);
			model.reasons.remove(j);
		}
	}
	
	/**
	 * This method will add a new entry to the Table model array and update its Map copy of the IntList
	 * 
	 * @param arguments The argument passed to the Command object
	 */
	private void addNewEntry(String[] arguments) {
		
		IntListTableModel model = (IntListTableModel) this.getModel();
		
		if(arguments.length == 1) {
			
			model.setValueAt(arguments[0], model.names.size(),IntListTableModel.NAME);
			model.setValueAt("",model.reasons.size(),IntListTableModel.REASON);
			model.names.add(arguments[0]);
			model.reasons.add("");
		}
		
		else if(arguments.length > 1) {
			
			for(int i=0;i<arguments.length-1;i++) {
				
				model.setValueAt(arguments[i],model.names.size(), IntListTableModel.NAME);
				model.setValueAt(arguments[arguments.length-1], model.reasons.size(), IntListTableModel.REASON);
				model.names.add(arguments[i]);
				model.reasons.add(arguments[arguments.length-1]);
			}
				
		}
	}
}

/**
 * The model table of the IntList table: This class will keep a copy of the previous state
 * of the IntList in order to modify it's internal state.
 * 
 * @author Only Brad
 *
 */
class IntListTableModel extends DefaultTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5160558076195370719L;
	static final int NAME = 0;
	static final int REASON = 1;
	List<Object> names;
	List<Object> reasons;
	
	/**
	 * If the IntList 
	 * 
	 * @param intList
	 */
	IntListTableModel(IntList intList) {
		
		this.names = new ArrayList<>(intList.keySet());
		this.reasons = new ArrayList<>(intList.values());
		
	}
	
	/**
	 * If the IntList if empty (example after a wipe), use this constructor
	 */
	IntListTableModel() {
		
		this.names = new ArrayList<>();
		this.reasons = new ArrayList<>();
	} 
	
	
	@Override
	public int getRowCount() {
		
		return this.names.size() ==0 ? 0 : this.names.size();
	}

	@Override
	public int getColumnCount() {
		
		return 2;
	}

	@Override
	public String getColumnName(int column) {
		
		switch(column) {
		case NAME: return "Name";
		case REASON: return "Reason";
		default: return null;
		}
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch(columnIndex) {
		case NAME: return (String)this.names.get(rowIndex);
		case REASON: return (String)this.reasons.get(rowIndex);
		default: return null;
		}
		
	}
	
}