package hehexd.gui;

import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
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
	private IntList intList;

	IntListTable(IntList intList) {

		this.setModel(new IntListTableModel(this.intList = intList));
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
		
		if(commandClass.getClass().equals(ClearCommand.class))
			
			this.clearTable();
		
		this.setModel(new IntListTableModel(this.intList = intList));
	}
	
	/**
	 * This method will delete the entire Table. WHO THE FUCK WOULD DELETE AN INT LIST FFS.
	 */
	private void clearTable() {
		
		IntListTableModel model = (IntListTableModel) this.getModel();
		
		model.intList = new TreeMap<>();
		model.names = new ArrayList<>();
		model.reasons = new ArrayList<>();
		
	}

	/**
	 * This method will remove an entry from the Table model array and update its Map copy of the IntList
	 * 
	 * @param arguments The argument passed to the Command object
	 */
	private void removeEntry(String[] arguments) {
		
		IntListTableModel model = (IntListTableModel) this.getModel();
		
		for(int i=0;i<arguments.length;i++) {
			
			String reason = model.intList.remove(arguments[i]);
			model.names.remove(arguments[i]);
			model.names.remove(reason);
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
			
			model.names.add(arguments[0]);
			model.reasons.add("");
			model.intList.put(arguments[0],"");
		}
		
		else {
			
			for(int i=0;i<arguments.length-1;i++) {
				
				model.names.add(arguments[i]);
				model.reasons.add(arguments[i-1]);
				model.intList.put(arguments[i],arguments[i-1]);
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
class IntListTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5160558076195370719L;
	private static final int NAME = 0;
	private static final int REASON = 1;
	Map<String,String> intList;
	List<Object> names;
	List<Object> reasons;
	
	IntListTableModel(Map<String,String> intList) {
	
		this.intList = new TreeMap<>(intList);
		this.names = new ArrayList<>(this.intList.keySet());
		this.reasons = new ArrayList<>(this.intList.values());
	}
	
	
	@Override
	public int getRowCount() {
		
		return this.intList.keySet().size();
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