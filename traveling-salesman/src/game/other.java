package game;
import java.util.Random;
public class other {
	int temp;
	int[][] table;
	int tr;
	int numberoftreasures;
	boolean ismarketp1;
	boolean ismarketp2;
	boolean isincastlep1;
	boolean isincastlep2;
	
	public other(){
		this.numberoftreasures=0;
		boolean check=true;
		Random rand= new Random();
		int i,j,a,b;
		this.temp=0;
		this.ismarketp1=false;
		this.ismarketp2=false;
		this.isincastlep1=false;
		this.isincastlep2=false;
		this.table = new int[10][10];
		
		for(i=0;i<10;i++){
			for(j=0;j<10;j++){
				table[i][j]=0;
			}
		}
		a=Math.abs(rand.nextInt()%3 );
		b=Math.abs(rand.nextInt()%10);
		this.table[a][b]=1;
		a=Math.abs(rand.nextInt()%3 )+3;
		b=Math.abs(rand.nextInt()%10);
		this.table[a][b]=1;
		a=Math.abs(rand.nextInt()%3 )+6;
		b=Math.abs(rand.nextInt()%10);
		this.table[a][b]=1;
		table[0][0]=5;
		a=rand.nextInt()%4;
		switch(a){
		case 0:
			table[4][5]=4;
			break;
		case 1:
			table[5][5]=4;
			break;
		case 2:
			table[4][4]=4;
			break;
		case 3:
			table[5][4]=4;
			break;
			default:
			table[5][5]=4;
			
		}
		//////////////////////////////////////////////////
		while(check){
			a=Math.abs(rand.nextInt()%3 );
			b=Math.abs(rand.nextInt()%10);
			if(table[a][b]==0){
				table[a][b]=3;
				check=false;
			}
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 )+3;
			b=Math.abs(rand.nextInt()%10);
			if(table[a][b]==0){
				table[a][b]=3;
				check=false;
			}
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 )+6;
			b=Math.abs(rand.nextInt()%10);
			if(table[a][b]==0){
				table[a][b]=3;
				check=false;
			}
		}
		//////////////////////////////////////////////////////
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 );
			b=Math.abs(rand.nextInt()%3);
			if(table[a][b]==0){
				table[a][b]=2;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 )+3;
			b=Math.abs(rand.nextInt()%3);
			if(table[a][b]==0){
				table[a][b]=2;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 )+6;
			b=Math.abs(rand.nextInt()%3);
			if(table[a][b]==0){
				table[a][b]=2;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 );
			b=Math.abs(rand.nextInt()%3)+3;
			if(table[a][b]==0){
				table[a][b]=2;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 )+3;
			b=Math.abs(rand.nextInt()%3)+3;
			if(table[a][b]==0){
				table[a][b]=2;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 )+6;
			b=Math.abs(rand.nextInt()%3)+3;
			if(table[a][b]==0){
				table[a][b]=2;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 );
			b=Math.abs(rand.nextInt()%3)+6;
			if(table[a][b]==0){
				table[a][b]=2;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 )+3;
			b=Math.abs(rand.nextInt()%3)+6;
			if(table[a][b]==0){
				table[a][b]=2;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 )+6;
			b=Math.abs(rand.nextInt()%3)+6;
			if(table[a][b]==0){
				table[a][b]=2;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%10 );
			b=Math.abs(rand.nextInt()%10);
			if(table[a][b]==0){
				table[a][b]=2;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%10 );
			b=Math.abs(rand.nextInt()%10);
			if(table[a][b]==0){
				table[a][b]=2;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%10 );
			b=Math.abs(rand.nextInt()%10);
			if(table[a][b]==0){
				table[a][b]=2;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%10 );
			b=Math.abs(rand.nextInt()%10);
			if(table[a][b]==0){
				table[a][b]=2;
				check=false;
			}
			
		}
		////////////////////////////////////
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 );
			b=Math.abs(rand.nextInt()%3);
			if(table[a][b]==0){
				table[a][b]=11;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 )+3;
			b=Math.abs(rand.nextInt()%3);
			if(table[a][b]==0){
				table[a][b]=12;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 )+6;
			b=Math.abs(rand.nextInt()%3);
			if(table[a][b]==0){
				table[a][b]=13;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 );
			b=Math.abs(rand.nextInt()%3)+3;
			if(table[a][b]==0){
				table[a][b]=14;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 )+3;
			b=Math.abs(rand.nextInt()%3)+3;
			if(table[a][b]==0){
				table[a][b]=15;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 )+6;
			b=Math.abs(rand.nextInt()%3)+3;
			if(table[a][b]==0){
				table[a][b]=16;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 );
			b=Math.abs(rand.nextInt()%3)+6;
			if(table[a][b]==0){
				table[a][b]=17;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%3 )+3;
			b=Math.abs(rand.nextInt()%3)+6;
			if(table[a][b]==0){
				table[a][b]=18;
				check=false;
			}
			
		}
		//////////////////////////////////
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%5 );
			b=Math.abs(rand.nextInt()%5);
			if(table[a][b]==0){
				table[a][b]=6;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%5 )+5;
			b=Math.abs(rand.nextInt()%5);
			if(table[a][b]==0){
				table[a][b]=6;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%5 );
			b=Math.abs(rand.nextInt()%5)+5;
			if(table[a][b]==0){
				table[a][b]=6;
				check=false;
			}
			
		}
		check=true;
		while(check){
			a=Math.abs(rand.nextInt()%5 )+5;
			b=Math.abs(rand.nextInt()%5)+5;
			if(table[a][b]==0){
				table[a][b]=6;
				check=false;
			}
			
		}
		//////////////////////////////////
	}
	

}
