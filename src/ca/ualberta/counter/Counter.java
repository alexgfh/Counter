package ca.ualberta.counter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

/*
 * Models an individual counter.
 */

public class Counter implements Comparable<Counter>, Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Calendar> counts;
	private int counterValue;
	private String name;

	Counter(String name) {
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

	public ArrayList<Calendar> getCounts() {
		return counts;
	}

	public void setCounts(ArrayList<Calendar> countDates) {
		this.counts = countDates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	@Override
	public String toString() {
		return this.name + " -- " + this.counterValue;
	}

	@Override
	public int compareTo(Counter another) {
		if (this.getCounterValue() < another.getCounterValue())
			return -1;
		else if (this.getCounterValue() == another.getCounterValue())
			return 0;
		else
			return 1;
	}
}
