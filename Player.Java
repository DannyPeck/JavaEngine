package mainPackage;

import java.awt.Point;

public class Player extends Sprite {
	
	protected int gravity = 1;
	protected int speed = 1;
	protected int maxSpeedY = 12;
	protected int maxSpeedX = 4;
	protected int tick;
	protected String state;
	
	//starting at top left point going clockwise
	protected Point topLeft = new Point(0, 0);
	protected Point topRight = new Point(0, 0);
	protected Point bottomLeft = new Point(0, 0);
	protected Point bottomRight = new Point(0, 0);
	
	protected Point[] pointArray = {topLeft, topRight, bottomLeft, bottomRight};
	
	protected boolean grounded = false;
	
	Player() {
		//Because its good coding practice to have one.  ~Andy Harris
	}
	
	public Player(String spriteSheet, int spriteCol, int spriteRow, int gridX, int gridY) {
		setUp(spriteSheet, spriteCol, spriteRow, gridX, gridY);
	}
	
	public void update() {
		
	}
	
	public void updatePointLocation() {
	
	}
	
	public void userInput(boolean[] inputKeyArray, int[] inputMouseArray, int tick) {
		this.tick = tick;
		boolean left = inputKeyArray[0];
		boolean right = inputKeyArray[1];
		boolean up = inputKeyArray[2];
		boolean down = inputKeyArray[3];
		boolean space = inputKeyArray[4];
		boolean enter = inputKeyArray[5];
		
		if(left){
			left();
		}
		
		if(right){
			right();
		}
		
		if(up){
			up();
		}
		
		if(down){
			down();
		}
		
		if(space){
			space();
		}
		
		if(enter){
			enter();
		}
	}
	
	public void left() {
	
	}
	
	public void right() {
		
	}
	
	public void up() {
	
	}

	public void down() {

	}

	public void space() {
	
	}

	public void enter() {
		
	}
	
	public void animate(String direction){
		
	}
}
