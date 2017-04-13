package hehexd.datastructure;

/**
 * Line of Command with the commands: "add" , "save", "clear", "ragequit" and "check" xD lol
 * [Singleton]
 *  
 * @author Only Brad
 *
 */
public class BasicLineOfCommandFactory extends LineOfCommandFactory {
	
	private static BasicLineOfCommandFactory instance; // SINGLETON
	private IntList intList; // THE INT LIST

	private BasicLineOfCommandFactory(IntList intList) {
		
		this.intList = intList;
	}
	
	/**
	 * Create a LineOfCommand, too lazy to explain all the details, it should be obvious with the name
	 * of the methods.
	 */
	@Override
	public LineOfCommand create() {
		
		return new LineOfCommandBuilder()
				.addCommand("add", new AddCommand(intList))
				.addCommand("clear", new ClearCommand(intList))
				.addCommand("ragequit", new RagequitCommand())
				.addCommand("check", new CheckCommand(intList))
				.addDecoration("[IntList Request]: ")
				.addMessageError("***ERROR*** ")
				.addMessageSuccess("[IntList Answer]: ")
				.get();
	}
	
	/**
	 * getter of the factory, not thread safe. But who cares right ?
	 * 
	 * @param intList ZZzzZz
	 * @return The fucking LineOfCommand
	 */
	public static LineOfCommandFactory getInstance(IntList intList) {
		
		if( instance == null || !intList.equals(instance.intList) )
	
			instance = new BasicLineOfCommandFactory(intList);

		return instance;
	
	}

}
