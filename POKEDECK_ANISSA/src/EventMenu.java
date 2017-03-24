import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class EventMenu implements ActionListener {
	/**
	 * Menu events
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedItem = ((JMenuItem) e.getSource()).getText();
		
		if(selectedItem == "Save"){
			Player.writeInFile();
		}
		else if(selectedItem == "Exit"){
			System.exit(0);
		}

	}

}

