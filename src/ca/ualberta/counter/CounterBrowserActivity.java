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

	private ListView counterList;
	private Button addCounter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browser_counter);
		counterList = (ListView) findViewById(R.id.counterList);
		addCounter = (Button) findViewById(R.id.addCounter);
		addCounter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent("android.intent.action.CREATE"));
			}
		});
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		CounterList.load();
		ArrayList<Counter> counters = CounterList.getCounters();
		ArrayAdapter<Counter> adapter = new ArrayAdapter<Counter>(this, android.R.layout.simple_list_item_1, counters);
		counterList.setAdapter(adapter);
		counterList.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				CounterList.setCurrentIndex(position);
				startActivity(new Intent("android.intent.action.COUNTER"));
			}
		});
	}

}