package datastructure;

import java.util.*;

/**
 * The line of command class.
 * 
 * @author Only Brad
 *
 */
public class LineOfCommand {
	
	private final Map<String, Command> commands; // The map of the commands and their functions
	private String[] inputBuffer; // User input stored here as array
	
	/**
	 * 
	 * @param commands a LineOfCommand needs commands, Jesus Christ isn't that obvious ? ffs.
	 */
	public LineOfCommand(Map<String,Command> commands) {
		
		this.commands = commands;
	}

	
	/**
	 * Begin the LineOfCommand.
	 */
	public void start() {
		
		@SuppressWarnings("resource") // WHO THE FUCK CARES
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			String input = scanner.nextLine();
			
			if(input.length() > 0) 
				
				this.inputBuffer = input.trim().split("\\s+");
			
			else
				
				continue;
			
			if(this.commandExists()) {
				
				String[] arguments = Arrays.copyOfRange(this.inputBuffer, 1, this.inputBuffer.length);
				
				this.commands.get(this.inputBuffer[0]).apply(arguments);
				
			}

		}
		
	}


	private boolean commandExists() {
		
		return this.commands.containsKey(this.inputBuffer[0]);
	}
	

}
