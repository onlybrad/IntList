package main;

import hehexd.datastructure.*;
import hehexd.ioclasses.IntListLoader;

/**
 * It's the main you retard.
 * Why are you still reading the Javadoc of the main ? Jesus fucking christ, why are you even
 * reading this Java code ? GTFO and use the IntList instead of dicking around.
 * DUDE 
 * STOP READING FFS.
 * 
 * This is the line of command version, if you want the GUI it's not here.
 * 
 * @author Only Brad
 *
 */
public class IntListApp {

	/**
	 * 
	 * Commands:
	 * add [reason] [name] : will add the retard [name] for [reason] in the IntList
	 * [reason] = {"jungler","team","feeder",ANYTHING ELSE};
	 * add [name1] [name2] ... [nameN] : will add your whole fucking team to the IntList LOL
	 * clear : will reset the IntList, no fucking idea why would you do that though, kids should remain in
	 * 		   the int list
	 * save : will save manually, add will automatically save after each add and clear
	 * ragequit : ALT + F4
	 * 
	 * @param args
	 */

	private static IntList intList;
	
	public static void main(String[] args) {
		
		intList = IntListLoader.getInstance().getIntList();
		LineOfCommand lineOfCommand = BasicLineOfCommandFactory.getInstance(intList).create();
		lineOfCommand.start();

	}
	
	
}
