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
	
	private final static IntListSaver instance = new IntListSaver();
	private File intListFile;
	
	private IntListSaver()  {
		
		String fileName = Config.getInstance().getFileName();
		this.intListFile = new File(fileName);
		
	}
	
	public static IntListSaver getInstance() {
		
		return instance;
	}
	
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

