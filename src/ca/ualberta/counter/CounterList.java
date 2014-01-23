package ca.ualberta.counter;

import java.util.ArrayList;

public class CounterList {
	
	private static final String FILENAME = "file.sav";
	private static ArrayList<Counter> counters;
	
	public static void addCounter(String name) {
		counters.add(new Counter(name));
	}
	
	public static Counter getCounterByIndex(int index) {
		return counters.get(index);
	}

	public static ArrayList<Counter> getCounters() {
		return counters;
	}

	public static void setCounters(ArrayList<Counter> counters) {
		CounterList.counters = counters;
	}
	
	public static void load() {
		if(counters==null) {
			counters = new ArrayList<Counter>();
		}
		else {
			//load from file.sav
			
		}
	}
	
	public static void save() {
		//save in file
	}
}
