package hehexd.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
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
	public final static int LIST_BUTTON = 4; // index of the list button
	
	private final InputArea inputArea;
	private final OutputArea outputArea;

	CommandPanel() {
		
		this.inputArea = new InputArea();
		this.outputArea = new OutputArea();
		this.setBackground(Config.getInstance().PANEL_COLOR);
		//this.inputArea.setBorder(new EmptyBorder(25, 0, 0, 0));
		this.setLayout(new BorderLayout());
		
		this.addPanels();
	}
	
	/**
	 * Add the input/output panels in the CommandPanel
	 * The input and output are separated by a  vertical JSplitPane
	 */
	private void addPanels() {
		
		JSplitPane verticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,
				this.inputArea,
				this.outputArea);
		
		this.add(verticalSplitPane,BorderLayout.CENTER);

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
