package hehexd.datastructure;

import java.util.function.*;



/**
 * An abstract Command for the LineOfCommand (can be treated as a functional interface). 
 * All direct subclasses of Command must implement the method
 * of the interface Function: apply. apply contains the core function of the Command. It returns
 * true if the command succeeded in executing its function, or false if it failed (for bad arguments
 * for example). All direct subclasses of Command must also implement the getCommandString, which returns
 * a CommandString object that has the role of generating String depending on the situation (success&failure)
 *  
 * Function&lt;String[],Boolean&gt;
 * 
 * String[] is the the list of arguments passed to the Command
 * Boolean indicate if the command has been executed or not
 * 
 * @author Only Brad
 * 
 *
 */
public abstract class Command implements Function<String[], Boolean> {
	
	protected final IntList intList; // THE FUCKING INTLIST LOL
	
	/**
	 * 
	 * @param intList THE INTLIST XD
	 */
	protected Command(IntList intList) {
		
		this.intList = intList;
	}
	
	@Override
	/**
	 * @param t the arguments without the command name
	 * @return if the command function succeeded in executing
	 */
	public abstract Boolean apply(String[] t);
	
	
	/**
	 * 
	 * @return a CommandString, an object that can represent the Command in a String : that object can return
	 * a successful string representation or a failure string representation.
	 */
	public abstract CommandString getCommandString();
	
	
		
}
