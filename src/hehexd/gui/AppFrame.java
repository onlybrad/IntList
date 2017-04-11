package hehexd.gui;

import hehexd.config.Config;
import hehexd.gui.menu.IntListMenuBar;
import hehexd.ioclasses.IntListLoader;

import java.awt.*;
import java.io.File;
import javax.swing.*;

/**
 * 
 * The GUI Frame of the Int List
 * 
 * @author Only Brad
 *
 */
public class AppFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5960723579614708105L;
	private JTabbedPane tabbedPane;
	private CommandPanel commandPanel;
	private IntListTable intListTable;
	
	/**
	 * The construction of the IntList Frame, the primary GUI interface 
	 * (yes I used Interface twice, shut the fuck up).
	 */
	public AppFrame() {
		
		super("IntList");
	
		/* Set a specific look and feel */
		this.lookAndFeel();
		/* Add Icon to the frame */
		this.BigBrother();
		
		this.getContentPane().setBackground(Config.getInstance().PANEL_COLOR);
		this.addPanels();
		this.setJMenuBar(new IntListMenuBar());
		this.setSize(Config.getInstance().FRAME_SIZE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* Highlight the components */
		//highlightComponents((JComponent) this.getContentPane());
	
	}
	
	/**
	 * Add all the panels in the frame by using a JTabbedPane
	 */
	private void addPanels() {
		
		/* The primary pane in the frame that will contain all the panels of the program */

		this.tabbedPane = new JTabbedPane();
		
		this.tabbedPane.add("Command Tab", this.commandPanel = new CommandPanel());
		this.tabbedPane.add("Int List", new JScrollPane(this.intListTable = new IntListTable(IntListLoader.getInstance().getIntList()),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
		this.setContentPane(this.tabbedPane);	
	}
	
	/**
	 * Add the "BigBrother" twitch emote as icon
	 */
	private void BigBrother() {
		
		String currentDir = new File("").getAbsolutePath();
		ImageIcon image = new ImageIcon(currentDir+"/"+Config.getInstance().BigBrother);
		this.setIconImage(image.getImage());
		
	}
	
	/**
	 * Set the look and feel to the one designated in the Config object
	 */
	private void lookAndFeel() {
		
		try {
			UIManager.setLookAndFeel(Config.getInstance().LOOK_AND_FEEL);
			SwingUtilities.updateComponentTreeUI(this);
		} 
		
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) 
		 {
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} 
			catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {}

		 }
		
	}

	/**
	 * 
	 * @return the buttons in the input panel
	 */
	public JButton[] getButtons() {
		
		return this.commandPanel.getButtons();
	}
	
	/**
	 * 
	 * @return the name textfield in the input panel
	 */
	public JTextField getTextName() {
		
		return this.commandPanel.getTextName();
	}
	
	/**
	 * 
	 * @return the reason textfield in the input panel
	 */
	public JTextField getTextReason() {
		
		return this.commandPanel.getTextReason();
	}
	
	/**
	 * 
	 * @return the log textarea in the output panel
	 */
	public JTextPane getOutput() {
		
		return this.commandPanel.getTextArea();
	}
	
	/**
	 * 
	 * @return the tabbed pane of the frame app
	 */
	public JTabbedPane getTabbedPane() {
		
		return this.tabbedPane;
	}
	
	/**
	 * @return the IntList table
	 */
	public IntListTable getIntListTable() {
		
		return this.intListTable;
	}
	
	/**
	 * Recursive function used to highlight all the components with a black border. Useful to 
	 * visually see how the components are placed inside the frame.
	 * 
	 * @param jComponent the component whose children are going to be highlighted (black border)
	 */
	@SuppressWarnings("unused")
	private static void highlightComponents(JComponent jComponent) {
		
		for(Component component : jComponent.getComponents()) {
			
			if(component instanceof JComponent)
				
				highlightComponents((JComponent) component);
			
			((JComponent) component).setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
	

}
