package view;

import javax.swing.JComboBox;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;


public class ComboBox extends JComboBox<SimplePlayer>
{

	private static final long serialVersionUID = 1L;
	
	private GameEngine gameEngine;

	public ComboBox(GameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
		update();
	}
	
	public void update()
	{
		// reset playerBox
		removeAllItems();
		
		// add player name to playerBox
		for(Player player : gameEngine.getAllPlayers())
		{
			addItem(new SimplePlayer(player));
		}
	}
}