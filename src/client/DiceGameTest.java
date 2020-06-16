package client;

import javax.swing.SwingUtilities;

import view.GameFrame;


public class DiceGameTest
{

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
				new GameFrame();				
			}
		});
	}
}