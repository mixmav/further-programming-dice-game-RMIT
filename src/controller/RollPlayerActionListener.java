package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.GameFrame;


public class RollPlayerActionListener implements ActionListener
{

	private GameEngine gameEngine;
	private GameFrame GameFrame;
	
	public RollPlayerActionListener(GameEngine gameEngine, GameFrame GameFrame)
	{
		this.gameEngine = gameEngine;
		this.GameFrame = GameFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// check if a valid player has been selected
		try
		{
			// check if it is a valid player
			gameEngine.getPlayer(GameFrame.getPlayerID());
		
			// check if the player has rolled for current round
//			if(gameEngine.getPlayer(GameFrame.getPlayerID()).getRollResult() == null)
			{
				// check if valid bet has already been placed
				if(gameEngine.getPlayer(GameFrame.getPlayerID()).getBet() != 0)
				{
					// update player details
					GameFrame.getStatusBar().getPlayerDetail().setText("PLAYER ID: " + gameEngine.getPlayer(GameFrame.getPlayerID()).getPlayerId() + " POINTS: " + gameEngine.getPlayer(GameFrame.getPlayerID()).getPoints() + " BET: " + gameEngine.getPlayer(GameFrame.getPlayerID()).getBet());
					
					new Thread()
					{
						public void run()
						{
							// roll player in gameEngine
//							gameEngine.rollPlayer(gameEngine.getPlayer(GameFrame.getPlayerID()), GameFrame.INITIAL_DELAY, GameFrame.FINAL_DELAY, GameFrame.DELAY_INCREMENT, priority, priority, priority);
						}
					}.start();
					
					// update player details
					GameFrame.getStatusBar().getPlayerDetail().setText("PLAYER ID: " + gameEngine.getPlayer(GameFrame.getPlayerID()).getPlayerId() + " POINTS: " + gameEngine.getPlayer(GameFrame.getPlayerID()).getPoints() + " BET: " + gameEngine.getPlayer(GameFrame.getPlayerID()).getBet());
				}
				else
				{
					System.out.println("Warning*: You must place a valid bet before you can roll.");
				}
			}
		
			{
				System.out.println("*Warning*: A player can only roll one time for each round.");
			}
		}
		catch (NullPointerException npe)
		{
			System.out.println("*Error*: No player yet.");
		}
	}
}
