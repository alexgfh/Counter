package ca.ualberta.counter;

import java.util.ArrayList;
import java.util.Date;

public class Counter {
	private ArrayList<Date> counts;
	private String name;
	
	Counter() {
		counts = new ArrayList<Date>();
	}
	
	public void count() {
		counts.add(new Date());		
	}
	
	public int getCounterValue() {
		return counts.size();
	}

	public ArrayList<Date> getCounts() {
		return counts;
	}

	public void setCounts(ArrayList<Date> countDates) {
		this.counts = countDates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
