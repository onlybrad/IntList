package main;

import hehexd.datastructure.IntList;
import hehexd.gui.IntListFrame;
import hehexd.gui.listeners.GuiControler;
import hehexd.ioclasses.IntListLoader;

/**
 * THE GUI VERSION of the main. STILL UNDER DEVELOPMENT.
 * 
 * @author Only Brad
 *
 */
public class IntListGUI {

	public static void main(String[] args) {
		
		IntList intList = IntListLoader.getInstance().getIntList();
		IntListFrame frame = new IntListFrame();
		GuiControler controler = new GuiControler(intList, frame);
		
		frame.setVisible(true);

	}

}
