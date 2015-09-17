package mainPackage;

import java.awt.image.BufferedImage;

public class ButtonSprite extends Sprite {
	
	public String instruction;
	
	ButtonSprite() {
		
	}
	
	ButtonSprite(BufferedImage image, String purpose, int gridX, int gridY) {
		instruction = purpose;
		setUp(image, gridX, gridY);
	}
	
	public String update() {
		return instruction;
	}
}
