package main;

import hehexd.datastructure.IntList;
import hehexd.gui.AppFrame;
import hehexd.gui.listeners.GuiController;
import hehexd.ioclasses.IntListLoader;

/**
 * THE GUI VERSION of the main. STILL UNDER DEVELOPMENT.
 * 
 * @author Only Brad
 *
 */
public class IntListAppGUI {

	public static void main(String[] args) {
		
		IntList intList = IntListLoader.getInstance().getIntList();
		AppFrame frame = new AppFrame();
		GuiController controller = new GuiController(intList, frame);
		controller.start();
		frame.setVisible(true);

	}

}
