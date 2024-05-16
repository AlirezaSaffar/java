package game;

public class player {
	private int x;
	private int y;
	private int money;
	private int treasure;
	private int tank;
	private int gun;
	private int nuclear;
	public player(){
		this.x=0;
		this.y=0;
		this.treasure=0;
		this.gun=0;
		this.money=0;
		this.tank=0;
		this.nuclear=0;
	}
	public void setmoney(int a){
		
		this.money=a;
		if(a<0){this.money=0;}
		
	}
	public void settreasure(int a){
		this.treasure=a;
		
	}
	public void settank(int a){
		this.tank=a;
		if(a<0){this.tank=0;}
		
	}
	public void setgun(int a){
		this.gun=a;
		if(a<0){this.gun=0;}
		
	}
	public void setnecular(int a){
		this.nuclear=a;
		if(a<0){this.nuclear=0;}
		
	}
	
public void setx(int a){
		this.x=a;
		
	}

public void sety(int a){
	this.y=a;
		
	}
public int getnecular(){
	return this.nuclear;
	
}
public int gettank(){
	return this.tank;
	
}
public int gettreasure(){
	return this.treasure;
	
}
public int getmoney(){
	return this.money;
	
}
public int getgun(){
	return this.gun;
	
}


public int getx(){
	return this.x;
	
}
public int gety(){
	return this.y;
}
}
