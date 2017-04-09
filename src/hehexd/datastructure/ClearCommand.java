package hehexd.datastructure;

import hehexd.ioclasses.IntListSaver;

/**
 * I have absolutely no fucking idea why anyone would use this, this command will wipe the whole
 * IntList.
 * 
 * @author Only Brad
 *
 */
public class ClearCommand extends Command {


	protected ClearCommand(IntList intList) {
		super(intList);
	}

	@Override
	public Boolean apply(String[] t) {

		if(t == null || t.length == 0 ) {
			
			this.intList.clear();
			IntListSaver.getInstance().save(this.intList);
			this.notifyObservers("clear");
			return true;
		}
		
		return false;
		
	}

	@Override
	public String toString() {
		
		return "IntList cleared";
	}

}
