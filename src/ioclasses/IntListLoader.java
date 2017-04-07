package ioclasses;

import java.io.*;

import config.Config;
import datastructure.IntList;

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
		
		String fileName = Config.getInstance().getFileName();
		this.intListFile = new File(fileName);
			
	}
	
	public static IntListLoader getInstance() {
		
		return instance;
	}
	
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
