package mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LogicBooleanLevel extends Level {
	
	private static final long serialVersionUID = 1L;

	private boolean[] keyInput = new boolean[6];
	private Camera camera;
	private PlatformPlayer player;
	private SpriteSheet sheet = new SpriteSheet();
	
	//color map variables
	private int mapWidth = 300;
	private int mapHeight = 50;
	
	private Color box = new Color(150, 50, 50);
	private Color wallWithDecor = new Color(25, 100, 255);
	private Color slopeRight = new Color(50, 150, 50);
	private Color slopeLeft = new Color(50, 50, 150);
	private Color angleTopLeft = new Color(255, 75, 75);
	private Color angleTopRight = new Color(150, 255, 75);
	private Color cloudLeft = new Color(150, 50, 150);
	private Color cloudRight = new Color(25, 150, 150);
	
	//first doors indicators and button sprite's
	//////////////////////////////////////////////////////
	private ButtonSprite whiteButtonD1;

	private Sprite booleanIndicatorD1;
	
	private Sprite whiteGrayDoorWestD1;
	//////////////////////////////////////////////////////
	
	//Second doors indicators and button sprite's
	//////////////////////////////////////////////////////
	private ButtonSprite yellowLeverD2;
	private ButtonSprite orangeButtonD2;
	private ButtonSprite greenButtonD2;
	
	private Sprite greenNorthEastTubeD2;
	private Sprite greenOriginSouthD2;
	
	private Sprite orangeOriginSouthD2;
	private Sprite orangeNorthWestTubeD2;
	
	private Sprite hubWithTwoOutletsD2;
	
	private Sprite orIndicatorD2;
	private Sprite greenIndicatorD2;
	private Sprite orangeIndicatorD2;
	
	private Sprite greenDoorWestD2;
	private Sprite yellowDoorWestD2;
	//////////////////////////////////////////////////////
	
	//Third door signs and indicators
	//////////////////////////////////////////////////////
	private ButtonSprite redLeverD3;
	private ButtonSprite blueLeverD3;
	
	private Sprite redOriginSouthD3;
	private Sprite redTubeNorthEastD3;
	
	private Sprite blueOriginSouthD3;
	private Sprite blueTubeNorthWestD3;
	
	private Sprite purpleHubWithTwoOutletsD3;
	
	private Sprite andIndicatorD3;
	private Sprite redIndicatorD3;
	private Sprite blueIndicatorD3;
	private Sprite purpleIndicatorD3;
	
	private Sprite purpleDoorWestD3;
	
	private ButtonSprite endPoint;
	//////////////////////////////////////////////////////
	
	//different sprite array lists
	private ArrayList<ButtonSprite> buttonSprites = new ArrayList<ButtonSprite>();
	private ArrayList<Sprite> platformTiles = new ArrayList<Sprite>();
	private ArrayList<Sprite> clearTiles = new ArrayList<Sprite>();
	private ArrayList<Sprite> pushTiles = new ArrayList<Sprite>();
	private ArrayList<Sprite> slopeTiles = new ArrayList<Sprite>();
	
	//arrayLists for drawing with graphics
	private ArrayList<Sprite> background = new ArrayList<Sprite>();
	private ArrayList<Sprite> middleground = new ArrayList<Sprite>();
	private ArrayList<Sprite> foreground = new ArrayList<Sprite>();
	
	//sheets for our different spritesheets
	private BufferedImage[][] backgroundColorMap = sheet.getImage("LevelOne.png", mapWidth, mapHeight);
	private BufferedImage[][] platformTileSheet = sheet.getImage("Tiles_32x32.png", 8, 8);
	private BufferedImage[][] smallDoorSheet = sheet.getImage("DoorShortSS.png", 4, 7);
	private BufferedImage[][] bigDoorSheet = sheet.getImage("DoorTallSS.png", 4, 7);
	private BufferedImage[][] pipeSheet = sheet.getImage("GatesPipesSS.png", 15, 7);
	private BufferedImage[][] indicatorSheet = sheet.getImage("IndicatorSS.png", 6, 3);
	private BufferedImage[][] interactionSheet = sheet.getImage("InteractionSS.png", 6, 7);
	
	LogicBooleanLevel(){
		
	}
	
	public LogicBooleanLevel(String levelName, int levelNumber) {
		super(levelName, levelNumber);
		player = new PlatformPlayer("playerSS.png", 4, 2, 14, 40);
		camera = new Camera(0, 0, player);
		
		setBackground(new Color(23, 164, 250));

		//first doors indicators and button sprite's
		///////////////////////////////////////////////////////
		whiteButtonD1 = new ButtonSprite(interactionSheet[4][0], "switch", 11,35);

		booleanIndicatorD1 = new Sprite(indicatorSheet[4][0], 21, 40);

		whiteGrayDoorWestD1 = new Sprite(bigDoorSheet[0][0], 21, 41);
		///////////////////////////////////////////////////////
	
		//Second doors indicators and button sprite's
		///////////////////////////////////////////////////////
		yellowLeverD2 = new ButtonSprite(interactionSheet[2][3], "switch", 43,41);
		orangeButtonD2 = new ButtonSprite(interactionSheet[4][2], "switch",37,36);
		greenButtonD2 = new ButtonSprite(interactionSheet[4][4], "switch", 30,33);

		greenOriginSouthD2 = new Sprite(pipeSheet[2][0], 40, 38);
		greenNorthEastTubeD2 = new Sprite(pipeSheet[8][0], 40, 39);

		orangeOriginSouthD2 = new Sprite(pipeSheet[2][0], 42, 38);
		orangeNorthWestTubeD2 = new Sprite(pipeSheet[7][0], 42, 39);

		hubWithTwoOutletsD2 = new Sprite(pipeSheet[5][0], 41, 39);

		orIndicatorD2 = new Sprite(indicatorSheet[1][0], 41, 37);
		greenIndicatorD2 = new Sprite(indicatorSheet[3][1], 40, 37);
		orangeIndicatorD2 = new Sprite(indicatorSheet[1][1], 42, 37);

		greenDoorWestD2 = new Sprite(bigDoorSheet[0][4], 41, 40);
		yellowDoorWestD2 = new Sprite(bigDoorSheet[2][3], 24, 31);
		///////////////////////////////////////////////////////
		
		//third doors indicators and button sprite's
		///////////////////////////////////////////////////////
		redLeverD3 = new ButtonSprite(interactionSheet[2][1], "switch", 7,17);
		blueLeverD3 = new ButtonSprite(interactionSheet[0][5], "switch", 14,19);

		redOriginSouthD3 = new Sprite(pipeSheet[2][0], 16,15);
		redTubeNorthEastD3 = new Sprite(pipeSheet[8][0], 16,16);

		blueOriginSouthD3 = new Sprite(pipeSheet[2][0], 18,15);
		blueTubeNorthWestD3 = new Sprite(pipeSheet[7][0], 18,16);

		purpleHubWithTwoOutletsD3 = new Sprite(pipeSheet[5][0], 17,16);

		andIndicatorD3 = new Sprite(indicatorSheet[0][0], 17,14);
		redIndicatorD3 = new Sprite(indicatorSheet[0][1], 16,14);
		blueIndicatorD3 = new Sprite(indicatorSheet[4][1], 18,14);
		purpleIndicatorD3 = new Sprite(indicatorSheet[5][1], 17,17);

		purpleDoorWestD3 = new Sprite(bigDoorSheet[0][6], 17,18);
		
		endPoint = new ButtonSprite(platformTileSheet[2][6], "syllabus", 26, 28);
		///////////////////////////////////////////////////////
		
		//arrays of unique level sprites
		///////////////////////////////////////////////////////
		Sprite[] indicators = {booleanIndicatorD1, orIndicatorD2, greenIndicatorD2, orangeIndicatorD2, hubWithTwoOutletsD2, orangeNorthWestTubeD2, orangeOriginSouthD2, greenNorthEastTubeD2, greenOriginSouthD2,
				purpleHubWithTwoOutletsD3, blueOriginSouthD3, redOriginSouthD3, redTubeNorthEastD3, blueTubeNorthWestD3, redIndicatorD3, blueIndicatorD3, andIndicatorD3, purpleIndicatorD3};
		
		Sprite[] leftDoorArray = {greenDoorWestD2, yellowDoorWestD2, whiteGrayDoorWestD1, purpleDoorWestD3};
		
		ButtonSprite[] buttonList = {yellowLeverD2, orangeButtonD2, greenButtonD2, whiteButtonD1, redLeverD3, blueLeverD3};
		///////////////////////////////////////////////////////
		
		colorDecode();
		
		for(Sprite leftDoor : leftDoorArray) {
			platformTiles.add(leftDoor);
			middleground.add(leftDoor);
		}
		
		for(int i = 0; i < buttonList.length; i++) {
			buttonSprites.add(buttonList[i]);
			middleground.add(buttonSprites.get(i));
		}
		
		for(Sprite indications : indicators) {
			clearTiles.add(indications);
			middleground.add(indications);
		}
		
		buttonSprites.add(endPoint);
		middleground.add(endPoint);
		
		middleground.add(player);
	}

	public String levelUpdate(int tick){
		String instruction = "null";
		this.tick = tick;
		camera.update();
		
		boolean canBoth;
		boolean canX;
		boolean canY;
		
		//checks to see what directions we can move
		canBoth = !collideRect(player.dX, player.dY);
		canY = !collideRect(0, player.dY);
		canX = !collideRect(player.dX, 0);
		
		
		player.setGrounded(false);
		
		if(!canY && player.dY > 0) {
			player.grounded = true;
		}
			
		if (canBoth){
			//keep values
		}
		else if(canY && !canX){
			player.dX = 0;
			
		}
		else if(canX && !canY){
			player.dY = 0;
		}
		else if(!canX && !canY){
			player.dY = 0;
			player.dX = 0;
		}

		player.update();
		player.updatePointLocation();
		camera.update();
		
		//game logic
		for(int i = 0; i < buttonSprites.size(); i++){
			if(player.getRect().intersects(buttonSprites.get(i).getRect())){
				if(keyInput[5]) {
					if(buttonSprites.get(i).getImage() == interactionSheet[2][i]) {
						buttonSprites.get(i).setImage(interactionSheet[3][i]);
					}
					buttonSprites.get(i).state = true;
				}
			}
		}
		
		if(whiteButtonD1.state) {
			whiteGrayDoorWestD1.setImage(bigDoorSheet[1][0]);
			booleanIndicatorD1.setImage(indicatorSheet[5][0]);
			platformTiles.remove(whiteGrayDoorWestD1);
			clearTiles.add(whiteGrayDoorWestD1);
			whiteButtonD1.setImage(interactionSheet[5][0]);
		}
		
		if(greenButtonD2.state) {
			greenButtonD2.setImage(interactionSheet[5][4]);
			greenNorthEastTubeD2.setImage(pipeSheet[8][4]);
			greenOriginSouthD2.setImage(pipeSheet[2][4]);
		}
		
		if(orangeButtonD2.state) {
			orangeButtonD2.setImage(interactionSheet[5][2]);
			orangeNorthWestTubeD2.setImage(pipeSheet[7][2]);
			orangeOriginSouthD2.setImage(pipeSheet[2][2]);
		}
		
		if(orangeButtonD2.state || greenButtonD2.state) {
			greenDoorWestD2.setImage(bigDoorSheet[1][4]);
			platformTiles.remove(greenDoorWestD2);
			clearTiles.add(greenDoorWestD2);
			if(orangeButtonD2.state) {
				hubWithTwoOutletsD2.setImage(pipeSheet[5][2]);
			}
			else if(greenButtonD2.state) {
				hubWithTwoOutletsD2.setImage(pipeSheet[5][4]);
			}
		}
		
		if(yellowLeverD2.state) {
			yellowDoorWestD2.setImage(bigDoorSheet[3][3]);
			platformTiles.remove(yellowDoorWestD2);
			clearTiles.add(yellowDoorWestD2);
			yellowLeverD2.setImage(interactionSheet[3][3]);
		}
		
		if(redLeverD3.state) {
			redOriginSouthD3.setImage(pipeSheet[2][1]);
			redTubeNorthEastD3.setImage(pipeSheet[8][1]);
			purpleHubWithTwoOutletsD3.setImage(pipeSheet[5][1]);
			redLeverD3.setImage(interactionSheet[3][1]);
		}
		
		if(blueLeverD3.state) {
			blueOriginSouthD3.setImage(pipeSheet[2][5]);
			blueTubeNorthWestD3.setImage(pipeSheet[7][5]);
			//change this to blue
			purpleHubWithTwoOutletsD3.setImage(pipeSheet[5][5]);
			blueLeverD3.setImage(interactionSheet[3][5]);
		}
		
		if(redLeverD3.state && blueLeverD3.state) {
			//add change to purple
			purpleHubWithTwoOutletsD3.setImage(pipeSheet[5][6]);
			purpleDoorWestD3.setImage(bigDoorSheet[1][6]);
			platformTiles.remove(purpleDoorWestD3);
			clearTiles.add(purpleDoorWestD3);
			
		}
		
		if(endPoint.state) {
			instruction = "syllabus";
		}
		return instruction;
	}
	
	private void colorDecode() {
		//level color decryption - see LevelOne.png
		for(int i = 0; i < mapWidth; i++) {
			for(int j = 0; j < mapHeight; j++) {
						
				int color = backgroundColorMap[i][j].getRGB(16, 16);
					
				if(color == box.getRGB()) {
					Sprite boxTile = new Sprite(platformTileSheet[6][0], i, j);
					platformTiles.add(boxTile);
					middleground.add(boxTile);
				}
				if(color == wallWithDecor.getRGB()) {
					Sprite decorWall = new Sprite(platformTileSheet[3][3], i, j);
					platformTiles.add(decorWall);
					middleground.add(decorWall);
				}
				if(color == slopeRight.getRGB()) {
					Sprite slopeR = new Sprite(platformTileSheet[0][7], i, j);
					slopeTiles.add(slopeR);
					middleground.add(slopeR);
				}
				if(color == slopeLeft.getRGB()) {
					Sprite slopeL = new Sprite(platformTileSheet[4][2], i, j);
					slopeTiles.add(slopeL);
					middleground.add(slopeL);
				}
				if(color == angleTopLeft.getRGB()) {
					Sprite angleTLeft = new Sprite(platformTileSheet[7][6], i, j);
					clearTiles.add(angleTLeft);
					middleground.add(angleTLeft);
				}
				if(color == angleTopRight.getRGB()) {
					Sprite angleTRight = new Sprite(platformTileSheet[4][1], i, j);
					clearTiles.add(angleTRight);
					middleground.add(angleTRight);
				}
				if(color == cloudLeft.getRGB()) {
					Sprite cloudL = new Sprite(platformTileSheet[5][4], i, j);
					clearTiles.add(cloudL);
					background.add(cloudL);
				}
				if(color == cloudRight.getRGB()) {
					Sprite cloudR = new Sprite(platformTileSheet[6][4], i, j);
					clearTiles.add(cloudR);
					background.add(cloudR);
				}
				//grass
				if(color == Color.GREEN.getRGB()) {
					Sprite greenTile = new Sprite(platformTileSheet[4][3], i, j);
					clearTiles.add(greenTile);
					middleground.add(greenTile);
				}
				// left ceiling curve
				else if(color == Color.BLUE.getRGB()) {
					Sprite blueTile = new Sprite(platformTileSheet[0][1], i, j);
					clearTiles.add(blueTile);
					middleground.add(blueTile);
				}
				//right ceiling curve
				else if(color == Color.CYAN.getRGB()) {
					Sprite cyanTile = new Sprite(platformTileSheet[6][6], i, j);
					clearTiles.add(cyanTile);
					middleground.add(cyanTile);
				}
				//middle grass platform
				else if(color == Color.BLACK.getRGB()) {
					Sprite blackTile = new Sprite(platformTileSheet[0][0], i, j);
					platformTiles.add(blackTile);	
					middleground.add(blackTile);
				}
				//normal dirt block
				else if(color == Color.RED.getRGB()) {
					Sprite redTile = new Sprite(platformTileSheet[4][0], i, j);
					platformTiles.add(redTile);
					middleground.add(redTile);
				}
				//right grass edge
				else if(color == Color.YELLOW.getRGB()) {
					Sprite yellowTile = new Sprite(platformTileSheet[1][0], i, j);
					platformTiles.add(yellowTile);
					middleground.add(yellowTile);
				}
				//left grass edge
				else if(color == Color.MAGENTA.getRGB()) {	
					Sprite magentaTile = new Sprite(platformTileSheet[2][0], i, j);
					platformTiles.add(magentaTile);
					middleground.add(magentaTile);
				}
			}
		}
	}	
	
	public boolean collideRect(int vX, int vY) {
		//test prints statements for corners
		//System.out.println(player.pointArray[0] + " " + player.pointArray[1] + " " + player.pointArray[2] + " " + player.pointArray[3]);
		//System.out.println(collidePoint(player.pointArray[0], vX, vY) + " , " + collidePoint(player.pointArray[1], vX, vY) + " , " + collidePoint(player.pointArray[2], vX, vY) + " , " + collidePoint(player.pointArray[3], vX, vY));
		boolean pointCollision = (collidePoint(player.pointArray[0], vX, vY) ||
									collidePoint(player.pointArray[1], vX, vY) ||
									collidePoint(player.pointArray[2], vX, vY) ||
									collidePoint(player.pointArray[3], vX, vY));
		return  pointCollision;
	}
	
	public boolean collidePoint(Point point, int vX, int vY) {
		//updates the points based off our players velocity
		int x = point.x + vX;
		int y = point.y + vY;
		for(Sprite platform : platformTiles) {
			//if your points position is within the tiles bounds you collided
			if((x > platform.getX()) && (x < (platform.getX() + platform.getWidth())) && 
					(y > platform.getY()) && (y < platform.getY() + platform.getHeight())){
				return true;
			}
		}
		return false; //if this false you can go there, that means collision is true
	}

	public void userInput(boolean[] inputKeyArray, int[] inputMouseArray) {	
		
		keyInput = inputKeyArray;
		if(inputMouseArray[0] == 1) {
			mouseClickedLocation.setLocation(inputMouseArray[1], inputMouseArray[2]);
		} else {
			mouseClickedLocation.setLocation(0, 0);
		}
		player.userInput(inputKeyArray, inputMouseArray, tick);
	}
	
	public void paintComponent(Graphics g){
		/*
		 *Think of the JPanel as if it were a paint canvas and the Graphics or
		 *Graphics2D as if it were the brush that you were using to paint with.
		 * So in other words, you would need them both to create your drawing.
		 */
		g2DBack = (Graphics2D) g.create();
		g2DMid = (Graphics2D) g.create();
		g2DFore = (Graphics2D) g.create();
		
		g2DBack.translate(camera.getX() / 2, camera.getY());
		g2DMid.translate(camera.getX(), camera.getY());
		
		//draws individual layers seperately
		for(int i = 0; i < background.size(); i++){
			g2DBack.drawImage(background.get(i).getImage(), null, background.get(i).getX(), background.get(i).getY());
		}
		for(int i = 0; i < middleground.size(); i++){
			g2DMid.drawImage(middleground.get(i).getImage(), null, middleground.get(i).getX(), middleground.get(i).getY());
		}
		/*for(int i = 0; i < foreground.size(); i++){
			g2DFore.drawImage(foreground.get(i).getImage(), null, foreground.get(i).getX(), foreground.get(i).getY());
		}*/
		
		g2DBack.translate(-(camera.getX() / 2), -(camera.getY()));
		g2DMid.translate(-camera.getX(), -camera.getY());
	}
}
