package game;
import java.awt.*;
public class circle {
private Color color;
private int x;
private int y;
private int r;
public void circlee(int xx, int yy,int rr,Color colorr){
	this.x=xx;
	this.y=yy;
	this.r=rr;
	this.color=colorr;
	
}



public int getr(){return this.r;}
public int getx(){return this.x;}
public int gety(){return this.y;}
public Color getco(){return this.color;}

}
