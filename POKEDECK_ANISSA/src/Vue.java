import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Vue {
	public JFrame window = new JFrame("Pokedeck");
	public static JPanel panel1 = new JPanel();
	public static JPanel panel2 = new JPanel();
	public static JPanel panel3 = new JPanel();
	public static JPanel panel4 = new JPanel();

	public void index(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		window.setSize(screenSize.width, screenSize.height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		
		// header buttons
		
		window.setLayout(new FlowLayout());
		JButton b1 = new JButton("See cards");
		window.add(b1);

		JButton b2 = new JButton("Delete a card");
		window.add(b2);

		JButton b3 = new JButton("Add a new card");
		window.add(b3);

		JButton b4 = new JButton("Modify a card");
		window.add(b4);
		
		// panel depending to each button
		panel1.setLayout(new BoxLayout(panel1, 0));
		panel1.add(new JLabel(""));
		window.add(panel1);
		
		panel2.setLayout(new BoxLayout(panel2, 0));
		panel2.add(new JLabel(""));
		window.add(panel2);
		
		panel3.setLayout(new BoxLayout(panel3, 0));
		panel3.add(new JLabel(""));
		window.add(panel3);
		
		panel4.setLayout(new BoxLayout(panel4, 0));
		panel4.add(new JLabel(""));
		window.add(panel4);
		
		// hide or show panels
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	window.remove(panel2);
            	window.remove(panel3);
            	window.remove(panel4);
            	panel1.removeAll();
            	Player.seeCards();
            	window.add(panel1);
            	window.revalidate();
            	window.repaint();
            }
        });
        
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	window.remove(panel1);
            	window.remove(panel3);
            	window.remove(panel4);
            	panel2.removeAll();
            	Player.deleteCards();
            	window.add(panel2);
            	window.revalidate();
            	window.repaint();
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	window.remove(panel1);
            	window.remove(panel2);
            	window.remove(panel4);
            	panel3.removeAll();
            	Player.addCard();
            	window.add(panel3);
            	window.revalidate();
            	window.repaint();
            }
        });
        
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	window.remove(panel1);
            	window.remove(panel2);
            	window.remove(panel3);
            	Player.modifyCards();
            	window.add(panel4);
            	window.revalidate();
            	window.repaint();
            }
        });
        
        window.remove(panel2);
    	window.remove(panel3);
    	window.remove(panel4);
	    createMenus();
	    Player.seeCards();
	    window.setVisible(true);
	}
	
	public void createMenus(){
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menu = new JMenu("File");
        JMenuItem submenu1 = new JMenuItem("Save");
        JMenuItem submenu2 = new JMenuItem("Exit");
        submenu1.addActionListener(new EventMenu());
        submenu2.addActionListener(new EventMenu());
        menu.add(submenu1);
        menu.add(submenu2);
        menuBar.add(menu);
        window.add(menuBar);
        window.setJMenuBar(menuBar);
	}
}