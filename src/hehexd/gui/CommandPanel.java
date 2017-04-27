package hehexd.gui;

import java.awt.BorderLayout;

import javax.swing.*;
import hehexd.config.Config;
import hehexd.randomcrap.CommandConstants;

/**
 * The Command panels where you add/remove/check a kid from/to the IntList.
 * It's a container for the InputArea and the OutputArea
 * 
 * @author Only Brad
 *
 */
class CommandPanel extends JPanel implements CommandConstants {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4786121327210400042L;
	
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
