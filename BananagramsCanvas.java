/*
 * File: BananagramsCanvas.java
 * ------------------------
 * This file keeps track of the Bananagrams display.
 */

import java.awt.Color;

import acm.graphics.*;

public class BananagramsCanvas extends GCanvas {

/** Resets the display so that player is ready to play a new game
 *  of Bananagrams */
	public void reset() {
		/* You fill this in */
	}

/**
 * Updates the letters the user may form words from on the screen 
 */
	//public void displayLettersRemaining(String word) {
		/* You fill this in */
	//}
	

	public void drawLevelOne() {
		GLabel levelOne = new GLabel("Level One: Anger", 100, 100);
		add(levelOne);
		
		GOval face = new GOval(100, 200, 100, 100);
		face.setFilled(true);
		face.setColor(Color.red);
		add (face);
		
		GOval eyeOne = new GOval(125, 220, 20, 20);
		eyeOne.setFilled(true);
		eyeOne.setColor(Color.white);
		add (eyeOne);
		
		GOval eyeTwo = new GOval(165, 220, 20, 20);
		eyeTwo.setFilled(true);
		eyeTwo.setColor(Color.white);
		add (eyeTwo);
		
		GRect mouth = new GRect(133, 260, 30,30);
		mouth.setFilled(true);
		mouth.setColor(Color.white);
		add(mouth);

	}
	
	public void drawLevelTwo() {
		GRect clearPage = new GRect(0,0, 400, 400);
		clearPage.setFilled(true);
		clearPage.setColor(Color.white);
		add(clearPage);
		
		GLabel levelTwo = new GLabel("Level Two: Fear", 100, 100);
		add(levelTwo);
		
		GOval face = new GOval(100, 200, 100, 100);
		face.setFilled(true);
		face.setColor(Color.orange);
		add (face);
		
		GOval eyeOne = new GOval(125, 220, 20, 20);
		eyeOne.setFilled(true);
		eyeOne.setColor(Color.white);
		add (eyeOne);
		
		GOval eyeTwo = new GOval(165, 220, 20, 20);
		eyeTwo.setFilled(true);
		eyeTwo.setColor(Color.white);
		add (eyeTwo);
		
		GRect mouth = new GRect(133, 260, 30,30);
		mouth.setFilled(true);
		mouth.setColor(Color.white);
		add(mouth);

	}
	
	public void drawLevelThree() {
		GRect clearPage = new GRect(0,0, 400, 400);
		clearPage.setFilled(true);
		clearPage.setColor(Color.white);
		add(clearPage);
		
		GLabel levelThree = new GLabel("Level Three: Disgust", 100, 100);
		add(levelThree);
		
		GOval face = new GOval(100, 200, 100, 100);
		face.setFilled(true);
		face.setColor(Color.green);
		add (face);
		
		GOval eyeOne = new GOval(125, 220, 20, 20);
		eyeOne.setFilled(true);
		eyeOne.setColor(Color.white);
		add (eyeOne);
		
		GOval eyeTwo = new GOval(165, 220, 20, 20);
		eyeTwo.setFilled(true);
		eyeTwo.setColor(Color.white);
		add (eyeTwo);
		
		GRect mouth = new GRect(133, 260, 30,30);
		mouth.setFilled(true);
		mouth.setColor(Color.white);
		add(mouth);
	}
	
	public void drawLevelFour() {
		GRect clearPage = new GRect(0,0, 400, 400);
		clearPage.setFilled(true);
		clearPage.setColor(Color.white);
		add(clearPage);
		
		GLabel levelFour = new GLabel("Level Four: Sadness", 100, 100);
		add(levelFour);
		
		GOval face = new GOval(100, 200, 100, 100);
		face.setFilled(true);
		face.setColor(Color.blue);
		add (face);
		
		GOval eyeOne = new GOval(125, 220, 20, 20);
		eyeOne.setFilled(true);
		eyeOne.setColor(Color.white);
		add (eyeOne);
		
		GOval eyeTwo = new GOval(165, 220, 20, 20);
		eyeTwo.setFilled(true);
		eyeTwo.setColor(Color.white);
		add (eyeTwo);
		
		GRect mouth = new GRect(133, 260, 30,30);
		mouth.setFilled(true);
		mouth.setColor(Color.white);
		add(mouth);
	}
	
	public void drawLevelFive() {
		GRect clearPage = new GRect(0,0, 400, 400);
		clearPage.setFilled(true);
		clearPage.setColor(Color.white);
		add(clearPage);
		
		GLabel levelFive = new GLabel("Level Five: Joy", 100, 100);
		add(levelFive);
		
		GOval face = new GOval(100, 200, 100, 100);
		face.setFilled(true);
		face.setColor(Color.yellow);
		add (face);
		
		GOval eyeOne = new GOval(125, 220, 20, 20);
		eyeOne.setFilled(true);
		eyeOne.setColor(Color.white);
		add (eyeOne);
		
		GOval eyeTwo = new GOval(165, 220, 20, 20);
		eyeTwo.setFilled(true);
		eyeTwo.setColor(Color.white);
		add (eyeTwo);
		
		GRect mouth = new GRect(133, 260, 30,30);
		mouth.setFilled(true);
		mouth.setColor(Color.white);
		add(mouth);
	}
	
	public void updateCanvas(int totalScore) {
		if (totalScore < 50) {
			drawLevelOne();
		} else if (totalScore < 100) {
			drawLevelTwo();
		} else if (totalScore < 150) {
			drawLevelThree();
		} else if (totalScore < 200) {
			drawLevelFour();
		} else if (totalScore < 250){
			drawLevelFive();
		}
	}
}
