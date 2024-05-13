package mainPackage;

public class mapHandler {
	private GamePanel gp;
	private int map[][];
	
	public mapHandler(GamePanel gp) {
		this.gp =gp;
	}
	
	public void initializingMap() {
		map= new int[gp.maxScreenRows][gp.maxScreenCols];
		int i,j;
		for(i=0;i<gp.maxScreenRows;i++)
			for(j=0;j<gp.maxScreenCols;j++)
				map[i][j]=0;
		
	/*	for(i=0;i<gp.maxScreenRows;i++) {
			System.out.println();
			for(j=0;j<gp.maxScreenCols;j++)
				System.out.print(map[i][j]);
		} */
	}
	
	public void setCoordinates(int xCells, int yCells) {
		if(map[yCells][xCells]==0)
			map[yCells][xCells]=1;
		else if(map[yCells][xCells]==1) 
			map[yCells][xCells]=0;
		
		gp.setCoordinatesMatrix(map);
	}
}
