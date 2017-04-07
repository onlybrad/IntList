package datastructure;

import java.util.function.Function;

/**
 * An abstract Command for the LineOfCommand. All direct class of Command must implement the method
 * of the interface Function.
 * 
 * @author Only Brad
 *
 */
public abstract class Command implements Function<String[], Void> {
	
	
	
	@Override
	/**
	 * @param t the command without with the command name
	 */
	public abstract Void apply(String[] t);

/* No fucking idea what to put here, maybe make it visitable or observable... 
I dunno, who the fuck cares away LOL XD*/
	
	
	
}
