package ca.ualberta.counter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

/*
 * Class that wraps an ArrayList<Calendar> and extends it with
 * functions that provides statistics by time periods.
 */

public class CalendarList implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Calendar> calendarList;

	public CalendarList() {
		calendarList = new ArrayList<Calendar>();
	}
	
	public void addNow() {
		calendarList.add(Calendar.getInstance());
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
		for(Calendar cal : calendarList) {
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
		for(Calendar cal : calendarList) {
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
		for(Calendar cal : calendarList) {
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
		for(Calendar cal : calendarList) {
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

}