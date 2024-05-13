package mainPackage;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GameOfLife{

	public static void main(String[] args) {
		
		final JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Game Of Life");
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		window.setLayout(new BorderLayout());
		
		GameAlgorithm ga = new GameAlgorithm();
		
		GamePanel gamePanel = new GamePanel(ga);
		ButtonsPanel buttonsPanel = new ButtonsPanel(gamePanel, ga);
		
		window.add(gamePanel,BorderLayout.NORTH);
		window.add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.setBounds(0,gamePanel.screenLength+1,gamePanel.screenLength,buttonsPanel.panelHeight);
		
		window.pack();
		
	}
	

}




