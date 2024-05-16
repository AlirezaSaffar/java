package game;



import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;
import java.io.*;



public class Main extends JPanel {
	
	
	

	
	

	public static void main(String[] args) {
		int i;
		JFrame from = new JFrame();
		notice na= new notice();
		Time time= new Time(from);
		tas ta = new tas();
		player p1=new player();
		player p2=new player();
		JLabel info1 = new JLabel();
		JLabel info2 = new JLabel();
		info1.setBounds(340, 670, 300, 30);
		info2.setBounds(690, 670, 300, 30);
		notice info1n=new notice();
		notice info2n=new notice();
		info1n.displayField.setBounds(320, 670, 350, 30);
		info2n.displayField.setBounds(655, 670, 330, 30);
		tablehome[] t;
		JLabel T=new JLabel();
		T.setBounds(620, 0, 130, 50);
		notice TR=new notice();
		TR.displayField.setBounds(600, 5, 150, 48);
		other o = new other();
		treasures tr=new treasures(o.table);
		background b = new background();
		showpanel show = new showpanel(o.table,p1,p2);
	JLabel n=new JLabel();
	n.setBounds(1080, 0, 250, 200);
	market m=new market();
	n.setText("");
	JButton gun= new JButton("gun(10)");
	gun.setBounds(1070, 500, 110, 75);
	gun.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		if(o.ismarketp1){
			if(p1.getmoney()>=10){p1.setmoney(p1.getmoney()-10);
			p1.setgun(p1.getgun()+1);
			o.ismarketp1=false;
			n.setText("p1 bought a gun.");
			 func.info(info1, info2, p1, p2);
			}else{n.setText("your money is not enough.");}
		}
		if(o.ismarketp2){
			if(p2.getmoney()>=10){p2.setmoney(p2.getmoney()-10);
			p2.setgun(p2.getgun()+1);
			o.ismarketp2=false;
			n.setText("p2 bought a gun.");
			func.info(info1, info2, p1, p2);}else{n.setText("your money is not enough.");}
		}
		}
		
	});
	JButton tank= new JButton("tank(20)");
	tank.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		if(o.ismarketp1){
			if(p1.getmoney()>=20){p1.setmoney(p1.getmoney()-20);
			p1.settank(p1.gettank()+1);
			o.ismarketp1=false;
			n.setText("p1 bought a tank.");
			func.info(info1, info2, p1, p2);}else{n.setText("your money is not enough.");}
		}
		if(o.ismarketp2){
			if(p2.getmoney()>=20){p2.setmoney(p2.getmoney()-20);
			p2.settank(p2.gettank()+1);
			o.ismarketp2=false;
			n.setText("p2 bought a tank.");
			func.info(info1, info2, p1, p2);}else{n.setText("your money is not enough.");}
		}
		}
		
	});
	tank.setBounds(1180, 500, 110, 75);
	JButton treasure= new JButton("treasure(50)");
	treasure.setBounds(1070, 575, 110, 75);
	treasure.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String str=new String();
			Random rand=new Random();
			
		if(o.ismarketp1){
			if(p1.getmoney()>=50){
				p1.setmoney(p1.getmoney()-50);
				int a=Math.abs(rand.nextInt())%8;
				if(a+11==11){
					str="diamond ring!";
				}
				if(a+11==12){
					str="Jeweled sword!";
				}
				if(a+11==13){
					str="golden glass!";
				}
				if(a+11==14){
					str="glass cup!";
				}
				if(a+11==15){
					str="Wooden bow arrow!";
				}
				if(a+11==16){
					str="steel shield!";
				}
				if(a+11==17){
					str="golden key!";
				}
				if(a+11==18){
					str="Dragon scroll!";
				}
				str+= " "+ "x= "+ String.valueOf(tr.t[a].x+1) + " y= " + String.valueOf(tr.t[a].y+1);
		n.setText(str);	
		func.info(info1, info2, p1, p2);}else{n.setText("your money is not enough.");}
			
			
			
		}
		if(o.ismarketp2){
			if(p2.getmoney()>=50){
				p2.setmoney(p2.getmoney()-50);
				int a=Math.abs(rand.nextInt())%8;
				if(a+11==11){
					str="diamond ring!";
				}
				if(a+11==12){
					str="Jeweled sword!";
				}
				if(a+11==13){
					str="golden glass!";
				}
				if(a+11==14){
					str="glass cup!";
				}
				if(a+11==15){
					str="Wooden bow arrow!";
				}
				if(a+11==16){
					str="steel shield!";
				}
				if(a+11==17){
					str="golden key!";
				}
				if(a+11==18){
					str="Dragon scroll!";
				}
				str= str+ " "+ "x= "+ String.valueOf(tr.t[a].x+1) + " y= " + String.valueOf(tr.t[a].y+1);
		n.setText(str);
		func.info(info1, info2, p1, p2);}else{n.setText("your money is not enough.");}
			
		}
		}
		
	});
	JButton nuclear= new JButton("nuclear(40)");
	nuclear.setBounds(1180, 575, 110, 75);
	nuclear.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		if(o.ismarketp1){
			if(p1.getmoney()>=40){p1.setmoney(p1.getmoney()-40);
			p1.setnecular(p1.getnecular()+1);
			o.ismarketp1=false;
			n.setText("p1 bought a nuclear.");
			func.info(info1, info2, p1, p2);}else{n.setText("your money is not enough.");}
		}
		if(o.ismarketp2){
			if(p2.getmoney()>=40){p2.setmoney(p2.getmoney()-40);
			p2.setnecular(p2.getnecular()+1);
			o.ismarketp2=false;
			n.setText("p2 bought a nuclear.");
			func.info(info1, info2, p1, p2);}else{n.setText("your money is not enough.");}
		}
		}
		
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	
	
	ta.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(ta.temp==0){
				o.isincastlep1=false;
				o.isincastlep2=false;
			Random rand=new Random();
		int a= Math.abs(	rand.nextInt()%6+1);
		if(a==0){a++;}
		ta.number=a;
		ta.temp=1;
		String str= String.valueOf(a);
		ta.setText(str);
		
		}
			
		}
		
	});
	ta.setBounds(100, 100, 60, 60);
	ta.setText("tas");
	t = new tablehome[100];
	
	
	
	from.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
	
	
	
	for(i=0;i<100;i++){
		t[i] = new tablehome();
		t[i].setBounds(show.circles[i].getx()+375, show.circles[i].gety()+70, 30, 30);
		t[i].setBackground(show.circles[i].getco());
	}
	func.Function(ta,p1,show,n,p2,o,t,from,tr,T, info1, info2);
	func.choisetreasure(tr, T, o);
	func.info(info1, info2, p1, p2);
	
	
	
	
	
	
	
	
	
	
	from.add(show);

	from.add(ta);
	from.add(gun);
	from.add(tank);
	from.add(nuclear);
	from.add(treasure);
	from.add(T);
	from.add(n);
	from.add(info2);
	from.add(info1);
	from.add(time.label);
	from.add(info1n.displayField);
	from.add(info2n.displayField);
	from.add(na.displayField);
	from.add(TR.displayField);
	from.add(m.displayField);
	
	 from.add(b.displayField);
	 
	 
	
	 
	from.setLocationRelativeTo(null);
	
	
	from.setSize(1000, 1000);

	
	from.setVisible(true);
	
	

	
	
	}
	
	
	
}




