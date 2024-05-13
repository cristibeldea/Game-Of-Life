package mainPackage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
	
	private GamePanel gp;
	private mapHandler mapH;
	private GameAlgorithm ga;
	int xCells, yCells;
	
	
	public MouseHandler(GamePanel gp, mapHandler mapH, GameAlgorithm ga) {
		this.gp = gp;
		this.mapH=mapH;
		this.ga=ga;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

		if(ga.gameStatus==0) {
			final int xRelativeToWindow = e.getX();
			final int yRelativeToWindow = e.getY();
			int i;
			xCells=-1;
			yCells=-1;
		
			if(yRelativeToWindow<=gp.screenLength) {
				for(i=0; i<gp.screenLength; i+=gp.cellSize, xCells++)
					if(i>xRelativeToWindow)
						break;
		
				for(i=0; i<gp.screenLength; i+=gp.cellSize, yCells++)
					if(i>yRelativeToWindow)
						break;
		
				System.out.println(xCells);
				System.out.println(yCells);
		
				mapH.setCoordinates(xCells, yCells);
				gp.repaint();
		
				System.out.println("\n");
			}
		}
	}
		

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
