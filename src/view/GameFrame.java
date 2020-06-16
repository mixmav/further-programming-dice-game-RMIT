package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.DiceFactory;
import view.PlayerDicePanel;
import view.ComboBox;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import view.StatusBar;

public class GameFrame extends JFrame
{
	
	private static final long serialVersionUID = 1L;
		

	private static final int X = 550;
	private static final int Y = 270;
	private static final int WIDTH = 720;
	private static final int HEIGHT = 540;
	

	public static final int INITIAL_DELAY = 1;
	public static final int FINAL_DELAY = 100;
	public static final int DELAY_INCREMENT = 20;
	

	private ToolBar toolBar;
	private StatusBar statusBar;	
	private DiceFactory dicefactory;
	private Info info;
	
	final GameEngine gameEngine = new GameEngineImpl();

	// details of a specific player
	private String playerName;
	private String playerID;
	private int points;
	

	private JSplitPane splitPane;
	

public GameFrame() {
	super("Dice Game");
	gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
	gameEngine.addGameEngineCallback(new GameEngineCallbackGUI());
	setBounds(X, Y, WIDTH, HEIGHT);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	setResizable(true);
	setLayout(new BorderLayout());
	
	setJMenuBar(new MenuBar(gameEngine, this));
	
	toolBar = new ToolBar(gameEngine, this);
	add(toolBar, BorderLayout.NORTH);
	
	add(new PlayerDicePanel(), BorderLayout.CENTER);
	statusBar= new StatusBar();
	add(statusBar, BorderLayout.SOUTH);
	
	}

public String getPlayerName()
{
	return playerName;
}


public int getPoints()
{
	return points;
}

// set selected player via playerID
public void setPlayer(String playerID)
{
	this.playerID = playerID; 
	this.playerName = gameEngine.getPlayer(playerID).getPlayerName();
	this.points = gameEngine.getPlayer(playerID).getPoints();
}

public ToolBar getToolBar()
{
	return toolBar;
}

public Info getInfo()
{
	return info;
}

public StatusBar getStatusBar()
{
	return statusBar;
}
public String getPlayerID()
{
	return playerID;
}

public void removePlayer()
{
	try
	{
		// get the ID of the player to be removed
		String playerID = JOptionPane.showInputDialog("Please enter a valid player ID to be removed:");
		
		// check if the playerID entered is numerical
		new Integer(playerID);	
		gameEngine.removePlayer(gameEngine.getPlayer(playerID));
	}
	catch (NumberFormatException nfe)
	{
		System.out.println("*Error*: Not valid player ID.");
	}
}

public void exit()
{
	// exit the game
	System.exit(0);
}

public void placeBet(int bet)
{
	// check if valid bet has placed
	if(gameEngine.placeBet(gameEngine.getPlayer(playerID), bet))
	{
		// update game status and player details for selected player
		getStatusBar().getGameStatus().setText("BET HAS BEEN PLACED. TIME TO ROLL!");
		getStatusBar().getPlayerDetail().setText("PLAYER ID: " + getPlayerID() + " POINTS: " + getPoints() + " BET: " + gameEngine.getPlayer(getPlayerID()).getBet());
	}
	else
	{
		getStatusBar().getGameStatus().setText("ERROR! BALANCE NOT SUFFICIENT. PLACE BET AGAIN:)");
		System.out.println("*Warning*: Bet unaffordable.");
	}
}
public void addPlayer()
{
	try
	{
		// get the details of the player to be added
		String playerName = JOptionPane.showInputDialog("Please enter a player name to be added:");
		this.playerName = playerName;
		String playerID = JOptionPane.showInputDialog("Please enter a numerical player ID:");
		this.playerID = playerID;
		
		// check if the playerID entered is numerical
		new Integer(playerID);			
		String pointsText = JOptionPane.showInputDialog("Please enter the initial points:");
		int points = new Integer(pointsText);
		this.points = points;
		
		// check if it is a valid player
		if(playerName != null && playerID != null)
		{
			// add player to gameEngine
			gameEngine.addPlayer(new SimplePlayer(playerID, playerName, points));
			
			// update playerBox
			toolBar.getPlayerBox().update();
			
			// Initialize player dice result area
			info.getDiceResultPanel().getPlayerDicePanel().update(0,0);	
			info.getDiceResultPanel().getPlayerDicePanel().getResult().setText("Oops! Haven't rolled yet.");
			
			// update game status for adding a player successfully
			statusBar.getGameStatus().setText("GAME STATUS: " + playerName + " ADDED!");
			
			// update player details
			statusBar.getPlayerDetail().setText("PLAYER ID: " + getPlayerID() + " POINTS: " + getPoints() + " BET: 0");
		}
		else
		{
			System.out.println("*Error*:Not a Valid Player.");
		}
	}
	catch (NumberFormatException nfe)
	{
		System.out.println("*Error*: Not valid player.");
	}
}

}
