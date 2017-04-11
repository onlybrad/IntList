package hehexd.randomcrap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Just a bunch of methods that can be used globally by any class
 * 
 * @author kassisch
 *
 */
public class GlobalMethods {

	/**
	 * Append a string to the end of a String Array.
	 * 
	 * @param names The kids that you added to the int list
	 * @param reason the reason you added them
	 * @return the array containing both the kids and the reason
	 */
	public static String[] addString(String[] names, String reason) {
		
		List<String> args = new ArrayList<>();
		args.addAll(Arrays.asList(names));
		args.addAll(Arrays.asList(reason));
		
		return args.toArray(new String[]{});
	}
}
