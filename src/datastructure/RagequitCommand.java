package datastructure;

import randomcrap.WhatTheFuckAreYouDoingException;

/**
 * To leave the fucking app
 * 
 * @author Only Brad
 *
 */
public class RagequitCommand extends Command {

	@Override
	public Void apply(String[] t) {
		
		if(t == null || t.length == 0 )
			
			System.exit(420);
		
		throw new WhatTheFuckAreYouDoingException("JUST TYPE \"ragequit\" you moron");
		
	}
	
}
