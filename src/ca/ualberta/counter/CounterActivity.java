package ca.ualberta.counter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends CounterListActivity {
	
	private Button rename, reset, delete, statistics, count;
	private TextView countDisplay;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);
		setButtons();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		countDisplay.setText(Integer.toString(getActiveCounter().getCounterValue()));
	}
	
	private void setButtons() {
		rename = (Button) findViewById(R.id.rename);
		reset = (Button) findViewById(R.id.reset);
		delete =  (Button) findViewById(R.id.delete);
		statistics = (Button) findViewById(R.id.statistics);
		count = (Button) findViewById(R.id.count);
		countDisplay = (TextView) findViewById(R.id.countDisplay);
		rename.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent("android.intent.action.RENAME"));
			}
		});
		reset.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getActiveCounter().reset();
				countDisplay.setText(Integer.toString(getActiveCounter().getCounterValue()));
				saveCounterList();
			}
		});
		delete.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				removeActiveCounter();
				saveCounterList();
				finish();
			}
		});
		statistics.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent("android.intent.action.STATISTICS"));
			}
		});
		count.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getActiveCounter().count();
				countDisplay.setText(Integer.toString(getActiveCounter().getCounterValue()));
				saveCounterList();
			}
		});
	}
}
