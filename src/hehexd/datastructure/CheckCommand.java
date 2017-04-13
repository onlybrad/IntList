package hehexd.datastructure;

/**
 * The command that checks if a kid is in the int list. It's an Answerable command that returns,
 * a boolean (Is this asshole in the int list or not?)
 * 
 * @author Only Brad
 *
 */
public class CheckCommand extends AnswerableCommand<Boolean> {
	
	private String kid; // the fucking kid
	
	public CheckCommand(IntList intList, Answer<Boolean> answer) {
		super(intList, answer);
	}

	public CheckCommand(IntList intList) {
		super(intList);
	}

	@Override
	public Boolean apply(String[] kid) {
		
		if( kid.length == 1) {
			
			this.kid = kid[0];
			boolean isInIntList = this.intList.containsKey(this.kid);
			this.answer.setAnswer(isInIntList);
			return true;
		}
			
		return false;
	}

	@Override
	public CommandString getCommandString() {
		
		return new CommandString(this) {

			@Override
			public String toSuccessString() {
				
				CheckCommand command = (CheckCommand) this.command;
				
				return command.kid+" is "+ (command.answer.getAnswer() ? "" : "not ") + "in the IntList";
			}

			@Override
			public String toFailureString() {
				
				return "Check was a failure. No check was performed.";
			}
			
		};
	}

}
