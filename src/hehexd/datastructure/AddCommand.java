package hehexd.datastructure;

import java.util.*;

import hehexd.ioclasses.IntListSaver;
import hehexd.randomcrap.WhatTheFuckAreYouDoingException;

/**
 * Adding a kid to the IntList, probably the most important thing in here outside of kys in solo queue.
 * 
 * @author Only Brad
 *
 */

public class AddCommand extends Command {
	
	private String[] arguments; // the arguments
	private List<String> addedKids; // the kids that were added
	
	public AddCommand(IntList intList) {
		
		super(intList);
		
	}
	
	@Override
	public Boolean apply(String[] arguments) {
		
		this.arguments = arguments;
		this.addedKids = new ArrayList<>();
		
			if(arguments.length == 1) {
				
				this.intList.put(arguments[0], "");
				this.addedKids.add(arguments[0]);
			}
					
			/* otherwise it's your whole team added to the int list, the reason is the last argument */
			else if(arguments.length > 1) {
				
				for(int i=0;i<arguments.length-1;i++) {
					
					try {
						this.intList.put(arguments[i], arguments[arguments.length-1]);
						this.addedKids.add(arguments[i]);
					}
					/* the kid was already in the int list, don't do anything */
					catch(WhatTheFuckAreYouDoingException e) {}
				}
			}
			
			/* if at least 1 kid was added to the int list then the command has succeeded */
			if(this.addedKids.size() > 0) {
				
				
				IntListSaver.getInstance().save(this.intList);
				return true;
			}

			return false;
	}
		
	
	@Override
	public String toString() {
		
		return "add";
			
	}

	@Override
	public CommandString getCommandString() {
		
		return new CommandString(this) {

			@Override
			public String toSuccessString() {
				
				AddCommand command = (AddCommand) this.command;
				
				if(command.addedKids.size() == 1)
					
					return command.arguments[0]+" has been added to the IntList. Reason: "
					+command.arguments[arguments.length-1];
				
				else {
					
					String shitTeam = "";
					
					for(int i=0;i<command.addedKids.size()-1;i++)
						
						shitTeam += command.addedKids.get(i)+", ";

					shitTeam += "and "+command.addedKids.get(command.addedKids.size()-1)
							+ " have been added to the IntList. Reason: "+
							command.arguments[arguments.length-1];;
					
					return shitTeam;
				}
			}

			@Override
			public String toFailureString() {

				return "Add Command has failed: No kid has been added to the IntList.";
			}
			
		};
	}

	
}
