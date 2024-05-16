package game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
public class func {
	public static void info(JLabel info1,JLabel info2,player p1,player p2){
		String str= new String();
		str="p1 " + "money=" +String.valueOf(p1.getmoney()) + " treasure="+ String.valueOf(p1.gettreasure()) +" gun= " +String.valueOf(p1.getgun())+ "tank= "  +  String.valueOf(p1.gettank())  + "nuclear="+  String.valueOf(p1.getnecular());   
	info1.setText(str);
	str="p2 " + "money=" +String.valueOf(p2.getmoney()) + " treasure="+ String.valueOf(p2.gettreasure()) +" gun= " +String.valueOf(p2.getgun())+ "tank= "  +  String.valueOf(p2.gettank())  + "nuclear="+  String.valueOf(p2.getnecular());   
	info2.setText(str);
	}
	
	public static void choisetreasure(treasures tr,JLabel T,other o){
		Random rand=new Random();
		boolean check=true;
		int a;
		
		while(check){
			a=Math.abs(rand.nextInt())%8;
			if(tr.t[a].a){
				check=false;
				o.tr=a;
				if(a+11==11){
					T.setText("diamond ring!");
				}
				if(a+11==12){
					T.setText("Jeweled sword!");
				}
				if(a+11==13){
					T.setText("golden glass!");
				}
				if(a+11==14){
					T.setText("glass cup!");
				}
				if(a+11==15){
					T.setText("Wooden bow arrow!");
				}
				if(a+11==16){
					T.setText("steel shield!");
				}
				if(a+11==17){
					T.setText("golden key!");
				}
				if(a+11==18){
					T.setText("Dragon scroll!");
				}
				
				tr.t[a].a=false;
			}
		}
		
		
	}
	public static void function(int i,tas ta,player p1,showpanel show,JLabel n,player p2,other o,treasures tr,JLabel T){
		o.ismarketp1=false;
		o.ismarketp2=false;
		n.setText("");
		
		 
		
		int a;
		int x,y;
		y = i %10;
		x= i/10;
if(o.isincastlep1){
	if(o.table[x][y]==o.tr+11){
		o.table[x][y]=0;
		p1.setmoney(p1.getmoney()+200);
		p1.settreasure(p1.gettreasure()+1);
		o.numberoftreasures++;
		if(o.numberoftreasures==8){
			if(p1.gettreasure()>p2.gettreasure()){
				n.setText("p1 wins!");
				return;
			}
			if(p2.gettreasure()>p1.gettreasure()){
				n.setText("p2 wins!");
				return;
			}
			if(p1.gettreasure()==p2.gettreasure()){
				n.setText("Draw");
				return;
			}
		}else{
			n.setText("you found a treasure!");
			choisetreasure(tr,T,o);
		}
	}else{n.setText("Wrong!");}
	
			o.isincastlep1=false;
			
			// choisetreasure(tr,T,o);
			return;
		}
		if(o.isincastlep2){
			if(o.table[x][y]==o.tr+11){
				o.table[x][y]=0;
				p2.setmoney(p2.getmoney()+200);
				p2.settreasure(p2.gettreasure()+1);
				o.numberoftreasures++;
				if(o.numberoftreasures==8){
					if(p1.gettreasure()>p2.gettreasure()){
						n.setText("p1 wins!");
						return;
					}
					if(p2.gettreasure()>p1.gettreasure()){
						n.setText("p2 wins!");
						return;
					}
					if(p1.gettreasure()==p2.gettreasure()){
						n.setText("Draw");
						return;
					}
				}else{
					n.setText("you found a treasure!");
					choisetreasure(tr,T,o);
				}
			}else{n.setText("Wrong!");}
			
					o.isincastlep2=false;
				//	choisetreasure(tr,T,o);
					return;
			
		}
		if(o.temp==0){
		a= Math.abs(x-p1.getx()/60)+Math.abs(y-p1.gety()/60);}else{
			a= Math.abs(x-p2.getx()/60)+Math.abs(y-p2.gety()/60);
		}
		if( ta.temp==1 &&ta.number%2 ==a%2 && a<=ta.number &&  o.temp==0 && o.table[x][y]!=1 &&a!=0){
			p1.setx(x*60);
			p1.sety(y*60);
			show.change_situation_p1(p1);
			ta.temp=0;
			o.temp=1;
			int power1=p1.getnecular()*8+p1.gettank()*4+p1.getgun();
			int power2=p2.getnecular()*8+p2.gettank()*4+p2.getgun();
			if(p1.getx()==p2.getx()&&p1.gety()==p2.gety()){
				if((p1.getnecular()*8+p1.gettank()*4+p1.getgun())>(p2.getnecular()*8+p2.gettank()*4+p2.getgun())){
					p1.setmoney(p1.getmoney() + p2.getmoney()*(power1-power2)/(power1+power2));
					p2.setmoney(p2.getmoney() - p2.getmoney()*(power1-power2)/(power1+power2));
					p1.setgun(p1.getgun()-p2.getgun());
					p1.settank(p1.gettank()-p2.gettank());
					p1.setnecular(p1.getnecular()-p2.getnecular());
					p2.sety(0);
					p2.setx(0);
					p2.setgun(0);
					p2.setnecular(0);
					p2.settank(0);
					
					
					
				}
				if((p1.getnecular()*8+p1.gettank()*4+p1.getgun())<(p2.getnecular()*8+p2.gettank()*4+p2.getgun())){
					p2.setmoney(p2.getmoney() + p1.getmoney()*(power2-power1)/(power1+power2));
					p1.setmoney(p1.getmoney() - p1.getmoney()*(power2-power1)/(power1+power2));
					p2.setgun(p2.getgun()-p1.getgun());
					p2.settank(p2.gettank()-p1.gettank());
  					p2.setnecular(p2.getnecular()-p1.getnecular());
					p1.sety(0);
					p1.setx(0);
					p1.setgun(0);
					p1.setnecular(0);   
					p1.settank(0);
					
				}
				if((p1.getnecular()*8+p1.gettank()*4+p1.getgun())==(p2.getnecular()*8+p2.gettank()*4+p2.getgun())){
					if(power1+power2!=0){
					p1.setmoney(p1.getmoney() + p2.getmoney()*(power1-power2)/(power1+power2));
					p2.setmoney(p2.getmoney() - p2.getmoney()*(power1-power2)/(power1+power2));}
					p1.setgun(p1.getgun()-p2.getgun());
					p1.settank(p1.gettank()-p2.gettank());
					p1.setnecular(p1.getnecular()-p2.getnecular());
					p2.sety(0);
					p2.setx(0);
					p2.setgun(0);
					p2.setnecular(0);
					p2.settank(0);
					
					
					
				}
			}
			if(o.table[x][y]==11){
				n.setText("treasure:diamond ring!");
			}
			if(o.table[x][y]==12){
				n.setText("treasure:Jeweled sword!");
			}
			if(o.table[x][y]==13){
				n.setText("treasure:golden glass!");
			}
			if(o.table[x][y]==14){
				n.setText("treasure:glass cup!");
			}
			if(o.table[x][y]==15){
				n.setText("treasure:Wooden bow arrow!");
			}
			if(o.table[x][y]==16){
				n.setText("treasure:steel shield!");
			}
			if(o.table[x][y]==17){
				n.setText("treasure:golden key!");
			}
			if(o.table[x][y]==18){
				n.setText("treasure:Dragon scroll!");
			}
			if(o.table[x][y]==0){
				n.setText("");
			}
			if(o.table[x][y]==2){
				p1.setmoney(p1.getmoney()+20);
				n.setText("loot!");
				o.table[x][y]=0;
				
			}
			if(o.table[x][y]==3){
				if(p1.getmoney()>=5){
				p1.setmoney(p1.getmoney()-5);}else{p1.setmoney(0);}
				n.setText("trap!");
				
			}
			if(o.table[x][y]==6){
				o.ismarketp1=true;
			}
			if(o.table[x][y]==4){
				o.isincastlep1=true;
			}
			
			
		}else{
		if( ta.temp==1 && ta.number%2 ==a%2 && a<=ta.number && o.table[x][y]!=1&&a!=0){
			p2.setx(x*60);
			p2.sety(y*60);
			show.change_situation_p2(p2);
			ta.temp=0;
			o.temp=0;
			int power1=p1.getnecular()*8+p1.gettank()*4+p1.getgun();
			int power2=p2.getnecular()*8+p2.gettank()*4+p2.getgun();
			if(p1.getx()==p2.getx()&&p1.gety()==p2.gety()){
				if((p1.getnecular()*8+p1.gettank()*4+p1.getgun())>(p2.getnecular()*8+p2.gettank()*4+p2.getgun())){
					p1.setmoney(p1.getmoney() + p2.getmoney()*(power1-power2)/(power1+power2));
					p2.setmoney(p2.getmoney() - p2.getmoney()*(power1-power2)/(power1+power2));
					p1.setgun(p1.getgun()-p2.getgun());
					p1.settank(p1.gettank()-p2.gettank());
					p1.setnecular(p1.getnecular()-p2.getnecular());
					p2.sety(0);
					p2.setx(0);
					p2.setgun(0);
					p2.setnecular(0);
					p2.settank(0);
					
					
					
				}
				if((p1.getnecular()*8+p1.gettank()*4+p1.getgun())<(p2.getnecular()*8+p2.gettank()*4+p2.getgun())){
					p2.setmoney(p2.getmoney() + p1.getmoney()*(power2-power1)/(power1+power2));
					p1.setmoney(p1.getmoney() - p1.getmoney()*(power2-power1)/(power1+power2));
					p2.setgun(p2.getgun()-p1.getgun());
					p2.settank(p2.gettank()-p1.gettank());
					p2.setnecular(p2.getnecular()-p1.getnecular());
					p1.sety(0);
					p1.setx(0);
					p1.setgun(0);
					p1.setnecular(0);
					p1.settank(0);
					
				}
				if((p1.getnecular()*8+p1.gettank()*4+p1.getgun())==(p2.getnecular()*8+p2.gettank()*4+p2.getgun())){
					if(power1+power2!=0){
					p2.setmoney(p2.getmoney() + p1.getmoney()*(power2-power1)/(power1+power2));
					p1.setmoney(p1.getmoney() - p1.getmoney()*(power2-power1)/(power1+power2));}
					p2.setgun(p2.getgun()-p1.getgun());
					p2.settank(p2.gettank()-p1.gettank());
					p2.setnecular(p2.getnecular()-p1.getnecular());
					p1.sety(0);
					p1.setx(0);
					p1.setgun(0);
					p1.setnecular(0);
					p1.settank(0);
					
					
					
				}
			}
			if(o.table[x][y]==11){
				n.setText("treasure:diamond ring!");
			}
			if(o.table[x][y]==12){
				n.setText("treasure:Jeweled sword!");
			}
			if(o.table[x][y]==13){
				n.setText("treasure:golden glass!");
			}
			if(o.table[x][y]==14){
				n.setText("treasure:glass cup!");
			}
			if(o.table[x][y]==15){
				n.setText("treasure:Wooden bow arrow!");
			}
			if(o.table[x][y]==16){
				n.setText("treasure:steel shield!");
			}
			if(o.table[x][y]==17){
				n.setText("treasure:golden key!");
			}
			if(o.table[x][y]==18){
				n.setText("treasure:Dragon scroll!");
			}
			if(o.table[x][y]==0){
				n.setText("");
			}
			if(o.table[x][y]==2){
				p2.setmoney(p2.getmoney()+20);
				n.setText("loot!");
				o.table[x][y]=0;
			}
			if(o.table[x][y]==3){
				if(p2.getmoney()>=5){
				p2.setmoney(p2.getmoney()-5);}else{p2.setmoney(0);}
				n.setText("trap!");
				
			}
			if(o.table[x][y]==6){
				o.ismarketp2=true;
			}
			if(o.table[x][y]==4){
				o.isincastlep2=true;
			}
		} }
}
	
	
	public static void Function(tas ta,player p1,showpanel show,JLabel n,player p2,other temp,tablehome[] t,JFrame from,treasures tr,JLabel T,JLabel info1,JLabel info2){
		t[0].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(0,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[0]);
			t[1].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(1,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[1]);
			t[2].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(2,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[2]);
			t[3].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(3,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[3]);
			t[4].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(4,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[4]);
			t[5].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(5,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[5]);
			t[6].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(6,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[6]);
			t[7].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(7,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[7]);
			t[8].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(8,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[8]);
			t[9].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(9,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[9]);
			t[10].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(10,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[10]);
			t[11].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(11,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[11]);
			t[12].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(12,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[12]);
			t[13].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(13,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[13]);
			t[14].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(14,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[14]);
			t[15].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(15,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[15]);
			t[16].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(16,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[16]);
			t[17].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(17,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[17]);
			t[18].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(18,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[18]);
			t[19].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(19,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[19]);
			t[20].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(20,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[20]);
			t[21].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(21,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[21]);
			t[22].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(22,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[22]);
			t[23].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(23,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[23]);
			t[24].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(24,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[24]);
			t[25].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(25,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[25]);
			t[26].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(26,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[26]);
			t[27].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(27,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[27]);
			t[28].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(28,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[28]);
			t[29].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			function(29,ta,p1,show,n,p2,temp, tr, T);
			info(info1,info2,p1,p2);
			from.setVisible(false);
			 from.setVisible(true);
			}});
			from.add(t[29]);
			t[30].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(30,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[30]);
				t[31].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(31,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[31]);
				t[32].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(32,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[32]);
				t[33].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(33,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[33]);
				t[34].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(34,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[34]);
				t[35].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(35,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[35]);
				t[36].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(36,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[36]);
				t[37].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(37,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[37]);
				t[38].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(38,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[38]);
				t[39].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(39,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[39]);
				t[40].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(40,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[40]);
				t[41].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(41,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[41]);
				t[42].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(42,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[42]);
				t[43].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(43,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[43]);
				t[44].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(44,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[44]);
				t[45].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(45,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[45]);
				t[46].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(46,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[46]);
				t[47].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(47,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[47]);
				t[48].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(48,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[48]);
				t[49].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(49,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[49]);
				t[50].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(50,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[50]);
				t[51].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(51,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[51]);
				t[52].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(52,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[52]);
				t[53].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(53,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[53]);
				t[54].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(54,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[54]);
				t[55].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(55,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[55]);
				t[56].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(56,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[56]);
				t[57].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(57,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[57]);
				t[58].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(58,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[58]);
				t[59].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				function(59,ta,p1,show,n,p2,temp, tr, T);
				info(info1,info2,p1,p2);
				from.setVisible(false);
				 from.setVisible(true);
				}});
				from.add(t[59]);
				t[60].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(60,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[60]);
					t[61].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(61,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[61]);
					t[62].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(62,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[62]);
					t[63].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(63,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[63]);
					t[64].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(64,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[64]);
					t[65].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(65,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[65]);
					t[66].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(66,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[66]);
					t[67].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(67,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[67]);
					t[68].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(68,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[68]);
					t[69].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(69,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[69]);
					t[70].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(70,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[70]);
					t[71].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(71,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[71]);
					t[72].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(72,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[72]);
					t[73].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(73,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[73]);
					t[74].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(74,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[74]);
					t[75].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(75,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[75]);
					t[76].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(76,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[76]);
					t[77].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(77,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[77]);
					t[78].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(78,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[78]);
					t[79].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(79,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[79]);
					t[80].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(80,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[80]);
					t[81].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(81,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[81]);
					t[82].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(82,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[82]);
					t[83].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(83,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[83]);
					t[84].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(84,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[84]);
					t[85].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(85,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[85]);
					t[86].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(86,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[86]);
					t[87].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(87,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[87]);
					t[88].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(88,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[88]);
					t[89].addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					function(89,ta,p1,show,n,p2,temp, tr, T);
					info(info1,info2,p1,p2);
					from.setVisible(false);
					 from.setVisible(true);
					}});
					from.add(t[89]);
					t[90].addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						function(90,ta,p1,show,n,p2,temp, tr, T);
						info(info1,info2,p1,p2);
						from.setVisible(false);
						 from.setVisible(true);
						}});
						from.add(t[90]);
						t[91].addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						function(91,ta,p1,show,n,p2,temp, tr, T);
						from.setVisible(false);
						 from.setVisible(true);
						}});
						from.add(t[91]);
						t[92].addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						function(92,ta,p1,show,n,p2,temp, tr, T);
						info(info1,info2,p1,p2);
						from.setVisible(false);
						 from.setVisible(true);
						}});
						from.add(t[92]);
						t[93].addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						function(93,ta,p1,show,n,p2,temp, tr, T);
						info(info1,info2,p1,p2);
						from.setVisible(false);
						 from.setVisible(true);
						}});
						from.add(t[93]);
						t[94].addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						function(94,ta,p1,show,n,p2,temp, tr, T);
						info(info1,info2,p1,p2);
						from.setVisible(false);
						 from.setVisible(true);
						}});
						from.add(t[94]);
						t[95].addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						function(95,ta,p1,show,n,p2,temp, tr, T);
						info(info1,info2,p1,p2);
						from.setVisible(false);
						 from.setVisible(true);
						}});
						from.add(t[95]);
						t[96].addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						function(96,ta,p1,show,n,p2,temp, tr, T);
						info(info1,info2,p1,p2);
						from.setVisible(false);
						 from.setVisible(true);
						}});
						from.add(t[96]);
						t[97].addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						function(97,ta,p1,show,n,p2,temp, tr, T);
						info(info1,info2,p1,p2);
						from.setVisible(false);
						 from.setVisible(true);
						}});
						from.add(t[97]);
						t[98].addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						function(98,ta,p1,show,n,p2,temp, tr, T);
						info(info1,info2,p1,p2);
						from.setVisible(false);
						 from.setVisible(true);
						}});
						from.add(t[98]);
						t[99].addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						function(99,ta,p1,show,n,p2,temp, tr, T);
						info(info1,info2,p1,p2);
						from.setVisible(false);
						 from.setVisible(true);
						}});
						from.add(t[99]);

	}

}
