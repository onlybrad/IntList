package hehexd.api;

import hehexd.datastructure.*;

/**
 * Use this shit to manage input and output of the Commands objects.
 * A command might generate an answer, if it does, you need to give it a pointer
 * to an Answer object. CommandManager will let you directly get the value of the answer.
 * 
 * @author Only Brad
 *
 */
public class CommandManager {

	private Command nex‚”Command; // The next command.
	private Answer<?> oldAnswer; // Buffer for old answer
	private Answer<?> nextAnswer; // The next answer of a command
	private boolean hasBeenAnswered; // Did the last command give an answer?
	
	/**
	 * By setting a new Command, the old Answer is rendered void and a reference to
	 * it is stored in the OldAnswer attribute. The hasBeenAnswered boolean is set to false
	 * because the new Command hasn't been answered yet. The Answer of the previous Command 
	 * is still reachable within the oldAnswer attribute.
	 * 
	 * To prevent problems (creating new Answer objects for no reason for example) you cannot set
	 * a null pointer as a new command. To remove a Command use the CommandManager::removeCommand 
	 * method instead.
	 * 
	 * @param command The command to execute
	 * @param T the type of return of the next Answer
	 */
	public <T> void setCommand(Command command) {
		
		if(command == null)
			
			throw new IllegalArgumentException("Cannot use Null Pointer in the CommandManager::setCommand method, use"
					+ "CommandManager::removeCommand instead");

		this.nex‚”Command = command;
		this.oldAnswer = this.nextAnswer;
		this.nextAnswer = new Answer<>();		
		this.hasBeenAnswered = false; //a new command means the old answer is no longer needed
	}
	
	/**
	 * removes the last Command
	 */
	public void removeCommand() {
		
		this.nex‚”Command = null;
		this.oldAnswer = this.nextAnswer;
		this.nextAnswer = null;
	}
	
	public boolean apply(String[] t) {
		
		if(this.nex‚”Command == null)
			
			return (this.hasBeenAnswered = false);
		
		this.hasBeenAnswered = this.nex‚”Command.apply(t);
			
			return hasBeenAnswered;
		
	}
	
	/**
	 * Usage: Use only after a CommandManager::setCommand and an CommandManager::apply. 
	 * Will always return null if there are no reference to a Command 
	 * because each Command are associated with an Answer. 
	 * Use CommandManager::getOldAnswer to return an older answer.
	 * 
	 * @return the last answer, otherwise return null;
	 */
	@SuppressWarnings("unchecked")
	public <T> T getAnswer() {
		
		return this.hasBeenAnswered ? (T)this.nextAnswer.getAnswer() : null;
		
	}
	
	/**
	 * 
	 * @return the answer before the new one, if none then return null;
	 */
	@SuppressWarnings("unchecked")
	public <T> T getOldAnswer() {
		
		return this.oldAnswer!=null ? (T)this.oldAnswer.getAnswer() : null;
	}
	
}
