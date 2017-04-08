package hehexd.datastructure;

import hehexd.ioclasses.IntListSaver;

public class ClearCommand extends Command {
	
	private IntList intList;

	public ClearCommand(IntList intList) {
		
		this.intList = intList;
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
