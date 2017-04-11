package hehexd.gui;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import hehexd.api.CommandManager;
import hehexd.datastructure.*;
import hehexd.randomcrap.GlobalMethods;


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
		System.out.println(Arrays.toString(((DefaultTableModel)this.getModel()).getDataVector().toArray()));
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
		
		System.out.println(Arrays.toString(((DefaultTableModel)this.getModel()).getDataVector().toArray()));
	}
	
	/**
	 * This method will delete the entire Table. WHO THE FUCK WOULD DELETE AN INT LIST FFS.
	 */
	private void clearTable() {
		
		this.setModel(new IntListTableModel(new ArrayList<Object>(),new ArrayList<Object>()));
		
	}

	/**
	 * This method will remove an entry from the Table model array and update its Map copy of the IntList
	 * 
	 * @param arguments The argument passed to the Command object
	 */
	private void removeEntry(String[] arguments) {
		
		IntListTableModel model = (IntListTableModel) this.getModel();
		
		for(int i=0;i<arguments.length;i++) {
			
			for(int j=0;j<arguments.length;j++) {
			
				if(model.getValueAt(j, 0).equals(arguments[i])) {
				
						model.removeRow(j);
						break;
				}
				
			}
		}

	}
	
	/**
	 * This method will add a new entry to the Table model array and update its Map copy of the IntList
	 * 
	 * @param arguments The argument passed to the Command object
	 */
	private void addNewEntry(String[] arguments) {
		
		IntListTableModel model = (IntListTableModel) this.getModel();
		
		if(arguments.length == 1)
			
			model.addRow(new String[]{arguments[0],""});
		
		else if(arguments.length > 1) 
			
			for(int i=0;i<arguments.length-1;i++)
				
				model.addRow(new String[]{arguments[i],arguments[arguments.length-1]});

	}
	
}

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
	static final int NAME = 0;
	static final int REASON = 1;
	
	/**
	 * If the IntList 
	 * 
	 * @param intList
	 */
	@SuppressWarnings("unchecked")
	IntListTableModel(List<Object> names, List<Object> reasons) {
		
		super(names.size(),2);
		
		for(int i=0;i<names.size();i++) {
			
			Vector<Object> data = new Vector<>();
			data.add(names.get(i));
			data.add(reasons.get(i));
			
			this.dataVector.add(data);
		}
	}
	
	@Override
	public String getColumnName(int column) {
		
		switch(column) {
		case NAME: return "Name";
		case REASON: return "Reason";
		default: return null;
		}
	}

}
