package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import javax.swing.*;
import game.circle;
import java.lang.*;

public class background extends JFrame {
	JLabel displayField;
	ImageIcon image ;
	
	public background(){
		image = new ImageIcon(getClass().getResource("O46nEd.jpg"));
		displayField = new JLabel(image);
	
		displayField.setBounds(0,0,1500,1500);
	}
	
	
	
	
	

}


