package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameFrame;


public class RollHouseActionListener implements ActionListener
{
	private GameEngine gameEngine;
	private GameFrame gameFrame;
	
	public RollHouseActionListener(GameEngine gameEngine, GameFrame gameFrame)
	{
		this.gameEngine = gameEngine;
		this.gameFrame = gameFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		boolean canRoll = false;
		
		// check if at least one player has already placed valid bet
		for(Player player : gameEngine.getAllPlayers())
		{
			if(player.getResult() != null)
			{
				canRoll = true;
			}
		}
		
		// check if we can roll house
		if(canRoll)
		{
			// update house message in the area of player details
			gameFrame.getStatusBar().getPlayerDetail().setText("THIS IS HOUSE:)");
			new Thread()
			{
				public void run()
				{
					// roll house in gameEngine and settle bet
//					gameEngine.rollHouse(GameFrame.INITIAL_DELAY, GameFrame.FINAL_DELAY, GameFrame.DELAY_INCREMENT, priority, priority, priority);
					
					// update battle results
					gameFrame.getInfo().getCurrentPanel().getBattleResultPanel().update();
					
					// reset all player bets to 0s after bet settled
					for(Player player : gameEngine.getAllPlayers())
					{
						gameEngine.placeBet(player, 0);
						player.setResult(null);
					}
				}
			}.start();
			
			// update battle results
			gameFrame.getInfo().getCurrentPanel().getBattleResultPanel().update();	
		}
		else
		{
			System.out.println("*Warning*: You must roll at least one player before you can roll House.");
		}
	}
}
