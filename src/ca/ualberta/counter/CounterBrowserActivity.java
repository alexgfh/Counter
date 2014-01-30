package ca.ualberta.counter;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * The main activity.
 * Provides a list of all counters, 
 * ordered by counts, and also permits
 * creating a new counter.
 */

public class CounterBrowserActivity extends CounterListActivity {
	
	private ListView listView;
	private Button addCounter;
	private EditText inputName;
	ArrayAdapter<CounterModel> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browser_counter);
		getActionBar().setTitle("Counter List");
		listView = (ListView) findViewById(R.id.counterList);
		addCounter = (Button) findViewById(R.id.addCounter);
		inputName = (EditText) findViewById(R.id.newCounterName);
		addCounter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = inputName.getText().toString();
				getCounterList().addCounter(name);
				saveCounterList();
				adapter.notifyDataSetChanged();
				inputName.setText("");
			}
		});
		loadCounterList();
		ArrayList<CounterModel> counters = getCounterList().getCounters();
		adapter = new ArrayAdapter<CounterModel>(this, android.R.layout.simple_list_item_1, counters);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				setActiveCounter(position);
				startActivity(new Intent("android.intent.action.COUNTER"));
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		getCounterList().sort();
		adapter.notifyDataSetChanged();
	}
}