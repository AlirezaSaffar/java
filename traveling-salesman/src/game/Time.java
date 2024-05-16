package game;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Time implements ActionListener {
	int i=0;
	int secounds=0;
	int minutes=0;
	JLabel label= new JLabel();
	Timer timer=new Timer(1000,new ActionListener(){
		public void actionPerformed(ActionEvent e){
			i=i+1000;
			minutes= (i/60000);
			secounds= (i/1000)%60;
			label.setText(String.valueOf(minutes)+":"+String.valueOf(secounds));
		}
	});
	Time(JFrame form){
		label.setBounds(640, 670, 90, 30);
		label.setText(String.valueOf(minutes)+":"+String.valueOf(secounds));
		form.add(label);
		timer.start();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		timer.start();
		
	}

}
