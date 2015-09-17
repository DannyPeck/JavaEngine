package mainPackage;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import mainPackage.SpriteSheet;

public class Sprite {
	//Variables are protected so that they are inherited into future sprite's
	protected SpriteSheet sheet = new SpriteSheet();
	protected BufferedImage[][] imageArray; //Sprite's corrisponding spritesheet cut into individual images and organized in a 2D array
	protected BufferedImage image; //Sprite's current Image
	protected int arrayCol = 0; //variable used for updating sprite's Column location
	protected int arrayRow = 0; //variable used for updating sprite's Row location
	protected int spriteCol; //sprite's Column location in the 2D Array
	protected int spriteRow; //sprite's Row location in the 2D Array
	protected int width; //sprite's width
	protected int height; //sprite's height
	protected int x; //sprite's Horizontal position
	protected int y; //sprite's Vertical position
	protected Rectangle rect; //a rectangle based off of our sprite's image dimensions
	protected int dX;
	protected int dY;
	public boolean state;
	
	//protected String[] instruction = {"", ""};
	
	Sprite() {
		//Because its good coding practice to have one.  ~Andy Harris
	}
	
	//tileSprite constructor
	Sprite(BufferedImage image, int gridX, int gridY) { //override constructor
		this.setUp(image, gridX, gridY); //Sprite's setup method
	}
	
	//player sprite constructor
	Sprite(String spriteSheet, int spriteCol, int spriteRow, int gridX, int gridY) { //override constructor
		this.setUp(spriteSheet, spriteCol, spriteRow, gridX, gridY); //Sprite's setup method
	}
	
	//tile setUp
	public void setUp(BufferedImage image, int gridX, int gridY) {
		this.image = image;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.x = gridX * FinalProject.GRID_SIZE;
		this.y = gridY * FinalProject.GRID_SIZE;
		this.rect = new Rectangle(x, y, width, height);
	}
	
	//player setUp
	public void setUp(String spriteSheet, int spriteCol, int spriteRow, int gridX, int gridY) { //sets all of our sprite's variables
		//sets our spriteCol and spriteRow variables
		this.spriteCol = spriteCol;
		this.spriteRow = spriteRow;
		dX = 0;
		dY = 0;
		imageArray = sheet.getImage(spriteSheet, spriteCol, spriteRow); //calls the sprite's getImage method
		image = imageArray[arrayCol][arrayRow]; //sets the sprite's initial image
		width = image.getWidth();
		height = image.getHeight();
		
		//uses our grid square constant dimensions to position the sprite
		x = FinalProject.GRID_SIZE * gridX;
		y = FinalProject.GRID_SIZE * gridY;
	
		rect = new Rectangle(x, y,  width, height); //creates a rectangle based off of our sprite's image dimensions
		
		state = false;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage bufferedImage) {
		this.image = bufferedImage;
	}
}
