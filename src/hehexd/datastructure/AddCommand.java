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
	
	private String[] arguments; // the arguments
	
	public AddCommand(IntList intList) {
		super(intList);
	}
	
	@Override
	public Boolean apply(String[] arguments) {
		
		this.arguments = arguments;
		
		if(arguments.length == 1)
			
			this.addTheKidToTheIntList(arguments[0], "Reason not Specified.");
		
		/* specific reason why the kid's being added to the int list */
		if(arguments.length == 2) {
	
			String kid = arguments[0];
			String reason = arguments[1];
			this.addTheKidToTheIntList(kid,reason);
			this.setChanged();
		}
		
		/* otherwise it's your whole team added to the int list */
		else if(arguments.length > 2) {
			
			this.intList.addUselessTeam(arguments);
			this.setChanged();
		}
		
		IntListSaver.getInstance().save(this.intList);
		this.notifyObservers("add");
		
		return true;
		
	}
	
	
	
	/**
	 * 
	 * @param kid the guy who needs to khs
	 * @param reason if you really need to know why he's in the int list
	 */
	private void addTheKidToTheIntList(String kid, String reason) {
		
		switch(reason) {
		case "feeder" : this.intList.addFeeder(kid); break;
		case "jungler" : this.intList.addUselessJungler(kid); break;
		default : this.intList.add(kid, reason);
		}
	
	}
	
	@Override
	public String toString() {
		
		if(this.arguments.length == 2)
			
			return this.arguments[0]+" has been added to the IntList. Reason: "+this.arguments[1];
		
		else if(this.arguments.length > 2) {
			
			String shitTeam = "";
			
			for(String shitTeammate : this.arguments)
				
				shitTeam += shitTeammate+", ";
			
			shitTeam += "have been added to the IntList.";
			
			return shitTeam;
		}
			
		else return null;
	}

}
