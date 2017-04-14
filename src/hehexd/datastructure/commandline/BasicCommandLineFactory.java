package hehexd.datastructure.commandline;

import hehexd.datastructure.AddCommand;
import hehexd.datastructure.CheckCommand;
import hehexd.datastructure.ClearCommand;
import hehexd.datastructure.IntList;
import hehexd.datastructure.ListCommand;
import hehexd.datastructure.RagequitCommand;
import hehexd.datastructure.RemoveCommand;

/**
 * Line of Command with the commands: "add" , "save", "clear", "ragequit" and "check" xD lol
 * [Singleton]
 *  
 * @author Only Brad
 *
 */
public class BasicCommandLineFactory extends CommandLineFactory {
	
	private static BasicCommandLineFactory instance; // SINGLETON
	private IntList intList; // THE INT LIST

	private BasicCommandLineFactory(IntList intList) {
		
		this.intList = intList;
	}
	
	/**
	 * Create a LineOfCommand, too lazy to explain all the details, it should be obvious with the name
	 * of the methods.
	 */
	@Override
	public CommandLine create() {
		
		return new CommandLineBuilder()
				.addCommand(new AddCommand(intList),"add","A","a","put")
				.addCommand(new ClearCommand(intList),"clear","wipe","c","w","C","W")
				.addCommand(new RagequitCommand(),"ragequit","rq","RQ","q","Q" )
				.addCommand(new CheckCommand(intList),"check","lookup","chk","CHK")
				.addCommand(new RemoveCommand(intList),"remove","r","R","delete","d","D")
				.addCommand(new ListCommand(intList),"list","ls","l","LS","L")
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
	public static CommandLineFactory getInstance(IntList intList) {
		
		if( instance == null || !intList.equals(instance.intList) )
	
			instance = new BasicCommandLineFactory(intList);

		return instance;
	
	}

}
