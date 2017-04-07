package datastructure;

/**
 * Line of Command with the commands: "add" , "save", "clear" and "ragequit" xD lol
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
				.addCommand("save", new SaveCommand(intList))
				.addCommand("clear", new ClearCommand(intList))
				.addCommand("ragequit", new RagequitCommand())
				.addCommand("check", new CheckCommand(intList))
				.addDecoration("[IntList Request]: ")
				.addMessageError("Dafuk are you smoking? ")
				.addMessageSuccess("[IntList Answer]: ")
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
