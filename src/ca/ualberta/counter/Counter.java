package ca.ualberta.counter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/*
 * Models an individual counter
 */

public class Counter implements Comparable<Counter>, Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Date> counts;
	private int counterValue;
	private String name;
	
	Counter() {
		counterValue=0;
		counts = new ArrayList<Date>();
		this.name="unnamed";
	}
	
	Counter(String name) {
		this();
		this.name=name;
	}
	
	public void count() {
		counts.add(new Date());
		counterValue++;
	}
	
	public int getCounterValue() {
		return counterValue;
	}
	
	public void reset() {
		counterValue=0;		
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
	
	@Override
	public String toString() {
		return this.name + " -- " + this.counterValue;
	}

	@Override
	public int compareTo(Counter another) {
		if(this.getCounterValue()<another.getCounterValue())
			return -1;
		else if(this.getCounterValue()==another.getCounterValue())
			return 0;
		else
			return 1;
	}
}
