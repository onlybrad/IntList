package hehexd.datastructure;

/**
 * An object that can return an Answer object.
 * 
 * @author Only Brad
 *
 */
public interface Answerable {
	
	/**
	 * 
	 * @return The Answer
	 */
	abstract <T extends Object> Answer<? super T> getAnswer();
}
