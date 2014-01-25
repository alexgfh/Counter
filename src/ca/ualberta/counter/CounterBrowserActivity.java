package ca.ualberta.counter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class CounterBrowserActivity extends Activity {
	
	public static CounterList counterList;
	private static Counter activeCounter;
	private ListView listview;
	private Button addCounter;
	ArrayAdapter<Counter> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		counterList = new CounterList();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browser_counter);
		listview = (ListView) findViewById(R.id.counterList);
		addCounter = (Button) findViewById(R.id.addCounter);
		addCounter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent("android.intent.action.CREATE"));
			}
		});
		ArrayList<Counter> counters = counterList.getCounters();
		adapter = new ArrayAdapter<Counter>(this, android.R.layout.simple_list_item_1, counters);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				activeCounter = counterList.getCounterAtIndex(position);
				startActivity(new Intent("android.intent.action.COUNTER"));
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		counterList.sort();
		adapter.notifyDataSetChanged();
	}
	
	public static Counter getActiveCounter() {
			return activeCounter;
	}
}