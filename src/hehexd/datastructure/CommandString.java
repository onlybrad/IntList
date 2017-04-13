package hehexd.datastructure;


/**
 * A class that generates a String representation of a Command: toSuccessString, toFailureString or toString.
 * 
 * @author Only Brad
 *
 */
public abstract class CommandString {

	protected Command command; // The command that is being represented
	
	/**
	 * 
	 * @param command The command that is being represented
	 */
	CommandString(Command command) {
		
		this.command = command;
	}
	
	/**
	 * 
	 * @return a String representation of the Success of the represented command. A Failure
	 * means that the Command did not execute properly (due to bad arguments or unexpected events):
	 * if your command is suppose to return a value but didn't return anything, the Command is still
	 * considered a success.
	 */
	public abstract String toSuccessString();
	
	/**
	 * 
	 * @return a String representation of the Failure of the represented command
	 */
	public abstract String toFailureString();
	
	@Override
	/**
	 * toString of this class is the the toString of the represented command
	 */
	public String toString() {
		
		return this.command.toString();
	}
}
