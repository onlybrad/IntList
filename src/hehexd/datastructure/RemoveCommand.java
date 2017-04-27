package hehexd.datastructure;

import java.util.*;

import hehexd.ioclasses.IntListSaver;
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
		
		for(String kid : kids) {
			
			try {
				this.intList.remove(kid);
				this.removed.add(kid);
			}
			catch(WhatTheFuckAreYouDoingException e) {
				
				this.notRemoved.add(kid);
			}
			
		}
		
		IntListSaver.getInstance().save(intList);
		/* if at least 1 kid was removed from the int list then the command has succeeded */
		return this.removed.size()>0;
	
	}



	@Override
	public CommandString getCommandString() {
		
		return new CommandString(this) {
			
			@Override
			public String toSuccessString() {
				
				RemoveCommand command = (RemoveCommand) this.command;
				String s = "";
				
				if(!removed.isEmpty())
					
					s+= buildString(command.removed," have"," has"," been removed from the IntList.");
				
				else
					
					s += "No kids were removed from the IntList.\n";
				
				
				if(!command.notRemoved.isEmpty())
					
					s+= buildString(command.notRemoved," were"," was"," not in the IntList, you idiot.");
				
				return s;
			}

			@Override
			public String toFailureString() {
				
				return "Remove Command has failed : no kid was removed from the IntList.";
			}
			
			/**
			 * Function to create a string for the toSuccessString() method.
			 * 
			 * @param list a list of kids
			 * @param pluralForm the plural form of the verb
			 * @param singularForm the singular form of the verb
			 * @param oldText the text to which you want to append
			 * @param lastText the last part of the text to generate
			 * @return
			 */
			private String buildString(List<String> list, String pluralForm, String singularForm, String lastText) {
				
				boolean plural = false;
				String text = "";
				text += "The kid"+ ( list.size()==1 ? " ": "s "); // is it plural ?
				
				/* add all but the last kid in the string */
				for(int i=0;i<list.size()-1;i++) {
					
					text += list.get(i)+", "; 
					plural = true;
				}
				
				/* add the last kid */
				text += list.get(list.size()-1) 
						+ (plural?pluralForm:singularForm) + lastText;
				
				return text;
			}
			
		};
		
		
	}

}
