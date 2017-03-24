import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Player {
	static ArrayList<Card> listCards = new ArrayList<Card>();
	
	public static void addCard(){
		
		final JTextField textField1 = new JTextField("Name", 10);
		final JTextField textField2 = new JTextField("HP", 10);
		final JTextField textField3 = new JTextField("Type", 10);
		JButton validateBtn = new JButton("Validate");
		Vue.panel3.add(textField1);
		Vue.panel3.add(textField2);
		Vue.panel3.add(textField3);
		Vue.panel3.add(validateBtn);
		
		validateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
        		String name = textField1.getText();
        		String HP = textField2.getText();
        		String type = textField3.getText();
        		
        		if (name.length() == 0 || HP.length() == 0 || type.length() == 0) {
        			JOptionPane.showMessageDialog(Vue.panel3, "All fields are required");
        		}
        		else {
        			listCards.add(new Card(type, HP, name));
            		writeInFile();
        		}
        		
            }
            });
		
	}
	
	public static void seeCards(){
		try{
            FileInputStream fis = new FileInputStream("cards.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listCards = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            if(listCards.size() == 0) {
            	JLabel empty = new JLabel("No pokemon yet.");
            	Vue.panel1.add(empty);
            }
            else {
            	 System.out.println(listCards.size() + " cards");
                 JLabel pokemon = new JLabel();
                 pokemon.setText("<html><ul>");
                 for(Card tmp: listCards){
                 	pokemon.setText(pokemon.getText() + "<li>Pokemon : " + tmp.getName() + " HP :" + tmp.getHp() + " Type : " + tmp.getType() + "</li>");
     	        }
                 pokemon.setText(pokemon.getText() + "</ul></html>");
                 Vue.panel1.add(pokemon);
            }
         }catch(IOException ioe){
             ioe.printStackTrace();
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
	}

	public static void deleteCards(){
		try{
            FileInputStream fis = new FileInputStream("cards.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listCards = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            if(listCards.size() == 0) {
            	JLabel empty = new JLabel("No pokemon to delete.");
            	Vue.panel2.add(empty);
            }
            else {
            	 JLabel pokemon = new JLabel();
                 pokemon.setText("<html><ul>");
                 int counter = 0;
                 for(Card tmp: listCards){
             		pokemon.setText(pokemon.getText() + "<li>Card number : " + counter + " Pokemon : " + tmp.getName() + " HP :" + tmp.getHp() + " Type : " + tmp.getType() + "</li>");
                 	counter++;
                 }
                 pokemon.setText(pokemon.getText() + "</ul></html>");
                 Vue.panel2.add(pokemon);
                 
                JPanel deleteForm = new JPanel();
         		JLabel infoDelete = new JLabel("Give the card number you want to delete : ");
         		final JTextField cardNumber = new JTextField(5);
         		JButton validateBtn = new JButton("OK");
         		deleteForm.add(infoDelete);
         		deleteForm.add(cardNumber);
         		deleteForm.add(validateBtn);
         		Vue.panel2.add(deleteForm);
         		
         		validateBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                    	String index = cardNumber.getText();
                    	int toDelete = Integer.parseInt(index);
                    	JOptionPane.showMessageDialog(Vue.panel2, "Deleting " + listCards.get(toDelete).getName());
                    	listCards.remove(toDelete);
                    	writeInFile();
                    	
                    }
                });
            }
           
         }catch(IOException ioe){
             ioe.printStackTrace();
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
			
	}
	
	public static void modifyCards(){
		try{
            FileInputStream fis = new FileInputStream("cards.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listCards = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            if(listCards.size() == 0) {
            	JLabel empty = new JLabel("No pokemon to delete.");
            	Vue.panel4.add(empty);
            }
            else {
            	 JLabel pokemon = new JLabel();
                 pokemon.setText("<html><ul>");
                 int counter = 0;
                 for(Card tmp: listCards){
             		pokemon.setText(pokemon.getText() + "<li>Card number : " + counter + " Pokemon : " + tmp.getName() + " HP :" + tmp.getHp() + " Type : " + tmp.getType() + "</li>");
                 	counter++;
                 }
                 pokemon.setText(pokemon.getText() + "</ul></html>");
                 Vue.panel4.add(pokemon);
                 
                JPanel selectCardForm = new JPanel();
         		JLabel infoDelete = new JLabel("Give the card number you want to modify : ");
         		final JTextField cardNumber = new JTextField(5);
         		JButton validateBtn = new JButton("OK");
         		selectCardForm.add(infoDelete);
         		selectCardForm.add(cardNumber);
         		selectCardForm.add(validateBtn);
         		Vue.panel4.add(selectCardForm);
         		
         		final JPanel modifyForm = new JPanel();
         		final JTextField textField1 = new JTextField("Name", 10);
        		final JTextField textField2 = new JTextField("HP", 10);
        		final JTextField textField3 = new JTextField("Type", 10);
        		JButton validateBtnModify = new JButton("Validate");
        		modifyForm.add(textField1);
        		modifyForm.add(textField2);
        		modifyForm.add(textField3);
        		modifyForm.add(validateBtnModify);
        		
         		
         		validateBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                    	if (cardNumber.getText().length() == 0 ) {
                			JOptionPane.showMessageDialog(Vue.panel3, "A value is required");
                		}
                		else {
	                    	Vue.panel4.add(modifyForm);
	                    	Vue.panel4.revalidate();
	                    	Vue.panel4.repaint();
	                    	String index = cardNumber.getText();
	                    	int toDelete = Integer.parseInt(index);
	                    	writeInFile();
                		}
                    }
                });
         		
         		validateBtnModify.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                    	
                    	String index = cardNumber.getText();
                    	int toModify = Integer.parseInt(index);
                    	
                    	String name = textField1.getText();
                		String HP = textField2.getText();
                		String type = textField3.getText();
                		
                		if (name.length() == 0 || HP.length() == 0 || type.length() == 0) {
                			JOptionPane.showMessageDialog(Vue.panel3, "All fields are required");
                		}
                		else {
                			listCards.get(toModify).setType(type);
                			listCards.get(toModify).setHP(HP);
                			listCards.get(toModify).setName(name);
                    		writeInFile();
                    		JOptionPane.showMessageDialog(Vue.panel3, "Card well modified !");
                    		System.out.println(listCards);
                		}                    	
                    }
                });
            }
           
         }catch(IOException ioe){
             ioe.printStackTrace();
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
			
	}
	
	public static void writeInFile(){
		try{
	         ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("cards.txt"));
	         oos.writeObject(listCards);
	         oos.close();
	       } catch(IOException ioe) {
	            ioe.printStackTrace();
	       }
	}

}
