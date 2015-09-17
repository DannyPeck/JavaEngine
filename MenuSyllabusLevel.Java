package mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MenuSyllabusLevel extends Level {
	

	private static final long serialVersionUID = 1L;
	
	SpriteSheet sheet = new SpriteSheet();
	ArrayList<ButtonSprite> buttonSprites = new ArrayList<ButtonSprite>();
	ArrayList<Sprite> platformTiles = new ArrayList<Sprite>();
	ArrayList<Sprite> clearTiles = new ArrayList<Sprite>();
	
	private Point p = MouseInfo.getPointerInfo().getLocation();
	
	BufferedImage titleImage = sheet.getImage("JDragonTitle.png");
	BufferedImage[][] backgroundColorMap = sheet.getImage("FirstTestMap.png", 36, 18);
	BufferedImage[][] unHighlightedButtonSheet = sheet.getImage("Menu.png", 1, 4);
	BufferedImage[][] highlightedButtonSheet = sheet.getImage("MenuSelected.png", 1, 4);
	BufferedImage[][] giantSpriteSheet = sheet.getImage("giantSpriteSheet.png", 64, 48);
	BufferedImage[][] marioSheet = sheet.getImage("Final_Tileset.png", 94, 74);
	BufferedImage[][] platformTileSheet = sheet.getImage("Tiles_32x32.png", 8, 8);
	
	MenuSyllabusLevel() {
		
	}
	
	public MenuSyllabusLevel(String levelName, int levelNumber) {
		this.levelName = levelName;
		
		this.setBackground(new Color(23, 100, 250));
		
		Sprite title = new Sprite(titleImage, 6, 0);
		
		allSprites.add(title);
		
		ButtonSprite booleanButton = new ButtonSprite(unHighlightedButtonSheet[0][0], "booleanLevel", 8, 3);
		ButtonSprite loopButton	= new ButtonSprite(unHighlightedButtonSheet[0][1], "andOrLevel", 8, 4);
		ButtonSprite oopButton = new ButtonSprite(unHighlightedButtonSheet[0][2], "oopLevel", 8, 5);
		ButtonSprite twoPiButton = new ButtonSprite(unHighlightedButtonSheet[0][3], "240Button", 8, 6);
		
		ButtonSprite[] buttonList = {booleanButton, loopButton, oopButton, twoPiButton};
		
		for(int i = 0; i < buttonList.length; i++) {
			buttonSprites.add(buttonList[i]);
		}
		
		for(int i = 0; i < buttonSprites.size(); i++){
			allSprites.add(buttonSprites.get(i));
		}
	
		for(int i = 0; i < buttonSprites.size(); i++){
			allSprites.add(buttonSprites.get(i));
		}
	}

	public String levelUpdate(int tick){
		this.tick = tick;
		String instruction = null;
		for(int i = 0; i < buttonSprites.size(); i++){
			int currentPX = p.x - 10;
			int currentPY = p.y - 30;
			Point hoverPoint = new Point(currentPX, currentPY);
			if(buttonSprites.get(i).getRect().contains(hoverPoint)) {
				buttonSprites.get(i).setImage(highlightedButtonSheet[0][i]);
			} else {
				buttonSprites.get(i).setImage(unHighlightedButtonSheet[0][i]);
			}
			
			if(buttonSprites.get(i).getRect().contains(mouseClickedLocation)){
				instruction = buttonSprites.get(i).update();
				return instruction;
			}
			else {
				instruction = "null";
			}
		}
		return "null";
	}
	
	public void userInput(boolean[] inputKeyArray, int[] inputMouseArray) {
		setPoint(MouseInfo.getPointerInfo().getLocation());
		if(inputMouseArray[0] == 1){
			mouseClickedLocation.setLocation(inputMouseArray[1], inputMouseArray[2]);
		} else {
			
			mouseClickedLocation.setLocation(0, 0);
		}
		
	}
	public void paintComponent(Graphics g){
		/*
		 *Think of the JPanel as if it were a paint canvas and the Graphics or
		 *Graphics2D as if it were the brush that you were using to paint with.
		 * So in other words, you would need them both to create your drawing.
		 */
		g2D = (Graphics2D) g.create();
		for(int i = 0; i < allSprites.size(); i++){
			g2D.drawImage(allSprites.get(i).getImage(), null, allSprites.get(i).getX(), allSprites.get(i).getY());
		}
	
	}

	public Point getPoint() {
		return p;
	}

	public void setPoint(Point p) {
		this.p = p;
	}
}
