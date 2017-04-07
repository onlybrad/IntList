package randomcrap;

/**
 * You must be really dumb if an exception like this is thrown in the program. Don't be fucking dumb.
 * Do you want to be added someone else's int list ? so stop being dumb, idiot.
 * 
 * @author Only Brad
 *
 */
public class WhatTheFuckAreYouDoingException extends RuntimeException {

	private static final long serialVersionUID = 5196937134812703118L;
	
	public WhatTheFuckAreYouDoingException(String dumbReason) {
		
		super("Are you trying to fuck with me? "+ dumbReason);
	}
}
