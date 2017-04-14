package hehexd.ioclasses;

import java.io.*;

import hehexd.config.Config;
import hehexd.datastructure.IntList;

/**
 * The class that loads the IntList using ObjectStream.
 * [Singleton]
 * 
 * @author Only Brad
 *
 */
public class IntListLoader {
	
	private final static IntListLoader instance = new IntListLoader(); // IT'S A SINGLETON
	private File intListFile; // The file were we gonna save the int list
	private IntList intList; // The IntList as an object in memory
	
	private IntListLoader()  {
		
		String fileName = Config.getInstance().FILE_NAME;
		this.intListFile = new File(fileName);
		
		/* If the file doesn't exit, simply create a new IntList without 
		 * loading from disk, then save it on disk for future usage. */
		if(!intListFile.exists())
			
			try {
				this.intListFile.createNewFile();
				IntListSaver.getInstance().save(this.intList = new IntList());
			} catch (IOException e) {}	
		
		/* Otherwise load it from the disk */
		else
			
			this.load();
		
	}
	
	public static IntListLoader getInstance() {
		
		return instance;
	}
	
	/**
	 * Load the intlist in memory if it exists already. This is usually self-called by IntListLoader
	 * during its static creation
	 * 
	 */
	public void load() {
		
		try {
			FileInputStream inputStream = new FileInputStream(this.intListFile);
			ObjectInputStream objectStream = new ObjectInputStream(inputStream);
			this.intList = (IntList) objectStream.readObject();
			objectStream.close();
		}
		catch(IOException e1) {
			
			System.err.println("Where the fuck is the IntList serialized file??? idiot.");
		}
		catch(ClassNotFoundException e2) {
			
			System.err.println("Who was dumb enough to remove the most important class? The fucking IntList class");
		}

	}
	
	public IntList getIntList() {
		
		return this.intList;
	}
}
