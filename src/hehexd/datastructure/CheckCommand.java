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
		// TODO Auto-generated constructor stub
	}

	public CheckCommand(IntList intList) {
		super(intList);
	}

	@Override
	public Boolean apply(String[] kid) {
		
		if( kid.length == 1) {
			
			this.kid = kid[0];
			boolean isInIntList = this.intList.isInIntList(this.kid);
			this.answer.setAnswer(isInIntList);
			return true;
		}
			
		return false;
	}

	@Override
	public String toString() {
		
		return this.kid+" is "+ (this.answer.getAnswer() ? "" : "not ") + "in the IntList";
	}

}
