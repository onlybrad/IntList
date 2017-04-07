package datastructure;

import java.util.*;

/**
 * Create commands for the LineOfCommand class. Why do we have to create commands like this instead
 * of putting everything in the main like any normal human being ? Cuz I want to troll you.
 * 
 * @author Only Brad
 *
 */
public class LineOfCommandBuilder {
	
	private final LineOfCommand lineOfCommand; // The LineOfCommand to return
	private Map<String, Command> commands; // a Map containing all the commands and their function
	
	public LineOfCommandBuilder() {
		
		this.commands = new HashMap<>();
		this.lineOfCommand = new LineOfCommand(this.commands);
		
	}
	
	/**
	 * 
	 * @param commandName The name of the command
	 * @param function the fucking function of the command
	 * @return
	 */
	public LineOfCommandBuilder addCommand(String commandName, Command command) {
		
		this.commands.put(commandName, command);
		
		return this;	
		
	}
	
	/**
	 * 
	 * @return null if there are no commands. Why ? cuz fuck you. Otherwise return the lineOfCommand object.
	 */
	public LineOfCommand get() {
		
		if(this.commands.isEmpty())
			
			return null;
		
		return this.lineOfCommand;
	}
}
