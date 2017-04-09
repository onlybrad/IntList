package hehexd.datastructure;

import hehexd.randomcrap.WhatTheFuckAreYouDoingException;

/**
 * To leave the fucking app
 * 
 * @author Only Brad
 *
 */
public class RagequitCommand extends Command {

	@Override
	public Boolean apply(String[] t) {
		
		if(t == null || t.length == 0 )
			
			System.exit(420);
		
		return false;
		
	}
	
	@Override
	public String toString() {
		
		return null; // SHOULD NEVER BE CALLED
	}
}
