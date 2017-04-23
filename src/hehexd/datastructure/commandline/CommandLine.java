package hehexd.datastructure.commandline;

import java.util.*;

import hehexd.datastructure.Command;

/**
 * The line of command class. This object represents the command line interface. It uses the
 * System.out stream to read the user's command, then depending on the command input, a Command object
 * will be executed.
 * 
 * @author Only Brad
 *
 */
public abstract class CommandLine {
	
	private final Map<String, Command> commands; // The map of the commands and their functions
	private String[] inputBuffer; // User input stored here as array
	
	/**
	 * 
	 * @param commands a LineOfCommand needs commands, Jesus Christ isn't that obvious ? ffs.
	 * The String is the name of the command that is passed to the line of command, the COmmand
	 * is its associated Command object.
	 */
	protected CommandLine(Map<String,Command> commands) {
		
		this.commands = commands;
	}

	
	/**
	 * Begin the LineOfCommand, the execution of the line of command happens after this method is
	 * called.
	 */
	public void start() {
		
		@SuppressWarnings("resource") // WHO THE FUCK CARES
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			this.decoration(); // Begin by decoration the line of the command with a string
			String input = scanner.nextLine();
			Command command = null; // The command is the first string in the input
			
			if(input.length() > 0) 
				/* Put the string inside an array without the separator (aka SPACE) unless it's inside
				 * quotation mark */
				this.inputBuffer = input.trim().
							replaceAll("^\"", "").
							split("\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?");
			
			else
				/* Empty string = you`re a dumbfuck who pressed enter without entering a command */
				continue;
			
			if(this.commandExists()) {
				
				/* remove the command name, leave the arguments */
				String[] arguments = Arrays.copyOfRange(this.inputBuffer, 1, this.inputBuffer.length);
				command = this.commands.get(this.inputBuffer[0]);
				
				/* execute the command with the arguments, and if it succeeds, put a message */
				if(command.apply(arguments))
					
					this.successMessage(command.getCommandString().toSuccessString());
				
				else
					
					this.errorMessage(command.getCommandString().toFailureString());
			}
			
			else
				
				this.errorMessage("The command "+this.inputBuffer[0]+" does not exist.");

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
