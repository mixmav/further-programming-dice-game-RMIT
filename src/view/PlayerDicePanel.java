package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.DiceFactory;


public class PlayerDicePanel extends JPanel
{

	private static final long serialVersionUID = 1L;
	
	private JLabel title = new JLabel("---------------SELECTED PLAYER DICES---------------");
	private JLabel result;
	private JLabel dice1;
	private JLabel dice2;
	
	public class DiceLabel extends JLabel
	{

		
		private static final long serialVersionUID = 1L;
		
		public static final int DICE_SIZE = 30;
		
		public DiceLabel(int i)
		{
			setIcon(DiceFactory.getImageIcon(0));
		}
	}
	
	public PlayerDicePanel()
	{
		result = new JLabel();
		dice1 = new DiceLabel(0);
		dice2 = new DiceLabel(0);
		dice1.setSize(DiceLabel.DICE_SIZE, DiceLabel.DICE_SIZE);
		dice2.setSize(DiceLabel.DICE_SIZE, DiceLabel.DICE_SIZE);
		
		// add components
		add(title);
		add(dice1);
		add(dice2);
		add(result);
	}
	
	public JLabel getResult()
	{
		return result;
	}
	
	// update dices faces
	public void update(int dice1, int dice2)
	{
		this.dice1.setIcon(DiceFactory.getImageIcon(dice1));
		this.dice2.setIcon(DiceFactory.getImageIcon(dice2));
	}
}