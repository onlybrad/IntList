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
	 * @param <T> The type of the Answer
	 * @return The Answer object
	 */
	abstract <T> Answer<T> getAnswer();
}
