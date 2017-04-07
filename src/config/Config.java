package config;

/**
 * 
 * The name of the serialized int list file is in this class.
 * Maybe other crap can be put here in the future xD lol
 * [Singleton]
 * 
 * @author Only Brad
 *
 */
public class Config {

	private static final String FILE_NAME = "IntList.ser";
	private static final Config instance = new Config();
		
	private Config() {}
	
	public static Config getInstance() {
		
		return instance;
	}
	
	public String getFileName() {
		
		return FILE_NAME;
	}
}
