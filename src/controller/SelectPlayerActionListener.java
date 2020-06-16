package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.GameFrame;


public class SelectPlayerActionListener implements ActionListener
{

	private GameEngine gameEngine;
	private GameFrame GameFrame;
	
	public SelectPlayerActionListener(GameEngine gameEngine, GameFrame GameFrame)
	{
		this.gameEngine = gameEngine;
		this.GameFrame = GameFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(GameFrame.getToolBar().getPlayerBox().getSelectedItem() != null)
		{
			// set the current player to be the selected player
			GameFrame.setPlayer(((SimplePlayer)GameFrame.getToolBar().getPlayerBox().getSelectedItem()).getPlayerId());
			
			// check if selected player has finished rolling
			if(gameEngine.getPlayer(GameFrame.getPlayerID()).getResult() != null)
			{			
				// update the player dice result
				GameFrame.getInfo().getDiceResultPanel().getPlayerDicePanel().getResult().setText(gameEngine.getPlayer(GameFrame.getPlayerID()).getResult().toString());
				GameFrame.getInfo().getDiceResultPanel().getPlayerDicePanel().update(gameEngine.getPlayer(GameFrame.getPlayerID()).getResult().getDie1().getValue(), gameEngine.getPlayer(GameFrame.getPlayerID()).getResult().getDie2().getValue());
			}
			else
			{
				// reset the player dice result
				GameFrame.getInfo().getDiceResultPanel().getPlayerDicePanel().getResult().setText("Oops! Haven't rolled yet.");
				GameFrame.getInfo().getDiceResultPanel().getPlayerDicePanel().update(0, 0);
			}
			
			// update the player details
			GameFrame.getStatusBar().getPlayerDetail().setText("PLAYER ID: " + GameFrame.getPlayerID() + " POINTS: " + GameFrame.getPoints() + " BET: " + gameEngine.getPlayer(GameFrame.getPlayerID()).getBet());
		}
	}

}
