package mainPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Buttons implements ActionListener{
	private GamePanel gp;
	private GameAlgorithm ga;
	int[][] map;
	
	
	public Buttons(GamePanel gp, GameAlgorithm ga) {
		this.gp=gp;
		this.ga=ga;
	}
	
	public JButton createStartButton() {
		JButton startButton = new JButton("START");
		startButton.setBackground(Color.darkGray);
		startButton.setForeground(Color.white);
		startButton.setVisible(true);
		startButton.addActionListener(this);
		startButton.setBounds(0, 0 , 100, 100);
		
		return startButton;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(ga.gameStatus==0 ) {
			ga.setGameStatus(1);
			ga.setMap(gp.getMap());
			gp.startGameThread();
		}
	
	}

}
