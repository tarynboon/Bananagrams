import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bananagrams extends ConsoleProgram {

	private BananagramsCanvas canvas;
	
	private RandomGenerator rgen = RandomGenerator.getInstance(); 
	
	String charList; 
	String userName;
	int totalScore = 0;
	int lastLetterPoint = 0;
	double startTime;
	boolean userQuits = false;
	boolean isFirstRound = true;
	
    public void run() {
    	introText();
    	playGame();
 
	}
	
	public void playGame(){
    	//keeps track of time
		startTime = System.currentTimeMillis();
		
		createWordList();
		//conditions to keep playing
		while(hasTimeLeft() && !userQuits && charList.length() > 0) {
			guessWords();
		}
		endGame();
	}
	
	//introduction text
	public void introText() {
		println("Welcome to the game of bananagrams!");
		print("Are you ready to play? ");
		String playGame = readLine();
		
		//start game and name
		if(playGame.equals("Yes")|| playGame.equals("yes")) {
			print("Great. What is your name? ");
			userName = readLine();
			println("Okay, " + userName + ", first I will generate a list of letters that you are to form words from.  You will have two minutes to make as many words as you can.");
			println();
			println("Ready... go");
		}
	}
	//makes random character list
	public void createWordList() {
		charList = "";
		for(int i = 0; i < 21; i++) {
			char c = (char)rgen.nextInt(97, 122);
			charList = charList + c;
		}
	}
	
	//takes in user's guess and checks for it in dictionary and string 
	public void guessWords() {
		println("Letter list - " + "\"" + charList + "\"");
		
		if(!isFirstRound) {
			askNewWord();
		}
		
		print("Enter a word - ");
		String userGuess = readLine();
		
    	BananagramsLexicon myDict = new BananagramsLexicon();
    	if(myDict.isInDict(userGuess) == false) {
    		println("Not a word, try again.");
    		guessWords();
    	} else {
    		isInString(userGuess);
    	}

	}
	
	//ask for new string and reset point
	public void askNewWord() {
		print("Do you want a new string? ");
		String answer = readLine();
		
		if(answer.equals("Y")) {
			createWordList();
			println("New word list: " + charList);
			lastLetterPoint = 0;
		}
	}
	
	//checks that word is in string
	public void isInString(String userGuess) {
		if(userGuess.equals("0")) {
			userQuits = true;
			return;
		}
		
		if(IsPresent(userGuess, charList)) {
			int score = wordScore(userGuess);
			totalScore += score;
			println("That word is worth " + score + " points, your score is " + totalScore);
			charList = removeUsedLetters(userGuess, charList);
			canvas.updateCanvas(totalScore);
		} else {
			println("It is not possible to form that word from the letters remaining");
		}
		
		//keeps track of time
		double currentSeconds = (System.currentTimeMillis() - startTime)/1000;
		double timeInSeconds = 120 - currentSeconds;
		int minutesLeft = (int) (timeInSeconds/60);
		int secondsLeft = (int) (timeInSeconds % 60);
		println("You have " + minutesLeft +":" + secondsLeft + " remaining");
		
		isFirstRound = false;
	} 
	
	//removing letters that have been used
	public String removeUsedLetters(String userGuess, String charList) {
		String newCharList = charList;
		for(int i = 0; i < userGuess.length(); i++) {
			newCharList = removeCharacter(userGuess.charAt(i), newCharList);
		}
		return newCharList;
	}
	
	//checks whether letter has been already removed (ex. no taking out all a's in list if user enters "cat")
	public String removeCharacter(char remove, String charList) {
		String newCharList = "";
		boolean alreadyRemoved = false;
		
		for(int i = 0; i < charList.length(); i++) {
			if(remove != charList.charAt(i) || alreadyRemoved) {
				newCharList = newCharList + charList.charAt(i);
			} else {
				alreadyRemoved = true;
			}
		}
		return newCharList;
	}
	
	//checks through charList for each char
	public boolean containsCharacter(char check, String charList) {
		for(int i = 0; i < charList.length(); i++) {
			if(check == charList.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	//checks that characters are present in list
	public boolean IsPresent(String userGuess, String charList) {
		for(int i = 0; i < userGuess.length(); i++) {
			if(!containsCharacter(userGuess.charAt(i), charList)) {
				return false;
			}
		}
		return true;
	}
	
	//calculates score
	public int wordScore(String userGuess) {
		int wordScore = 0;
		
		for(int i = 0; i < userGuess.length(); i++) {
			wordScore = wordScore + lastLetterPoint+i+1;
		}
		lastLetterPoint += userGuess.length();
		return wordScore;
	}
	
	//calculates time
	public boolean hasTimeLeft() {
		return System.currentTimeMillis() - startTime < 120000;
	}
	
	//ending
	public void endGame() {
		println();
		println(userName + " time is up.");
		println("Your score was " + totalScore + ". Well done.");
	}
	
	//canvas
	public void init() {
		canvas = new BananagramsCanvas();
		add(canvas);
	}
}

