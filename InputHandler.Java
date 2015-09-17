package mainPackage;

import java.awt.event.*;

public class InputHandler implements KeyListener, MouseListener {
	
	boolean left = false;
	boolean right = false;
	boolean up = false;
	boolean down = false;
	boolean space = false;
	boolean enter = false;
	
	int clicked = 0;
	int x;
	int y;
	
	boolean[] inputKeyArray = {left, right, up, down, space, enter};
	int[] inputMouseArray = {clicked, x, y};
	
	InputHandler() {
		//Because its good coding practice to have one.  ~Andy Harris
	}
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_A){
			inputKeyArray[0] = true;
		}
		
		if(code == KeyEvent.VK_D){
			inputKeyArray[1] = true;
		}
		
		if(code == KeyEvent.VK_W){
			inputKeyArray[2] = true;
		}
		
		if(code == KeyEvent.VK_S){
			inputKeyArray[3] = true;
		}
		
		if(code == KeyEvent.VK_SPACE){
			inputKeyArray[4] = true;
		}
		
		if(code == KeyEvent.VK_ENTER){
			inputKeyArray[5] = true;
		}
	}
	
	public boolean[] processKeys(){
		return inputKeyArray;
	}
	
	public int[] processMouse(){
		return inputMouseArray;
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_A){
			inputKeyArray[0] = false;
		}
		
		if(code == KeyEvent.VK_D){
			inputKeyArray[1] = false;
		}
		
		if(code == KeyEvent.VK_W){
			inputKeyArray[2] = false;
		}
		
		if(code == KeyEvent.VK_S){
			inputKeyArray[3] = false;
		}
		
		if(code == KeyEvent.VK_SPACE){
			inputKeyArray[4] = false;
		}
		
		if(code == KeyEvent.VK_ENTER){
			inputKeyArray[5] = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		inputMouseArray[0] = 1;
		//might need to be global
		inputMouseArray[1] = e.getX();
		inputMouseArray[2] = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseReset();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReset() {
		inputMouseArray[0] = 0;
		inputMouseArray[1] = 0;
		inputMouseArray[2] = 0;
	}
}
