package hehexd.gui;

import java.awt.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.*;
import hehexd.config.Config;

/**
 * A JTextPane that uses a FormattedStyleDocument with a monospace font
 * 
 * @author Only Brad
 *
 */
class FormattedJTextPane extends JTextPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7772768786831059031L;
	
	FormattedJTextPane() {
		
		super(new FormattedStyleDocument());
		this.setFont(this.createFont());
	}
	
	private Font createFont(){
		String path = Paths.get(Config.getInstance().FONT_PATH,"AnonymousPro-Regular.ttf").toString();
		
	    try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
		    return font.deriveFont(Font.PLAIN,15);
			
		} catch (FontFormatException | IOException e) {
			return null;
		}
	    
	    
		
	}
}
