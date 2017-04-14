package hehexd.datastructure.commandline;

import java.util.*;

import hehexd.datastructure.Command;

/**
 * Create commands for the LineOfCommand class. Why do we have to create commands like this instead
 * of putting everything in the main like any normal human being ? Cuz I want to troll you.
 * 
 * @author Only Brad
 *
 */
public class CommandLineBuilder {
	
	private final Map<String, Command> commands; // a Map containing all the commands and their function
	private String messageError; // the message error when the message fails
	private String decoration; // the string that appears at the beginning of the line of command
	private String messageSuccess; // the message that appears when the command is successful
	
	public CommandLineBuilder() {
		
		this.commands = new HashMap<>();
	}
	
	/**
	 * 
	 * @param command The Command object that needs to be executed
	 * @param commandNames the list of all names that refer to the Command in the line of command (aliases)
	 * @return it's a Builder, what do you think is returned ?
	 */
	public CommandLineBuilder addCommand(Command command,String ... commandNames) {
		
		for(String commandName : commandNames)
			
			this.commands.put(commandName, command);
		
		return this;		
	}
	
	/**
	 * 
	 * @param messageError The message error when the dumb user uses a wrong command
	 * @return it's a Builder, what do you think is returned ?
	 */
	public CommandLineBuilder addMessageError(String messageError) {
		
		this.messageError = messageError;
		return this;
	}
	
	/**
	 * 
	 * @param messageSuccess Feedback when the command worked
	 * @return it's a Builder, what do you think is returned ?
	 */
	public CommandLineBuilder addMessageSuccess(String messageSuccess) {
		
		this.messageSuccess = messageSuccess;
		return this;
	}
	
	/**
	 * 
	 * @param decoration what goes before typing in the LineOfCommand
	 * @return it's a Builder, what do you think is returned ?
	 */
	public CommandLineBuilder addDecoration(String decoration) {
		
		this.decoration = decoration;
		return this;
	}
	
	/**
	 * 
	 * @return null if there are no commands, no message or decoration. 
	 * Why ? cuz fuck you. Otherwise return a lineOfCommand object.
	 */
	public CommandLine get() {
		
		if(this.commands.isEmpty() || 
		   this.messageError == null || 
		   this.messageSuccess == null ||
		   this.decoration == null) 
		   
			return null;
		
		return new SpecialLineOfCommand() {

			@Override
			protected void decoration() {
				
				System.out.print(CommandLineBuilder.this.decoration);
			}

			@Override
			protected void errorMessage(String extra) {
				
				System.out.println(CommandLineBuilder.this.messageError + extra);
				
			}

			@Override
			protected void successMessage(String extra) {
				
				System.out.println(CommandLineBuilder.this.messageSuccess + extra);
				
			}
	
		};
			
	}
	
	
	/**
	 * It's "special", as in I just wanted to add an empty arguments constructor so that I can use this
	 * to make an anonymous class. It's just a Java thing.
	 * 
	 * @author Only Brad
	 *
	 */
	public abstract class SpecialLineOfCommand extends CommandLine {
		
		protected SpecialLineOfCommand() {
			super(commands);
		}

	}
}
