package ca.ualberta.counter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Models a list of Counters, an ArrayList composes this class
 */

class CounterList implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Counter> counters;
	
	CounterList() {
		counters = new ArrayList<Counter>();
	}
	
	public Counter getCounterAtIndex(int index) {
		return counters.get(index);
	}
	
	public void addCounter(String name) {
		counters.add(new Counter(name));
	}
	
	public void removeCounter(int index) {
		counters.remove(index);
	}
	
	public ArrayList<Counter> getCounters() {
		return counters;
	}
	
	public void sort(){
		Collections.sort(counters, new Comparator<Counter>() {
			@Override
			public int compare(Counter counter1, Counter counter2) {
				return -counter1.compareTo(counter2); //sort from greater to lesser
			}
		});
	}
}
