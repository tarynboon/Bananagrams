/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import acm.util.*;

public class BananagramsLexicon {

/** Returns the word at the specified index. */
	public boolean isInDict(String userWord) {
		ArrayList<String> myList = new ArrayList<String>();
		
		try {
			BufferedReader dictFile = new BufferedReader(new FileReader("BananagramsLexicon.txt"));
			while(true) {
				String line = dictFile.readLine();
				myList.add(line);
				if(line == null) {
					break;
				}
				myList.add(line);
			}
			dictFile.close();
		}
		catch(IOException ex) {
			throw new ErrorException("file not found.");
		}
		
		boolean found = false;

		for (int i = 0; i < myList.size(); i++) {
			if(userWord.equals(myList.get(i))) {
				found = true;
			}
		}
		if(found) {
			return true;
		} else {
			return false;
		}
	}
}
