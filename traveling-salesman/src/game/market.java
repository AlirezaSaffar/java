package game;
import javax.swing.*;
public class market extends JFrame {
	JLabel displayField;
	ImageIcon image ;
	public market(){
		image = new ImageIcon(getClass().getResource("market.PNG"));
		displayField = new JLabel(image);
	
		displayField.setBounds(1070,300,220,200);
	}

}
