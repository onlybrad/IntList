package hehexd.datastructure;

/**
 * 
 * Class that encapsulates a Command Answer. I used by certain Commands with the purpose of returning
 * a value that can be used later (for example, in a GUI)
 * 
 * @author Only Brad
 *
 * @param <T>
 */
public class Answer<T> {
	
	private T answer;
	
	public Answer(T answer) {
		
		this.answer = answer;
	}
	
	/**
	 * Empty constructor, use that if you want the Command answer to add an answer inside this structure
	 */
	public Answer() {}
	
	public void setAnswer(T answer) {
		
		this.answer = answer;
	}
	
	public T getAnswer() {
		
		return this.answer;
	}
}
