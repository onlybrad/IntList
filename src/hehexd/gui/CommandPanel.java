package hehexd.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import hehexd.config.Config;

/**
 * The Command panels where you add/remove/check a kid from/to the IntList.
 * It's a container for the InputArea and the OutputArea
 * 
 * @author Only Brad
 *
 */
public class CommandPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4786121327210400042L;
	public final static int ADD_BUTTON = 0; // index of the add button
	public final static int CHECK_BUTTON = 1; // index of the check button
	public final static int REMOVE_BUTTON = 2; // index of the remove button
	public final static int CLEAR_BUTTON = 3; // index of the clear button
	
	private final InputArea inputArea;
	private final OutputArea outputArea;

	CommandPanel() {
		
		this.inputArea = new InputArea();
		this.outputArea = new OutputArea();
		this.setBackground(Config.getInstance().PANEL_COLOR);
		this.setLayout(new BorderLayout(25,25));
		this.inputArea.setBorder(new EmptyBorder(25, 0, 0, 0));
		
		this.addPanels();
	}
	
	/**
	 * Add the input/output panels in the CommandPanel
	 */
	private void addPanels() {
		
		this.add(this.inputArea,Config.getInstance().INPUT);
		this.add(this.outputArea, Config.getInstance().OUTPUT);

	}
	
	/**
	 * 
	 * @return the buttons in the input panel
	 */
	public JButton[] getButtons() {
		
		return this.inputArea.getButtons();
	}

	/**
	 * 
	 * @return the name textfield in the input panel
	 */
	public JTextField getTextName() {
		
		return this.inputArea.getTextName();
	}
	
	/**
	 * 
	 * @return the reason textfield in the input panel
	 */
	public JTextField getTextReason() {
		
		return this.inputArea.getTextReason();
	}

	/**
	 * 
	 * @return the log textarea in the output panel
	 */
	public JTextPane getTextArea() {
		
		return this.outputArea.getTextArea();
	}
	
	
}
