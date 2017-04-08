package hehexd.config;

import java.awt.Color;
import java.awt.Dimension;

import hehexd.config.Config;

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
	
	private final static Config instance = new Config();
	
	private final String FILE_NAME = "IntList.ser";
	public final String INPUT = "North";
	public final String OUTPUT = "Center";
	public final Dimension FRAME_SIZE = new Dimension(1024,768);
	public final Color PANEL_COLOR = new Color(129, 216, 208);
	
	
	private Config() {}
	
	public static Config getInstance() {
		
		return instance;
	}
	
	public String getFileName() {
		
		return this.FILE_NAME;
	}
	
}
