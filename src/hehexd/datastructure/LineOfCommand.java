package hehexd.datastructure;

import java.util.*;

/**
 * The line of command class.
 * 
 * @author Only Brad
 *
 */
public abstract class LineOfCommand {
	
	private final Map<String, Command> commands; // The map of the commands and their functions
	private String[] inputBuffer; // User input stored here as array
	
	/**
	 * 
	 * @param commands a LineOfCommand needs commands, Jesus Christ isn't that obvious ? ffs.
	 */
	protected LineOfCommand(Map<String,Command> commands) {
		
		this.commands = commands;
	}

	
	/**
	 * Begin the LineOfCommand.
	 */
	public void start() {
		
		@SuppressWarnings("resource") // WHO THE FUCK CARES
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			this.decoration();
			String input = scanner.nextLine();
			
			if(input.length() > 0) 
				/* Put the string inside an array without the separator (aka SPACE) */
				this.inputBuffer = input.trim().split("\\s+");
			
			else
				/* Empty string = you`re a dumbfuck who pressed enter without entering a command */
				continue;
			
			if(this.commandExists()) {
				
				/* remove the command name, leave the arguments */
				String[] arguments = Arrays.copyOfRange(this.inputBuffer, 1, this.inputBuffer.length);
				Command command = this.commands.get(this.inputBuffer[0]);
				
				/* execute the command with the arguments, and if it succeeds, put a message */
				if(command.apply(arguments))
					
					this.successMessage(command.toString());
				
				else
					
					this.errorMessage();
			}
			
			else
				
				this.errorMessage();

		}
		
	}


	private boolean commandExists() {
		
		return this.commands.containsKey(this.inputBuffer[0]);
	}
	
	/**
	 * Line of command decoration, every time a new command is issued.
	 */
	protected abstract void decoration();
	
	/**
	 * Message error when the retard uses an inexistent command
	 * @param extra more info
	 */
	protected abstract void errorMessage(String extra);
	
	/**
	 * Message message after a successful command
	 * @param extra more info
	 */
	protected abstract void successMessage(String extra);
	
	/**
	 * Message error without extra
	 */
	protected void errorMessage() {
		
		this.errorMessage("");
	}
	
	/**
	 * Message success without extra
	 */
	protected void successMessage() {
		
		this.successMessage("");
	}
}
