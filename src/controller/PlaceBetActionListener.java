package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.interfaces.GameEngine;
import view.GameFrame;


public class PlaceBetActionListener implements ActionListener
{

	private GameEngine gameEngine;
	private GameFrame gameFrame;
	private JTextField textField;
	
	public PlaceBetActionListener(GameEngine gameEngine, GameFrame appFrame, JTextField textField)
	{
		this.gameEngine = gameEngine;
		this.gameFrame = appFrame;
		this.textField = textField;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			gameEngine.getPlayer(gameFrame.getPlayerID());
			try
			{
				// get bet amount
				String text = textField.getText();
				int bet = Integer.valueOf(text);
				
				// check if bet amount is valid
				if(bet > 0)
				{
					if(gameEngine.getPlayer(gameFrame.getPlayerID()).getBet() == 0)
					{
						gameFrame.placeBet(bet);
					}
					else
					{
						System.out.println("*Warning*: You can't place more than one bet in one around.");
					}
				}
				else
				{
					System.out.println("*Warning*: Bet can't be 0.");
				}
			}
			catch (NumberFormatException nfe)
			{
				System.out.println("*Error*: Bet is not a number.");
			}
		}
		catch (NullPointerException npe)
		{
			System.out.println("*Error*: No player yet.");
		}
	}
}