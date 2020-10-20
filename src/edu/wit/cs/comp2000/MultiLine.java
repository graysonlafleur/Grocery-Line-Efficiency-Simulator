package edu.wit.cs.comp2000;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


/**
 * Implements a GroceryLine where every checkout has its own queue.
 * New customers get into the shortest queue.
 *
 */
public class MultiLine implements GroceryLine {

	private Stats s;
	List<Deque<Customer>> lines;	// queues for each checkout

	/**
	 * Initialize all of the checkout lines
	 * @param numLines The number of queues/checkouts in simulation
	 */
	public MultiLine(int numLines) {
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
