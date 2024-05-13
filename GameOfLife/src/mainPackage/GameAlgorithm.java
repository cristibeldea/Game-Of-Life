package mainPackage;

public class GameAlgorithm {
	public int gameStatus=0;
	private int map[][];
	private int mapReplace[][];
	GamePanel gp = new GamePanel(this);
	
	public void setGameStatus(int gameStatus) {
		this.gameStatus = gameStatus;
	}
	
	public void setMap(int [][] map) {
		this.map=map;
	}
	
	public void setupMapReplacement() {
		mapReplace= new int[gp.maxScreenRows][gp.maxScreenCols];
		int i,j;
		for(i=0;i<gp.maxScreenRows;i++)
			for(j=0;j<gp.maxScreenCols;j++)
			{
				mapReplace[i][j]=map[i][j];
			}
	}

	public int[][] startEvolution() {
		int i,j;
		int nearbyElements=0;
		
		for(i=0; i<gp.maxScreenRows; i++) {
			for(j=0; j<gp.maxScreenCols; j++) {
					nearbyElements=0;
					if(i!=0) {
						if(j!=0 && map[i-1][j-1]==1)
							nearbyElements++;
						if(map[i-1][j]==1)
							nearbyElements++;
						if(j!=gp.maxScreenRows-1 && map[i-1][j+1]==1)
							nearbyElements++;
					}
					
					if(j!=0 && map[i][j-1]==1)
						nearbyElements++;
					if(j!=gp.maxScreenRows-1 && map[i][j+1]==1)
						nearbyElements++;
					
					if(i!=gp.maxScreenRows-1) {
						if(j!=0 && map[i+1][j-1]==1)
							nearbyElements++;
						if(map[i+1][j]==1)
							nearbyElements++;
						if(j!=gp.maxScreenRows-1 && map[i+1][j+1]==1)
							nearbyElements++;
					}
					
				if(map[i][j]==1)
				{
					if(nearbyElements<=1)
						mapReplace[i][j]=0;
					if(nearbyElements>=4) {
						mapReplace[i][j]=0;
					}
				}
				
				if(map[i][j]==0) {
					if(nearbyElements==3)
						mapReplace[i][j]=1;
				}
				
			}
		}
		
		map=mapReplace;
		return map;
	}
	
}
