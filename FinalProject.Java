/*
 * Made by Daniel Peck, Josh Sutton and Blake Conrad
 */

package mainPackage;

import java.awt.*;
import javax.swing.*;

class FinalProject {
	static int GRID_SIZE = 32;
	static int frameWidth = 0;
	static int frameHeight = 0;
	static int levelNumber = 0;
	static boolean keepGoing = true;

	int tick = 0;
	
	//Our threads
	Repainter paint = new Repainter();
	Updater update = new Updater();
	
	//input handler
	InputHandler inputHandler = new InputHandler();
	
	//our levels
	private MenuSyllabusLevel syllabus = new MenuSyllabusLevel("syllabus", -1);
	private LogicBooleanLevel booleanLevel = new LogicBooleanLevel("booleanLevel", 0);
	
	private JFrame frame;
	private Container container;
	private Level currentLevel = syllabus;
	private CardLayout layout = new CardLayout(); //JPanel layout manager
	private ImageIcon andyIcon = new ImageIcon("AndyIcon.png");

	//private Level[] levelArray = {syllabus, booleanLevel};
	
	public static void main(String[] args){
		new FinalProject();
	}
	
	//constructor
	public FinalProject(){
		frame = new JFrame();
		
		//frame.setTitle("DONK"); general mourning
		
		//general housekeeping
		frame.setTitle("JDragon");
		frame.setSize(768, 608);
		frameWidth = frame.getWidth();
		frameHeight = frame.getHeight();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(andyIcon.getImage());
		frame.setBackground(new Color(23, 164, 250));
		container = frame.getContentPane();
		container.setLayout(layout);
		
		//initializes first level
		levelChanger(syllabus);
		
		frame.setVisible(true);
		
		//initiates all of our threads
		update.start();
		paint.start();
	}
	
	public void levelChanger(Level level) {
		//adds our input listeners to our levels
		level.addKeyListener(inputHandler);
		level.addMouseListener(inputHandler);
		//resets the mouse input so points are reset
		inputHandler.mouseReset();
		container.add(level, level.getComponentName());
		layout.show(container, level.getComponentName());
		currentLevel = level;
		currentLevel.setFocusable(true);
		currentLevel.requestFocus();
	}
	
	public void input(){
		//returns arrays of data about current user input and passes it to the current level
		boolean[] inputKeyArray = inputHandler.processKeys();
		int[] inputMouseArray = inputHandler.processMouse();
		currentLevel.userInput(inputKeyArray, inputMouseArray);
	}
	
	class Updater extends Thread {
		public Updater () {
			
		}
		
		public synchronized void run() {
			//buttons return instructions, which change the jpanel(level) that we are looked at currently
			//the new instances below allow for it to be a start fresh on the level
			while(keepGoing){
				tick++;
				//starting user input at beginning of tick so that it doesn't change while updating
				input();
				String instruction = currentLevel.levelUpdate(tick);
				switch(instruction) {
					case "syllabus":
						//syllabus.buttonSprites.get(levelNumber).setImage(syllabus.platformTileSheet[0][levelNumber]);
						levelChanger(syllabus);
						break;
					
					case "booleanLevel":
						container.remove(booleanLevel);
						booleanLevel = new LogicBooleanLevel("booleanLevel", 0);
						levelChanger(booleanLevel);
						break;
					
					default:
						//No match
				}
				
				try{
					Thread.sleep(20);
					
				}catch(Exception e){
					System.out.println("Updater Thread Died");
				}
			}
		}
	}
	
	//updates our frame components graphics
	class Repainter extends Thread { //Repainter Thread
		public Repainter() {
			
		}
		
		public synchronized void run(){
			while(keepGoing){
				
				frame.repaint(); //if its a lightweight component it will call the components paint method
								//which can be override with paintComponent
			
				try{
					Thread.sleep(20);
				}catch(Exception e){
					System.out.println("Repainter Thread Died");
				}
			}
		}
	}
}
