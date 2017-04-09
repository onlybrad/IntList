package hehexd.datastructure;

/**
 * The Answerable version of the Command, this type of Commands returns a fucking Answer
 * IMPORTANT: the apply() methods that must be overriden is the one responsible for
 * putting the answer (or delegated to another object) in the Answer object.
 * 
 * @author Only Brad
 *
 */
public abstract class AnswerableCommand<T> extends Command implements Answerable {

	protected Answer<T> answer;
	
	public AnswerableCommand() {
		
		this.answer = new Answer<>();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Answer<T> getAnswer() {
		
		return this.answer;
	}
	
}
