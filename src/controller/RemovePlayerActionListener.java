package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GameFrame;

/**
 * @author Huirong Huang
 * s3615907	RMIT
 */
public class RemovePlayerActionListener implements ActionListener
{

	private GameFrame GameFrame;
	
	public RemovePlayerActionListener(GameFrame GameFrame)
	{
		this.GameFrame = GameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{	
		// check if playerID is valid
		try
		{
			// get details of the player to be removed
			GameFrame.removePlayer();
			
			// update playerBox
			GameFrame.getToolBar().getPlayerBox().update();
		}
		catch (NullPointerException npe)
		{
			System.out.println("*Error*: Please enter a valid playerID.");
		}
	}
}
