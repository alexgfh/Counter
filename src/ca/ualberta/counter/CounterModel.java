package ca.ualberta.counter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Models an individual counter.
 */

public class CounterModel implements Comparable<CounterModel>, Serializable {

	private static final long serialVersionUID = 1L;
	private CalendarList timeStamps = new CalendarList();
	private int counterValue;
	private String name;

	public CounterModel(String name) {
		counterValue=0;
		this.name = name;
	}

	public void count() {
		timeStamps.addNow();
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

	public ArrayList<String> getStatisticsByHour() {
		return timeStamps.getStatisticsByHour();
	}
	
	public ArrayList<String> getStatisticsByDay() {
		return timeStamps.getStatisticsByDay();
	}
	
	public ArrayList<String> getStatisticsByWeek() {
		return timeStamps.getStatisticsByWeek();
	}
	
	public ArrayList<String> getStatisticsByMonth() {
		return timeStamps.getStatisticsByMonth();
	}

}
