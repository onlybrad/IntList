package datastructure;

/**
 * Line of Command with the commands: "add" , "save" and "ragequit" xD lol
 * 
 * @author Only Brad
 *
 */
public class BasicLineOfCommandFactory extends LineOfCommandFactory {
	
	private static BasicLineOfCommandFactory instance;
	private IntList intList;

	private BasicLineOfCommandFactory(IntList intList) {
		
		this.intList = intList;
	}
	
	@Override
	public LineOfCommand create() {
		
		return new LineOfCommandBuilder()
				.addCommand("add", new AddCommand(intList))
				.addCommand("save", new SaveCommand(intList))
				.addCommand("ragequit", new RagequitCommand())
				.get();
	}
	
	/**
	 * getter of the factory, not thread safe. But who cares right ?
	 * 
	 * @param intList ZZzzZz
	 * @return
	 */
	public static LineOfCommandFactory getInstance(IntList intList) {
		
		if( instance == null || !intList.equals(instance.intList) )
	
			instance = new BasicLineOfCommandFactory(intList);

		return instance;
	
	}

}
