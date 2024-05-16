package game;

public class treasures {
	treasure[] t;
	public treasures(int[][] table){
		t= new treasure[8];
		
		int i,j;
		for(i=0;i<10;i++){
			for(j=0;j<10;j++){
				if(table[i][j]==11){
					t[0] = new treasure(i,j);
					
				}
			}
		}
		for(i=0;i<10;i++){
			for(j=0;j<10;j++){
				if(table[i][j]==12){
					t[1] = new treasure(i,j);
					
				}
			}
		}
		for(i=0;i<10;i++){
			for(j=0;j<10;j++){
				if(table[i][j]==13){
					t[2] = new treasure(i,j);
					
				}
			}
		}
		for(i=0;i<10;i++){
			for(j=0;j<10;j++){
				if(table[i][j]==14){
					t[3] = new treasure(i,j);
					
				}
			}
		}
		for(i=0;i<10;i++){
			for(j=0;j<10;j++){
				if(table[i][j]==15){
					t[4] = new treasure(i,j);
					
				}
			}
		}
		for(i=0;i<10;i++){
			for(j=0;j<10;j++){
				if(table[i][j]==16){
					t[5] = new treasure(i,j);
					
				}
			}
		}
		for(i=0;i<10;i++){
			for(j=0;j<10;j++){
				if(table[i][j]==17){
					t[6] = new treasure(i,j);
					
				}
			}
		}
		for(i=0;i<10;i++){
			for(j=0;j<10;j++){
				if(table[i][j]==18){
					t[7] = new treasure(i,j);
					
				}
			}
		}
	}

}
