package hehexd.config;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
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

	public final String FILE_NAME;
	public final String LOOK_AND_FEEL;
	public final String FONT_PATH;
	public final String BigBrother;
	public final String INPUT;
	public final String OUTPUT;
	public final Dimension FRAME_SIZE;
	public final Color PANEL_COLOR;
	public final Color BORDER_COLOR;
	public final SimpleDateFormat dateFormat;
	
	private Config() {
		
		this.FILE_NAME = Paths.get(new File("").getAbsolutePath(),"IntList.ser").toString();
		this.FONT_PATH = Paths.get(new File("").getAbsolutePath(),"font").toString();
		this.BigBrother = Paths.get(new File("").getAbsolutePath(),"ico","BigBrother.png").toString();
		this.LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		this.INPUT = "North";
		this.OUTPUT = "Center";
		this.FRAME_SIZE = new Dimension(1024,768);
		this.PANEL_COLOR = new Color(129, 216, 208);
		this.BORDER_COLOR = new Color(0, 147, 175);
		this.dateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss"); 
	}
	
	public static Config getInstance() {
		
		return instance;
	}
	
}
