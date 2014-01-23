package ca.ualberta.counter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends Activity {
	
	private Button rename, reset, statistics, count;
	private TextView countDisplay;
	private Counter counter;
	private int counterIndex;
	
	public void setCounterIndex(int counterIndex) {
		this.counterIndex = counterIndex;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);
		setButtons();
	}
	
	protected void OnStart() {
		counter = CounterList.getCounterByIndex(counterIndex);
	}
	
	private void setButtons() {
		rename = (Button) findViewById(R.id.rename);
		reset = (Button) findViewById(R.id.reset);
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
				counter.reset();
				countDisplay.setText(Integer.toString(counter.getCounterValue()));
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
				counter.count();
				countDisplay.setText(Integer.toString(counter.getCounterValue()));
			}
		});
	}
}
