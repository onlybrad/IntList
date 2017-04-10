package hehexd.datastructure;

import hehexd.ioclasses.IntListSaver;

/**
 * Adding a kid to the IntList, probably the most important thing in here outside of kys in solo queue.
 * When a change happens, all the observers are notified with the "add" String.
 * 
 * @author Only Brad
 *
 */

public class AddCommand extends Command {
	
	private String[] arguments = {""}; // the arguments
	
	public AddCommand(IntList intList) {
		super(intList);
	}
	
	@Override
	public Boolean apply(String[] arguments) {
		
		this.arguments = arguments;
		
		if(arguments.length == 1)
			
			this.intList.put(arguments[0], "Unspecified.");
				
		/* otherwise it's your whole team added to the int list, the reason is the last argument */
		else if(arguments.length > 1) {
			
			for(int i=0;i<arguments.length-1;i++)
				
				this.intList.put(arguments[i], arguments[arguments.length-1]);
		}
		
		IntListSaver.getInstance().save(this.intList);
		this.notifyObservers("add");
		
		return true;
		
	}
	
	@Override
	public String toString() {
		
		if(this.arguments.length <= 2)
			
			return this.arguments[0]+" has been added to the IntList. Reason: "+this.intList.get(this.arguments[0]);
		
		else {
			
			String shitTeam = "";
			
			for(int i=0;i<this.arguments.length-2;i++)
				
				shitTeam += this.arguments[i]+", ";
	
			shitTeam += "and "+this.arguments[this.arguments.length-2]
					+ " have been added to the IntList. Reason: "+this.intList.get(this.arguments[0]);
			
			return shitTeam;
		}
			
	}

}
