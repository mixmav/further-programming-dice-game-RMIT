package view;

import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class DiceFactory {
	private static final String FILE_PATH = String.format("images%s", File.separator);
	private static final String[] FILE_STRINGS = new String[]
	{"1.png", "2.png", "3.png", "4.png", "5.png", "6.png"};
private static Map<Integer, ImageIcon> diceFaceMap;
	
	public static ImageIcon getImageIcon(int i)
	{
		if (diceFaceMap == null)
		{
			createImageIcons();
		}
		
		return diceFaceMap.get(i);
	}

	private static void createImageIcons()
	{
		diceFaceMap = new HashMap<Integer, ImageIcon>();
		
		// update dice face map
		for (int i = 0; i < FILE_STRINGS.length; i++)
		{
			diceFaceMap.put(i, new ImageIcon(getFullPath(i)));
		}
	}
	
	private static String getFullPath(int i)
	{
		return String.format("%s%s%s", FILE_PATH, FILE_PATH.endsWith(File.separator) ? "" : File.separator,
				FILE_STRINGS[i]);
	}
}
