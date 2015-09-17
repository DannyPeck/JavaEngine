package mainPackage;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public BufferedImage getImage(String fileName){
		File file = new File(fileName);
		BufferedImage output = null;
		try{
			output = ImageIO.read(file);
		}catch(Exception e){
			System.out.println("ERROR: couldn't load file (" + fileName + ")");
			System.exit(42);
		}
		
		return output;
	}
	
	public BufferedImage[][] getImage(String fileName, int spriteCol, int spriteRow){
	//sets sheet equal to the bufferedImage of our spritesheet
		BufferedImage sheet = getImage(fileName);
		//Our 2 dimensional array 
		BufferedImage[][] output = new BufferedImage[spriteCol][spriteRow];
		//spriteCol represents our number of Sprite's per row
		//spriteRow represents how many rows we have of images
		
		//represents out images dimensions based off given spriteCol and spriteRow
		int imgW = sheet.getWidth() / spriteCol;
		int imgH = sheet.getHeight() / spriteRow;

		for(int i = 0; i < spriteCol; i++){
			for(int j = 0; j < spriteRow; j++){
				output[i][j] = sheet.getSubimage(i * imgW, j * imgH, imgW, imgH);
			}
		}
		
		return output;
	}

}
