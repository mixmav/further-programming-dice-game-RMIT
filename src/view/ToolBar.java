package view;

import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.PlaceBetActionListener;
import controller.RollHouseActionListener;
import controller.RollPlayerActionListener;
import controller.SelectPlayerActionListener;
import model.interfaces.GameEngine;


public class ToolBar extends JToolBar{

	
	private AbstractButton rollPlayer = new JButton("Roll Selected Player");
	private AbstractButton rollHouse = new JButton("Roll House");
	private AbstractButton placeBet = new JButton("Bet");
	private JTextField betAmount = new JTextField(10);
	private ComboBox playerBox;
	
	public ToolBar(GameEngine gameEngine, GameFrame gameFrame)
	{		
		setLayout(new FlowLayout(5));
		
		// add components
		add(rollPlayer);
		add(rollHouse);
		add(placeBet);
		add(betAmount);
	}

	public ComboBox getPlayerBox()
	{
		return playerBox;
	}
}
