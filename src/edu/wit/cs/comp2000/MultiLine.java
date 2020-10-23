package edu.wit.cs.comp2000;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
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
		s = new Stats(numLines);
		s.maxLine = 0;
		s.elapsedTime = 0;
		s.maxLine = 0;
		lines = new ArrayList<>();
		for(int i = 0; i<numLines; i++) {
			lines.add(new ArrayDeque<Customer>());
		}
	}

	@Override
	public void step() {
		for(int i = 0; i<lines.size(); i++) { 
			if(lines.get(i).size()>s.maxLine) {
				s.maxLine = lines.get(i).size()-1;
			}
		}
		s.elapsedTime += Simulator.ITEM_TIME;
		Iterator<Customer> increaseTicks;
		
		for(int i = 0; i<lines.size(); i++) {
			if(lines.get(i).size()!=0) {
				if(lines.get(i).peek().done() && lines.get(i).size()>1)
				{
					s.totalPeople++;
					s.totalTime+=lines.get(i).peek().getWaitTime();
					lines.get(i).removeFirst();
					lines.get(i).peek().startService();
					continue;
				}
				else if(lines.get(i).peek().done() && lines.get(i).size()==1)
				{
					s.totalPeople++;
					s.totalTime+=lines.get(i).peek().getWaitTime();
					lines.get(i).removeFirst();
					continue;
				}
			}
		}
		for(int i = 0; i<lines.size(); i++)
		{
			increaseTicks = lines.get(i).iterator();
			while(increaseTicks.hasNext()) {
				increaseTicks.next().tick();
			}
		}
	}

	@Override
	public void arrive(Customer c) {
		boolean checkCounters = false;
		for(int i = 0; i<lines.size(); i++) {
			if(lines.get(i).size()==0) {
				lines.get(i).addLast(c);
				lines.get(i).peek().startService();
				checkCounters=true;
				break;
			}
		}
		if(!checkCounters) {
			int findShortest = 0;
			for(int i = 0; i<lines.size(); i++) {
				if(lines.get(i).size()<lines.get(findShortest).size()) {
					findShortest = i;
				}
			}
			lines.get(findShortest).addLast(c);
		}
	}

	@Override
	public boolean hasCustomers() {
		boolean checkCheckouts = true;
		for(int i = 0; i<lines.size(); i++) {
			if(lines.get(i).size()!=0) {
				checkCheckouts = false;
				break;
			}
		}
		if(checkCheckouts) return false;
		else return true;
	}

	@Override
	public Stats getStats() {
		return s;
	}


}
