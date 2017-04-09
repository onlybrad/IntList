package hehexd.ioclasses;

import java.io.*;

import hehexd.config.Config;
import hehexd.datastructure.IntList;

/**
 * The class that saves the IntList using ObjectStream.
 * [Singleton]
 * 
 * @author Only Brad
 *
 */
public class IntListSaver {
	
	private final static IntListSaver instance = new IntListSaver(); // The instance
	private File intListFile; // The Int List file
	
	private IntListSaver()  {
		
		String fileName = Config.getInstance().getFileName(); // File name
		this.intListFile = new File(fileName); // The file object of the Int List file
		
	}
	
	/**
	 * HELLO ? SINGLETON... GEEZ
	 * 
	 * @return
	 */
	public static IntListSaver getInstance() {
		
		return instance;
	}
	
	/**
	 * call this and the intlist will be on your disk
	 * 
	 * @param intList
	 */
	public void save(IntList intList) {
		
		try {
			FileOutputStream outputStream = new FileOutputStream(this.intListFile);
			ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);
			objectStream.writeObject(intList);
			objectStream.close();
		}
		catch(IOException e) {
			
			System.err.println("Where the fuck is the IntList serialized file??? idiot.");
		}

	}
	
}

