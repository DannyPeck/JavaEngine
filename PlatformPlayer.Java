package mainPackage;

import java.awt.Point;

public class PlatformPlayer extends Player {
	PlatformPlayer() {
		//Because its good coding practice to have one.  ~Andy Harris
	}
	
	public PlatformPlayer(String spriteSheet, int spriteCol, int spriteRow, int gridX, int gridY) {
		super(spriteSheet, spriteCol, spriteRow, gridX, gridY);
		updatePointLocation();
	}

	public void update() {
		x += dX;
		dY = Math.max(Math.min(dY, maxSpeedY),-maxSpeedY);
		y += dY;
		rect.x = x;
		rect.y = y;
	}
	
	public void userInput(boolean[] inputKeyArray, int[] inputMouseArray, int tick) {
		this.tick = tick;
		boolean left = inputKeyArray[0];
		boolean right = inputKeyArray[1];
		boolean up = inputKeyArray[2];
		//boolean down = inputKeyArray[3];
		//boolean space = inputKeyArray[4];
		boolean enter = inputKeyArray[5];
		
		if(left){
			left();
		}
		
		if(right){
			right();
		}
		
		if(left && right) {
			if(state == "left") {
				image = imageArray[0][1];
			}
			else if(state == "right") {
				image = imageArray[0][0];
			}
			dX = 0;
		}
		
		if(!left && !right) {
			if(state == "left") {
				image = imageArray[0][1];
			}
			else if(state == "right") {
				image = imageArray[0][0];
			}
			dX = 0;
		}
		
		if(up && grounded){
			up();
		}
		
		if(enter){
			enter();
		}
		
		fall();
	}
	
	public void updatePointLocation() {
		pointArray[0] = new Point(rect.x + 6, rect.y + 6);
		pointArray[1] = new Point(rect.x + width - 6, rect.y + 6);
		pointArray[2] = new Point(rect.x + width - 6, rect.y + height);
		pointArray[3] = new Point(rect.x + 6, rect.y + height);
	}
	
	public void left() {
		dX -= speed;
		dX = Math.max(Math.min(dX, maxSpeedX),-maxSpeedX);
		if(tick % 5 == 0) {
			animate("left");
		}
	}
	
	public void right() {
		dX += speed;
		dX = Math.max(Math.min(dX, maxSpeedX),-maxSpeedX);
		if(tick % 5 == 0) {
			animate("right");
		}
	}
	
	public void up() {
		dY = -20;
	}
	
	public void fall() {
		dY += gravity;
	}
	
	public void animate(String direction){
		if(direction == "left") {
			arrayRow = 1;
			state = "left";
			if(arrayCol == (spriteCol - 1)){
				arrayCol = 0;
			} else {
				arrayCol += 1;
			}
			image = imageArray[arrayCol][arrayRow];
		}
		else if(direction == "right") {
			arrayRow = 0;
			state = "right";
			if(arrayCol == (spriteCol - 1)){
				arrayCol = 0;
			} else {
				arrayCol += 1;
			}
			image = imageArray[arrayCol][arrayRow];
		}
	}
	//Getters and setters for the Platform player class
	public void setGrounded(boolean state) {
		grounded = state;
	}
	
	public boolean getGrounded() {
		return grounded;
	}	
}
