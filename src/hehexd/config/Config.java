package hehexd.config;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import hehexd.config.Config;


/**
 * 
 * Config file, might be separated in multiple classes in the future. 
 * Might add a way to change the settings in the future.
 * current settings can be considered "Default" settings.
 * 
 * Maybe other crap can be put here in the future xD lol
 * [Singleton]
 * 
 * @author Only Brad
 *
 */
public class Config {
	
	private final static Config instance = new Config();

	public final String FILE_NAME; // The IntList serialized file.
	public final String LOOK_AND_FEEL; // The look and feel of the frame
	public final String FONT_PATH; // Path of the font file
	public final String BigBrother; // The icon of the program
	public final Dimension FRAME_SIZE; // Initial size of the program
	public final Color PANEL_COLOR; // Background color used by certain JPanels
	public final Color BORDER_COLOR; // The border color of certain JPanels
	public final Color ALTERNATIVE_CELL_COLOR; // Color used when alternating colors in a list
	public final SimpleDateFormat dateFormat; // The date format used
	
	private Config() {
		
		this.FILE_NAME = Paths.get(new File("").getAbsolutePath(),"IntList.ser").toString();
		this.FONT_PATH = Paths.get(new File("").getAbsolutePath(),"font").toString();
		this.BigBrother = Paths.get(new File("").getAbsolutePath(),"ico","BigBrother.png").toString();
		this.LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		this.FRAME_SIZE = new Dimension(1024,768);
		this.PANEL_COLOR = new Color(129, 216, 208);
		this.BORDER_COLOR = new Color(0, 147, 175);
		this.ALTERNATIVE_CELL_COLOR = Color.LIGHT_GRAY;
		this.dateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss"); 
	}
	
	public static Config getInstance() {
		
		return instance;
	}
	
}
