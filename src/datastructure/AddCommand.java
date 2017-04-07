package datastructure;

import ioclasses.IntListSaver;

/**
 * Adding a kid to the IntList, probably the most important thing in here outside of kys in solo queue.
 * 
 * @author Only Brad
 *
 */

public class AddCommand extends Command {
	
	private final IntList intList; // hehe xd
	
	/**
	 * 
	 * @param intList The fucking IntList xD
	 */
	public AddCommand(IntList intList) {
		
		this.intList = intList;
	}
	
	@Override
	public Void apply(String[] arguments) {
		
		/* specific reason why the kid's being added to the int list */
		if(arguments.length == 2) {
	
			String kid = arguments[0];
			String reason = arguments[1];
			this.addTheKidToTheIntList(kid,reason);
			return null;
		}
		
		/* otherwise it's your whole team added to the int list */
		if(arguments.length > 2)
			
			this.intList.addUselessTeam(arguments);
		
		IntListSaver.getInstance().save(this.intList);
		return null;
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

}
