package ca.ualberta.counter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

/**
 * Models an individual counter.
 */

public class CounterModel implements Comparable<CounterModel>, Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Calendar> counts;
	private int counterValue;
	private String name;

	public CounterModel(String name) {
		counterValue=0;
		this.name = name;
		counts = new ArrayList<Calendar>();
	}

	public void count() {
		counts.add(Calendar.getInstance());
		counterValue++;
	}

	public int getCounterValue() {
		return counterValue;
	}

	public void reset() {
		counterValue = 0;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	/*
	 * Each of the following four methods returns an ArrayList with the
	 * statistics to be printed.
	 * First a HashMap is filled with keys, which are Strings that represents
	 * the Date for that format, with values that are the counts of that Date.
	 * Then, an ArrayList is filled with each String followed by it's count.
	 */
	
	public ArrayList<String> getStatisticsByHour() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(Calendar cal : counts) {
			String key = cal.get(Calendar.YEAR) + " " + 
					cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault()) + " " +
					cal.get(Calendar.DAY_OF_MONTH) + " " +
					cal.get(Calendar.HOUR_OF_DAY) + ":00";
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}
			else {
				map.put(key, 1);
			}
		}
		ArrayList<String> stats = new ArrayList<String>();
		for(String key : map.keySet()) {
			stats.add(key + " -- " + map.get(key));
		}
		return stats;
	}

	public ArrayList<String> getStatisticsByDay() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(Calendar cal : counts) {
			String key = cal.get(Calendar.YEAR) + " " + 
					cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault()) + " " +
					cal.get(Calendar.DAY_OF_MONTH);
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}
			else {
				map.put(key, 1);
			}
		}
		ArrayList<String> stats = new ArrayList<String>();
		for(String key : map.keySet()) {
			stats.add(key + " -- " + map.get(key));
		}
		return stats;
	}

	public ArrayList<String> getStatisticsByWeek() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(Calendar cal : counts) {
			String key = cal.get(Calendar.YEAR) + " " + 
					cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())
					+ " Week " +
					cal.get(Calendar.WEEK_OF_MONTH);
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}
			else {
				map.put(key, 1);
			}
		}
		ArrayList<String> stats = new ArrayList<String>();
		for(String key : map.keySet()) {
			stats.add(key + " -- " + map.get(key));
		}
		return stats;
	}

	public ArrayList<String> getStatisticsByMonth() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(Calendar cal : counts) {
			String key = cal.get(Calendar.YEAR) + " " + 
					cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}
			else {
				map.put(key, 1);
			}
		}
		ArrayList<String> stats = new ArrayList<String>();
		for(String key : map.keySet()) {
			stats.add(key + " -- " + map.get(key));
		}
		return stats;
	}

	//This is the String printed in the CounterBrowserActivity List.
	@Override
	public String toString() {
		return this.name + " -- " + this.counterValue;
	}

	//Used for sorting.
	@Override
	public int compareTo(CounterModel another) {
		if (this.getCounterValue() < another.getCounterValue())
			return -1;
		else if (this.getCounterValue() == another.getCounterValue())
			return 0;
		else
			return 1;
	}

}
