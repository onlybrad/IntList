package datastructure;

import java.util.*;
import java.util.function.*;

/**
 * An abstract Command for the LineOfCommand. All direct class of Command must implement the method
 * of the interface Function. This class is Observable, it will notify all the observer of changes
 * that happen when a command is executed.
 * 
 * Function<String[],Boolean>
 * 
 * String[] is the the list of arguments passed to the Command
 * Boolean indicate if the command has been executed or not
 * 
 * @author Only Brad
 * 
 *
 */
public abstract class Command extends Observable implements Function<String[], Boolean>  {
	
	@Override
	/**
	 * @param t the command without with the command name
	 */
	public abstract Boolean apply(String[] t);

	/**
	 * YOU MUST FUCKING IMPLEMENT THIS CUZ ITS NEEDED IN LineOfCommand
	 */
	public abstract String toString();
	
	pu
	
}
