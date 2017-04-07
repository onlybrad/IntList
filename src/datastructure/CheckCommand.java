package datastructure;

public class CheckCommand extends Command {
	
	public boolean isInIntList; // Is he in the int list ?
	private String kid; // the fucking kid
	private IntList intList; // the int list
	private Answer<Boolean> answer;
	
	public CheckCommand(IntList intList, Answer<Boolean> answer) {
		
		this.intList = intList;
		this.answer = answer;
	}
	
	public CheckCommand(IntList intList) {
		
		this(intList,new Answer<Boolean>());
	}

	@Override
	public Boolean apply(String[] kid) {
		
		if( kid.length == 1) {
			
			this.kid = kid[0];
			this.isInIntList = this.intList.isInIntList(this.kid);
			this.answer.setAnswer(this.isInIntList);
			return true;
		}
			
		return false;
	}

	@Override
	public String toString() {
		
		return this.kid+" is "+ (this.isInIntList ? "" : "not ") + "in the IntList";
	}

}
