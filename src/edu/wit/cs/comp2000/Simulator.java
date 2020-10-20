package edu.wit.cs.comp2000;

import java.util.Scanner;

/**
 * A simulator for two different grocery store checkout policies:
 * - a single queue that feeds to all checkouts
 * - one queue for each checkout
 *
 */
public class Simulator {
	
	// number of seconds in a simulator time step
	public static final int ITEM_TIME = 10;

	public static void main(String[] args) {
		int numLines, maxItems, numCustomers;
		double customerChance;


		try (Scanner s = new Scanner(System.in)) {

			System.out.print("Enter number of lines (2 or greater): ");
			numLines = s.nextInt();

			System.out.print("Enter max number of items (2 or greater): ");
			maxItems = s.nextInt();

			System.out.print("Enter number of customers to queue (2 or greater): ");
			numCustomers = s.nextInt();


			System.out.print("Enter % chance of a customer getting in a line (1-100): ");
			customerChance = s.nextInt() / 100.0;

		}

		if ((numLines < 2) || (maxItems < 2) || (numCustomers < 2) ||
				(customerChance < 0) || (customerChance > 100)) {
			System.err.println("Invalid input parameters. Quitting.");
			System.exit(1);
		}

		GroceryLine sing = new SingleLine(numLines);
		GroceryLine mult = new MultiLine(numLines);

		// TODO: Implement simulation loop

		Stats sstats = sing.getStats();
		Stats mstats = mult.getStats();

		printStats(sstats, "single line");
		printStats(mstats, "multi line");
	}

	/**
	 * Print detailed statistics of simulation
	 * @param s statistics to print
	 * @param lineName description of queue policy
	 */
	private static void printStats(Stats s, String lineName) {

		double avgWaitTime = -1;
		int maxQueueLength = -1;
		double custPerHour = -1;

		// TODO: Calculate statistics

		System.out.printf("\nStatistics for %s:\nAverage wait time: %f\nMaximum queue length: %d\nCustomers per hour: %f\n",
				lineName, avgWaitTime, maxQueueLength, custPerHour);
	}
}
