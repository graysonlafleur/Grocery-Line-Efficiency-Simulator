package edu.wit.cs.comp2000;

/**
 * Interface for GroceryLine operations in a simulator.
 *
 */
public interface GroceryLine {

	/**
	 * runs one single timestep, which entails performing all necessary updates, including:
	 * removing people from the checkout, moving people from the queue(s) to a checkout,
	 * updating stats in both Customers and Stats
	 */
	void step();

	/**
	 * put a Customer into a checkout if it's open, or put them in a queue
	 */
	void arrive(Customer c);

	/**
	 *	check if there are any Customers in the queue(s) or in a checkout
	 */
	boolean hasCustomers();

	Stats getStats();
}
