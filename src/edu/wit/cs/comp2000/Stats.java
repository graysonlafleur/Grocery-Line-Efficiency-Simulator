package edu.wit.cs.comp2000;

/**
 * Statistics object that holds all relevant information about a specific GroceryLine simulation
 *
 */
public class Stats {

	public int totalPeople;	// count of people who have completed checkout
	public int totalTime;	// total wait time of all people who have completed checkout
	public int maxLine;		// maximum queue length so far
	public int elapsedTime;	// total elapsed time
	public int numLines;	// number of checkouts

	public Stats(int n) {
		numLines = n;
	}

}
