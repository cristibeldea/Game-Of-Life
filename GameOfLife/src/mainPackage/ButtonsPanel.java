package mainPackage;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int panelHeight = 80;
	JButton startButton;
	GameAlgorithm ga;

	public ButtonsPanel(GamePanel gp, GameAlgorithm ga) {
		this.setPreferredSize(new Dimension(gp.screenLength, panelHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		
		Buttons butoane = new Buttons(gp, ga);
		startButton = butoane.createStartButton();
		this.add(startButton);
		
	}
}
