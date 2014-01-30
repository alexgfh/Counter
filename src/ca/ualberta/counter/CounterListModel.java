package ca.ualberta.counter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Models a list of Counters, an ArrayList composes this class
 */

class CounterListModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<CounterModel> counters;
	
	public CounterListModel() {
		counters = new ArrayList<CounterModel>();
	}
	
	public CounterModel getCounterAtIndex(int index) {
		return counters.get(index);
	}
	
	public void addCounter(String name) {
		counters.add(new CounterModel(name));
	}
	
	public void removeCounter(int index) {
		counters.remove(index);
	}
	
	public ArrayList<CounterModel> getCounters() {
		return counters;
	}
	
	public void sort(){
		Collections.sort(counters, new Comparator<CounterModel>() {
			@Override
			public int compare(CounterModel counter1, CounterModel counter2) {
				return -counter1.compareTo(counter2); //Negated so it sorts from greater to lesser.
			}
		});
	}
}
