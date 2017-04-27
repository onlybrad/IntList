package hehexd.gui.listeners;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JTabbedPane;

/**
 * A listener that lets you Drag a tab in a JTabbedPane, 
 * Source: http://stackoverflow.com/questions/29288371/how-to-create-movable-draggable-tabbed-panes-i-e
 * Modified in order to be an independent class from the JTabbedPane
 * 
 * @author Prasaanth Neelakandan
 *
 */
class TabMouseAdapter extends MouseAdapter {
	
    Point initialPoint;
    double initialY, targetY;
    Component current;
    String title;

    public void mousePressed(MouseEvent e) {
        
    	JTabbedPane pane = (JTabbedPane) e.getSource();
    	initialPoint = e.getPoint();
        initialY=initialPoint.getY();

        for (int i = 0; i < pane.getTabCount(); i++) {
            Rectangle bounds = pane.getBoundsAt(i);
            if (bounds.contains(initialPoint)) {
                current = pane.getComponentAt(i);   
                title = pane.getTitleAt(i);
            }
        }

    };

    public void mouseDragged(MouseEvent e) {
        
    	JTabbedPane pane = (JTabbedPane) e.getSource();
    	Point targetPoint = e.getPoint();
        targetY=targetPoint.getY();

        if (current != null) {

            // check for a significant horizontal drag
            if(Math.abs(targetY-initialY)< 40 && targetPoint.distance(initialPoint)>5){
                int targetIndex = pane.getUI().tabForCoordinate(pane,
                        e.getX(), e.getY());
                // target index should be valid and also not be same as original tab's index
                if(targetIndex!=-1 && targetIndex!=pane.getSelectedIndex()){         
                	pane.remove(current);
                	pane.insertTab(title, null, current, null, targetIndex);
                	pane.setSelectedIndex(targetIndex);
                }
            }
        } 

    }

    public void mouseReleased(MouseEvent arg0) {
        current=null;
        title =null;
    }
}