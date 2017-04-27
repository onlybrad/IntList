package hehexd.gui.listeners;

import javax.swing.*;
import javax.swing.JTextField;
import hehexd.datastructure.*;
import hehexd.gui.*;
import java.awt.event.*;
import static hehexd.randomcrap.CommandConstants.*;


/**
 * Class that links the GUI to all the ActionListeners. The start method of this class should be called
 * to add all the functionalities to the buttons and other components of the AppFrame object.
 * Contains a pointer to a global CommandManager object
 * [Singleton]
 * 
 * @author Only Brad
 *
 */
public class GuiController {
	
	/* use this with the actionlistener of the hehexd.gui.listeners package */
	public final CommandManager commandManager;
	private static GuiController instance;
	private final IntList intList; // THE FUCKING INTLIST
	private final AppFrame frame; // The frame
	
	/**
	 * 
	 * @param intList The IntList
	 * @param frame The GUI frame object
	 */
	private GuiController(IntList intList,AppFrame frame) {
		
		this.commandManager = new CommandManager();
		this.intList = intList;
		this.frame = frame;
	}
	
	/**
	 * Create a new GuiController with specific IntList and AppFrame object
	 * 
	 * @param intList The IntList
	 * @param frame The Program frame
	 * @return
	 */
	public static GuiController newInstance(IntList intList, AppFrame frame) {
		
		if(instance == null)
			
			instance = new GuiController(intList,frame);
		
		return instance;
	}
	
	/**
	 * Is used to return the GuiController that was already created. If it's not created,
	 * a GuiController is created using null parameters.
	 * 
	 * @return
	 */
	public static GuiController getInstance() {
		
		return newInstance(null,null);
	}
	
	public void start() {
		
		JTextField name = frame.getTextName();
		JTextField reason = frame.getTextReason();
		JTextPane output = frame.getOutput();
		JButton[] buttons = this.frame.getButtons();
		
		/* add the AddButtonListener to the "add" button */
		buttons[ADD_BUTTON].addActionListener(new AddButtonListener(name, reason, output, intList));
		
		/* add the RemoveButtonListener to the "remove" button */
		buttons[REMOVE_BUTTON].addActionListener(new RemoveButtonListener(name,output,intList));
		
		/* add the ClearButtonListener to the "clear" button */
		buttons[CLEAR_BUTTON].addActionListener(new ClearButtonListener(output, intList));
		
		/* add the CheckButtonlistener to the "check" button */
		buttons[CHECK_BUTTON].addActionListener(new CheckButtonListener(name, output, intList));
			
		/* add The TabListener to the tabs of the JTabbedPane in the frame, this will
		 * allow changing the tab position */
		MouseAdapter listener = new TabMouseAdapter();
		this.frame.getTabbedPane().addMouseListener(listener);
		this.frame.getTabbedPane().addMouseMotionListener(listener);
		
		/* add the TableMouseListener to the IntListTable */
		this.frame.getIntListTable().addMouseListener(new TableMouseListener());
		
		/* attach IntListTable to the CommandManager */
		commandManager.addObserver(this.frame.getIntListTable());
	}
	
	IntList getIntList() {
		
		return this.intList;
	}

}
