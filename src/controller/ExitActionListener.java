package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GameFrame;


public class ExitActionListener implements ActionListener
{

	private GameFrame gameFrame;
	
	public ExitActionListener(GameFrame gameFrame)
	{	
		this.gameFrame = gameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// exit the game
		gameFrame.exit();
	}
}
