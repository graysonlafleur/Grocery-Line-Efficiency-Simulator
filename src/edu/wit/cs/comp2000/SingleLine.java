package edu.wit.cs.comp2000;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

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
		s = new Stats(numLines);
		q = new ArrayDeque<Customer>();
		s.maxLine = 0;
		s.elapsedTime = 0;
		checkouts = new Customer[numLines];
	}
	@Override
	public void step() {
		if(q.size()>s.maxLine) s.maxLine = q.size();
		s.elapsedTime += Simulator.ITEM_TIME;
		for(int i = 0; i<checkouts.length; i++) {
			if(checkouts[i]!=null) {
				if(checkouts[i].done() && q.size()>0)
				{
					s.totalPeople++;
					s.totalTime+=checkouts[i].getWaitTime();
					checkouts[i]=q.poll();
					checkouts[i].startService();
				}
				else if(checkouts[i].done() && q.size()==0)
				{
					s.totalPeople++;
					s.totalTime+=checkouts[i].getWaitTime();
					checkouts[i]=q.poll();
					continue;
				}
				if(checkouts[i].getNumItems()!=0)checkouts[i].tick();
			}
		}
		Iterator<Customer> increaseTicks = q.iterator();
		while(increaseTicks.hasNext()) {
			increaseTicks.next().tick();
		}
	}

	@Override
	public void arrive(Customer c) {
		if(q.size()==0)
		{
			boolean checkCheckouts = false;
			for(int i = 0; i<checkouts.length; i++) {
				if(checkouts[i]==null) {
					checkouts[i]=c;
					checkouts[i].startService();
					checkCheckouts = true;
					break;
				}
			}
			if(!checkCheckouts) q.addLast(c);
		}
		else q.addLast(c);
	}

	@Override
	public boolean hasCustomers() {
		boolean checkCheckouts = true;
		for(int i = 0; i<checkouts.length; i++) {
			if(checkouts[i]!=null) {
				checkCheckouts = false;
				break;
			}
		}
		if(q.size()==0 && checkCheckouts) return false;
		else return true;
	}

	@Override
	public Stats getStats() {
		return s;
	}

}
