package hehexd.datastructure;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import hehexd.randomcrap.WhatTheFuckAreYouDoingException;

/**
 * Have you ever wished to feed your ass off because some moron feeder or useless jungler
 * made you waste at least 20 minutes of your life - while probably blaming you for the loss at the same time-
 * With this class, this is going to be possible! 
 * This class will track the name of the assholes by adding it to a HashMap, 
 * associating their name to whatever the fuck they did to you. Next game, you can run a check and 
 * verify if any of your 4 teammates exist in the IntList, if they do you can start feeding your ass off, 
 * making them regret ever wasting your time. Especially those fucking useless junglers who only AFK farm 
 * and blame laners for losing 4v5.
 * 
 * Key = name of the kid
 * Value = reason you added the kid
 * 
 * @author Only Brad
 * @author tyler1
 */
public class IntList extends HashMap<String,String> implements Serializable{
	
	private static final long serialVersionUID = 1624105729432324321L;
	
	/**
	 * If for some god knows reason you want to remove a kid from the int list, use 
	 * this method
	 * 
	 * @Override
	 * @param name the kid your want to remove for god knows what reason
	 */
	public void remove(String name) {
		
		if(this.containsKey(name))
			
			super.remove(name);
		
		else
			
			throw new WhatTheFuckAreYouDoingException(name+" is not in the intlist you dumbfuck");
	
	}


}
