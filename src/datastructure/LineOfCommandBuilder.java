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
	
	private Map<String, Command> commands; // a Map containing all the commands and their function
	private String messageError;
	private String decoration;
	private String messageSuccess;
	
	public LineOfCommandBuilder() {
		
		this.commands = new HashMap<>();
	}
	
	/**
	 * 
	 * @param commandName The name of the command
	 * @param function the fucking function of the command
	 * @return it's a Builder, what do you think is returned ?
	 */
	public LineOfCommandBuilder addCommand(String commandName, Command command) {
		
		this.commands.put(commandName, command);
		return this;		
	}
	
	/**
	 * 
	 * @param messageError The message error when the dumb user uses a wrong command
	 * @return it's a Builder, what do you think is returned ?
	 */
	public LineOfCommandBuilder addMessageError(String messageError) {
		
		this.messageError = messageError;
		return this;
	}
	
	/**
	 * 
	 * @param messageSuccess Feedback when the command worked
	 * @return
	 */
	public LineOfCommandBuilder addMessageSuccess(String messageSuccess) {
		
		this.messageSuccess = messageSuccess;
		return this;
	}
	
	/**
	 * 
	 * @param decoration what goes before typing in the LineOfCommand
	 * @return
	 */
	public LineOfCommandBuilder addDecoration(String decoration) {
		
		this.decoration = decoration;
		return this;
	}
	
	/**
	 * 
	 * @return null if there are no commands, no message or decoration 
	 * Why ? cuz fuck you. Otherwise return a lineOfCommand object.
	 */
	public LineOfCommand get() {
		
		if(this.commands.isEmpty() || 
		   this.messageError == null || 
		   this.messageSuccess == null ||
		   this.decoration == null) 
		   
			return null;
		
		return new SpecialLineOfCommand() {

			@Override
			protected void decoration() {
				
				System.out.print(LineOfCommandBuilder.this.decoration);
			}

			@Override
			protected void errorMessage(String extra) {
				
				System.out.println(LineOfCommandBuilder.this.messageError + extra);
				
			}

			@Override
			protected void successMessage(String extra) {
				
				System.out.println(LineOfCommandBuilder.this.messageSuccess + extra);
				
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
	public abstract class SpecialLineOfCommand extends LineOfCommand {
		
		protected SpecialLineOfCommand() {
			super(commands);
		}

	}
}
