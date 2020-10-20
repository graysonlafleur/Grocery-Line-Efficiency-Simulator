package edu.wit.cs.comp2000;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Implements a GroceryLine where everyone gets into the same queue
 * and gets out of the queue when a cashier is available
 *
 */
public class SingleLine implements GroceryLine {

	private Deque<Customer> q;		// single queue
	private Customer[] checkouts;	// array of checkout spots

	private Stats s;

	/**
	 * Initialize all of the checkouts and the queue
	 * @param numLines
	 */
	public SingleLine(int numLines) {
		// TODO: Implement constructor
	}

	@Override
	public void step() {
		// TODO: Implement time step
	}

	@Override
	public void arrive(Customer c) {
		// TODO: Implement customer arrival
	}

	@Override
	public boolean hasCustomers() {
		// TODO: Implement check for customers
		return false;
	}

	@Override
	public Stats getStats() {
		return s;
	}

}
