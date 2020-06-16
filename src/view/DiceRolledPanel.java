package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import view.HouseDicePanel;

import model.interfaces.GameEngine;

public class DiceRolledPanel extends JPanel
{
	

	private static final long serialVersionUID = 1L;
	
	private PlayerDicePanel playerDicePanel;
	private HouseDicePanel houseDicePanel;
	private JSplitPane splitPane;
	
	public DiceRolledPanel(GameEngine gameEngine, GameFrame gameFrame)
	{
		playerDicePanel = new PlayerDicePanel();
		houseDicePanel = new HouseDicePanel();
		
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
								   playerDicePanel, houseDicePanel);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(Info.YY / 2);
		
		// provide minimum sizes for the two components in the split pane.
		Dimension minimumSize = new Dimension(Info.XXX, Info.YYY);
		playerDicePanel.setMinimumSize(minimumSize);
		houseDicePanel.setMinimumSize(minimumSize);
		splitPane.setPreferredSize(new Dimension(Info.XX / 2, Info.YY));
		add(splitPane);
	}
	
	public PlayerDicePanel getPlayerDicePanel()
	{
		return playerDicePanel;
	}
	
	public HouseDicePanel getHouseDiceResultPanel()
	{
		return houseDicePanel;
	}
}