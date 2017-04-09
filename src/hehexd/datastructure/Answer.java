package hehexd.datastructure;

/**
 * 
 * Class that encapsulates a Command Answer. I used by certain Commands with the purpose of returning
 * a value that can be used later (for example, in a GUI)
 * 
 * @author Only Brad
 *
 * @param <T> the type of return
 */
public class Answer<T extends Object> {
	
	private T answer;
	
	public Answer(T answer) {
		
		this.answer = answer;
	}
	
	public Answer() {}
	
	public void setAnswer(T isInIntList) {
		
		this.answer = isInIntList;
	}
	
	public T getAnswer() {
		
		return this.answer;
	}



}
