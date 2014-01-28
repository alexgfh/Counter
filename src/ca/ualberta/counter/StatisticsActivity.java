package ca.ualberta.counter;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/*
 * Show summary of counts by time.
 * In the same activity are given buttons
 * for choosing how to summarize the statistics,
 * changing the list when the button is clicked.
 */

public class StatisticsActivity extends CounterListActivity {

	private ListView listView;
	private Button hours, days, weeks, months;
	private ArrayList<String> stats;
	private ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statistics);
		listView = (ListView) findViewById(R.id.statisticsListView);
		hours = (Button) findViewById(R.id.buttonHours);
		days = (Button) findViewById(R.id.buttonDays);
		weeks = (Button) findViewById(R.id.buttonWeeks);
		months = (Button) findViewById(R.id.buttonMonths);
		stats = new ArrayList<String>(); //start with empty list
		adapter = new ArrayAdapter<String>(StatisticsActivity.this, android.R.layout.simple_list_item_1, stats);
		listView.setAdapter(adapter);
		hours.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				stats.clear();
				stats.addAll(getActiveCounter().getStatisticsByHour());
				adapter.notifyDataSetChanged();
			}
		});
		
		days.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				stats.clear();
				stats.addAll(getActiveCounter().getStatisticsByDay());
				adapter.notifyDataSetChanged();
			}
		});
		
		weeks.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				stats.clear();
				stats.addAll(getActiveCounter().getStatisticsByWeek());
				adapter.notifyDataSetChanged();
			}
		});
		
		months.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				stats.clear();
				stats.addAll(getActiveCounter().getStatisticsByMonth());
				adapter.notifyDataSetChanged();
			}
		});
	}
}
