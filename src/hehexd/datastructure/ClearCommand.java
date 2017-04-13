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


	public ClearCommand(IntList intList) {
		super(intList);
	}

	@Override
	public Boolean apply(String[] t) {

		if(t == null || t.length == 0 ) {
			
			this.intList.clear();
			IntListSaver.getInstance().save(this.intList);
			return true;
		}
		
		return false;
		
	}

	@Override
	public CommandString getCommandString() {
		
		return new CommandString(this) {

			@Override
			public String toSuccessString() {
				
				return "IntList cleared";
			}

			@Override
			public String toFailureString() {
				
				return "IntList was not cleared";
			}
			
			
		};
	}

}
