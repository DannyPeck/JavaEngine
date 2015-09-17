package mainPackage;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.*;

import javax.swing.*;

public abstract class Level extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected String levelName;
	protected int levelNumber;
	protected Player player;
	protected Camera camera;
	protected int tick;
	protected Point mouseClickedLocation = new Point(0, 0);
	protected int clicked;
	protected ArrayList<Sprite> allSprites = new ArrayList<Sprite>();
	protected Graphics2D g2D;
	protected Graphics2D g2DBack;
	protected Graphics2D g2DMid;
	protected Graphics2D g2DFore;
	
	Level() {
		//Because its good coding practice to have one.  ~Andy Harris
	}
	
	Level(String levelName, int levelNumber) {
		this.levelName = levelName;
		this.levelNumber = levelNumber;
	}
	
	String getComponentName() {
		return levelName;
	}

	public String levelUpdate(int tick) {
		this.tick = tick;
		return "null";
	}
	
	public void userInput(boolean[] inputKeyArray, int[] inputMouseArray) {
		
	}
}
