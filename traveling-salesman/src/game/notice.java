package game;
import javax.swing.*;
public class notice extends JFrame {
	JLabel displayField;
	ImageIcon image ;
	public notice(){
		image = new ImageIcon(getClass().getResource("defualt.jpg"));
		displayField = new JLabel(image);
	
		displayField.setBounds(1050,50,250,100);
		
	}
	

}
