package mainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int cellSize = 9;
	final int maxScreenCols = 80;
	final int maxScreenRows = 80;
	final int screenLength = cellSize * maxScreenCols;
//	final int screenWidth = cellSize * maxScreenCols;
//	final int screenHeight = cellSize * maxScreenRows;
	int xCells=-1, yCells=-1;
	private GameAlgorithm ga;
	private int map[][];
	int temp;
	
	Thread gameThread;
	
	public GamePanel(GameAlgorithm ga) {
		
		this.setPreferredSize(new Dimension(screenLength,screenLength));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.setVisible(true);
		this.ga = ga;
		
		mapHandler mapH = new mapHandler(this);
		mapH.initializingMap();
		
		MouseHandler mouseH = new MouseHandler(this, mapH, ga);
		this.addMouseListener(mouseH); 
		
	}
	
	public void setCoordinatesMatrix(int[][] map) {
		this.map = map;
		
	}
	
	public int[][] getMap(){
		temp =1;
		return this.map;
		
	}
		
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		int i,j;
		for(i=0;i<screenLength;i+=cellSize)
			for(j=0;j<screenLength;j+=cellSize)
			{
				g2.setColor(Color.darkGray);
				g2.drawRect(i,j,cellSize,cellSize);
			}
		
		if(this.map!=null) {
			for(i=0;i<maxScreenRows;i++) {
				for(j=0;j<maxScreenCols;j++) {
					if(map[i][j]==1) {
						g2.setColor(Color.yellow);
						g2.fillRect(j * cellSize, i * cellSize, cellSize-1, cellSize-1);
					
					}
				}	
			}
				
		}
		
		
		g2.dispose();
	}

	@Override
	public void run() {
		while(gameThread!=null) {
			ga.setMap(this.map);
			ga.setupMapReplacement();
			this.map=ga.startEvolution();
			repaint();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
	
	
}
