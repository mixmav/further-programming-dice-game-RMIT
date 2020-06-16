package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GameFrame;

/**
 * @author Huirong Huang
 * s3615907	RMIT
 */
public class AddPlayerActionListener implements ActionListener
{
	
	private GameFrame gameFrame;
	
	public AddPlayerActionListener(GameFrame gameFrame)
	{
		this.gameFrame = gameFrame;		
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// get details of the player and add the player
		gameFrame.addPlayer();
	}
}