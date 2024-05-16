package game;
import java.awt.*;
import javax.swing.*;
import game.circle;
import java.lang.*;

public class showpanel extends JPanel {
	circle[] circles = new circle[100] ;
	player pl;
	player p2;
	public showpanel(int[][] table,player pl,player p2){
	this.setBounds(360, 55, 600, 600);
	this.pl=pl;
	this.p2=p2;
	//setSize(1500,1500);
	Color color;
	 int i;
	 int j;
	 int k=0;
	 int ii;
	 int jj ;
    for(i=1;i<=10;i++){
		for(j=1;j<=10;j++){
			color = new Color(0,0,0);
			if(table[i-1][j-1]!=1 &&table[i-1][j-1]!=4 && table[i-1][j-1]!=5 && table[i-1][j-1]!=6  ){
			color = new Color(50,35,50) ;}
			if(table[i-1][j-1]==1){
				color = new Color(0,0,0);
				color= Color.BLACK;
				
			}
			if(table[i-1][j-1]==4){
				color = new Color(0,0,0);
				color= Color.YELLOW;
				
			}
			if(table[i-1][j-1]==5){
				color = new Color(0,0,0);
				color= Color.CYAN;
				
			}
			if(table[i-1][j-1]==6){
				color = new Color(0,0,0);
				color= Color.orange;
				
			}
			ii=i*60-60;
			jj=j*60-60;
			circles[k] = new circle();
			this.circles[k].circlee(ii,jj,60,color);
			
		
			k++;
			
			
			
		}
	}
	}
	public void change_situation_p1(player pl){
		this.pl=pl;
	}
	public void change_situation_p2(player p2){
		this.p2=p2;
	}
@Override
protected void paintComponent(Graphics g){
	super.paintComponent(g);
	int i;
    g.setColor(Color.DARK_GRAY);
   g.fillRect(0, 0, 600, 600);
    for(i=0;i<100;i++){
    	g.setColor(circles[i].getco());
    	g.fillOval(circles[i].getx(),circles[i].gety() , circles[i].getr(),circles[i].getr());
    }
    g.setColor(Color.MAGENTA);
    g.fillRect(pl.getx()+5, pl.gety()+10, 10, 30);
    g.setColor(Color.green);
    g.fillRect(p2.getx()+44, p2.gety()+23, 10, 30);
  
    
}
	

}
