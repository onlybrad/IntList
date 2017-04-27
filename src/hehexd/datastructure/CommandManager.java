package hehexd.datastructure;

import java.util.Observable;

import hehexd.datastructure.*;

/**
 * Use this shit to manage input and output of the Command objects.
 * A command might generate an answer, if it does, you need to give it a pointer
 * to an Answer object. CommandManager will let you directly get the value of the answer.
 * 
 * @author Only Brad
 */
public class CommandManager extends Observable {
	
	private Command nextCommand; // The next command.
	private Answer<?> oldAnswer; // Buffer for old answer
	private Answer<?> nextAnswer; // The next answer of a command
	private boolean hasBeenAnswered; // Did the last command give an answer?
	
	/**
	 *<pre> By setting a new Command, the old Answer is rendered void and a reference to
	 * it is stored in the OldAnswer attribute. The hasBeenAnswered boolean is set to false
	 * because the new Command hasn't been answered yet. The Answer of the previous Command 
	 * is still reachable within the oldAnswer attribute.
	 * 
	 * To prevent problems (creating new Answer objects for no reason for example) you cannot set
	 * a null pointer as a new command. To remove a Command use the CommandManager::removeCommand 
	 * method instead.
	 * 
	 * Whenever a change occurs, the observer are notified:
	 * an Array of Object is sent as argument: 
	 * The first object is the class of the Command
	 * The second argument is an array of String containing the arguments that were passed to the command</pre>
	 * 
	 * @param command The command to execute
	 * @param <T> the type of return of the Answer of the Command
	 */
	public <T> void setCommand(Command command) {
		
		if(command == null)
			
			throw new IllegalArgumentException("Cannot use Null Pointer in the CommandManager::setCommand method, use"
					+ "CommandManager::removeCommand instead");

		this.nextCommand = command;
		this.oldAnswer = this.nextAnswer;
		this.nextAnswer = null;		
		this.hasBeenAnswered = false; //a new command means the old answer is no longer needed
	}
	
	/**
	 * removes the last Command
	 */
	public void removeCommand() {
		
		this.nextCommand = null;
		this.oldAnswer = this.nextAnswer;
		this.nextAnswer = null;
	}
	
	/**
	 * Will apply the commmand. If the Command is an AnswerableCommand, the value
	 * will be stored in the Answer object.
	 * 
	 * @param t the list of arguments
	 * @return if the Command has been executed correctly
	 */
	public boolean apply(String[] t) {
		
		if(this.nextCommand == null)
			
			return (this.hasBeenAnswered = false);
		
		if(this.hasBeenAnswered = this.nextCommand.apply(t))
		
			this.setChanged();
			
		this.notifyObservers(new Object[]{this.nextCommand.getClass(),t});
		return hasBeenAnswered;
	}
	
	/**
	 * Usage: 
	 * 
	 * Use only after a CommandManager::setCommand and an CommandManager::apply. 
	 * Will always return null if: 
	 * 
	 * 1) there are no reference to a Command, because each Command are associated with an Answer.  
	 * 2) if the Command object isn't an AnswerableObject
	 * 
	 * Use CommandManager::getOldAnswer to return an older answer.
	 * 
	 * @param <T> the type of the Answer of the Command
	 * @return the last answer, otherwise return null;
	 */
	@SuppressWarnings("unchecked")
	public <T> T getAnswer() {

		try{
			this.nextAnswer = ((Answerable)this.nextCommand).getAnswer();
			return (T) this.nextAnswer.getAnswer();
		}
		catch(ClassCastException e) {
			
			/* returns null if the Object isn't Answerable, shouldn't happen if you know
			 * what the fuck you are doing. */
			return (T) (this.nextAnswer = null);
		}
	}
	
	/**
	 * 
	 * @param <T> The type of the Answer of the Command
	 * @return the answer before the last one, if none then return null;
	 */
	@SuppressWarnings("unchecked")
	public <T> T getOldAnswer() {
		
		return this.oldAnswer!=null ? (T)this.oldAnswer.getAnswer() : null;
	}
	
}
