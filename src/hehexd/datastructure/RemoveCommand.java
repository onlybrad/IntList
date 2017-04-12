package hehexd.datastructure;

import java.util.*;
import hehexd.randomcrap.WhatTheFuckAreYouDoingException;

/**
 * Remove specific guys from the IntList. DON'T DO THIS FOR THE LOVE OF GOD.
 * 
 * @author Only Brad
 *
 */
public class RemoveCommand extends Command {

	private List<String> notRemoved; // THE KIDS YOU TRIED TO REMOVE BUT ARENT IN THE LIST LOL
	private List<String> removed; // WHY DID YOU DO THAT?
	
	public RemoveCommand(IntList intList) {
		super(intList);
	}

	@Override
	public Boolean apply(String[] kids) {
		
		this.notRemoved = new ArrayList<>();
		this.removed = new ArrayList<>();
		boolean isRemoved = false; // if removed at least 1 kid, then this becomes true
		
		for(String kid : kids) {
			
			try {
				this.intList.remove(kid);
				this.removed.add(kid);
				isRemoved = true;
			}
			catch(WhatTheFuckAreYouDoingException e) {
				
				this.notRemoved.add(kid);
			}
			
		}
		
		return isRemoved;
	
	}

	@Override
	public String toString() {

		String s = "";
		
		if(!this.removed.isEmpty())
			
			s+= buildString(this.removed," have"," has",s," been removed from the IntList.");
		
		else
			
			s += "No kids were removed from the IntList.\n";
				
		if(!this.notRemoved.isEmpty())
			
			s+= buildString(this.notRemoved," were"," was",s, " not in the IntList, you idiot.");
		
		return s;
		
	}
	
	/**
	 * Function to create a string for the toString() method.
	 * 
	 * @param list a list of kids
	 * @param pluralForm the plural form of the verb
	 * @param singularForm the singular form of the verb
	 * @param oldText the text to which you want to append
	 * @param lastText the last part of the text to generate
	 * @return
	 */
	private static String buildString(List<String> list, String pluralForm, String singularForm, String oldText, String lastText) {
		
		boolean plural = false;
		oldText += "The kid"+ ( list.size()==1 ? " ": "s "); // is it plural ?
		
		/* add all but the last kid in the string */
		for(int i=0;i<list.size()-1;i++) {
			
			oldText += list.get(i)+", "; 
			plural = true;
		}
		
		/* add the last kid */
		oldText += list.get(list.size()-1) 
				+ (plural?pluralForm:singularForm) + lastText;
		
		return oldText;
	}

}
