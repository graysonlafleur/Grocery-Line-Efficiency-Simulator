package edu.wit.cs.comp2000;

/**
 * Hold information about an individual customer
 *
 */
public class Customer {

	private int numItems;	// Number of items in cart
	private int timeLeft;	// Time left until customer has finished with the checkout
	private int waitTime;	// Time customer has waited since arriving
	private boolean gettingServed;	// Whether the customer is currently in a checkout

	public Customer(int n) {
		numItems = n;
		timeLeft = n * Simulator.ITEM_TIME;
		waitTime = 0;
		gettingServed = false;
	}

	/**
	 * increase the elapsed wait time, and decrease the time left if in the checkout
	 */
	public void tick() {
		waitTime += Simulator.ITEM_TIME;
		if (gettingServed)
			timeLeft -= Simulator.ITEM_TIME;
	}

	public void startService() {
		gettingServed = true;
	}

	public boolean done() {
		return timeLeft == 0;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public int getNumItems() {
		return numItems;
	}
}
