package hehexd.datastructure;

/**
 * 
 * The command that prints the IntList in textual form. The string is stored in an Answer object if 
 * needed somewhere else. Otherwise, because of the nature of the command, the CommandString::toSuccessString
 * will return exactly the same value.
 * 
 * @author Only Brad
 *
 */
public class ListCommand extends AnswerableCommand<String> {
	
	private String list; // the string that represents the IntList;
	
	
	protected ListCommand(IntList intList) {
		super(intList);
	}

	@Override
	public Boolean apply(String[] t) {
		
		this.list = "[ ";
		
		if(t == null || t.length == 0) {

			for(String name : this.intList.keySet()) 
				
				this.list += "{ "+name+":"+this.intList.get(name)+" }";
			
			this.list += " ]";
			
			this.answer.setAnswer(this.list);
			return true;
			
		}
		
		return false;
	}

	@Override
	public CommandString getCommandString() {
		
		return new CommandString(this) {

			@Override
			public String toSuccessString() {
				
				ListCommand command = (ListCommand) this.command;
				
				return command.list;
			}

			@Override
			public String toFailureString() {
				
				return "Failed to show list. The List Command doesn't use arguments.";
			}
			
		};
	}

}
