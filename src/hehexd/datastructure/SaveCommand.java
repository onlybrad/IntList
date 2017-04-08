package hehexd.datastructure;

import hehexd.ioclasses.IntListSaver;

/**
 * It's to fucking save the IntList. How hard can it be to understand this concept ?
 * 
 * @author Only Brad
 *
 */
public class SaveCommand extends Command {

	private final IntList intList; // here we go again...

	/**
	 * 
	 * @param intList DO I REALLY NEED TO...
	 */
	public SaveCommand(IntList intList) {
		
		this.intList = intList;
	}
	
	@Override
	public Boolean apply(String[] t) {
		
		if(t == null || t.length == 0 )
			
			IntListSaver.getInstance().save(this.intList);
		
		else
			
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		
		return "File has been saved.";
	}

}
