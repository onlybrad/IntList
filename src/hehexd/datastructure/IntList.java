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
 * @author Only Brad
 * @author tyler1
 */
public class IntList implements Serializable{
	
	private static final long serialVersionUID = 1624105729432324321L;
	private Map<String,String> list;
	
	public IntList() {
		
		this.list = new HashMap<>();
	}
	
	/**
	 * 
	 * @param name the feeder
	 */
	public void addFeeder(String name) {
		
		this.list.put(name, "Fucking feeder.");
	}
	
	/**
	 * 
	 * @param name the useless jungler
	 */
	public void addUselessJungler(String name) {
		
		this.list.put(name, "Useless fucking jungler.");
	}
	
	/**
	 * 
	 * @param names retard team
	 */
	public void addUselessTeam(String[] names) {
		
		for(String name : names)
			
			this.list.put(name, "Useless fucking team.");
	}
	
	/**
	 * 
	 * @param name dumbass kid
	 */
	public void add(String name, String reason) {
		
		this.list.put(name, "Fuck this kid: "+reason);
	}
	
	/**
	 * The most important method, verify if your team is in the int list
	 * 
	 * @param name check if this kid is in the int list
	 * @return if I should int in his game
	 */
	public boolean isInIntList(String name) {
		
		return this.list.containsKey(name);
	}
	
	/**
	 * If for some god knows reason you want to remove a kid from the int list, use 
	 * this method
	 * 
	 * @param name
	 */
	public void removeFromIntList(String name) {
		
		if(this.list.containsKey(name))
			
			this.list.remove(name);
		
		else
			
			throw new WhatTheFuckAreYouDoingException(name+" is not in the intlist you dumbfuck");
	
	}
	
	/**
	 * Empty the IntList
	 */
	public void clear() {
		
		this.list.clear();
		
	}
	

	
}
