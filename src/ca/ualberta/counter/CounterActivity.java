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
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);
		setButtons();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		countDisplay.setText(Integer.toString(CounterBrowserActivity.getActiveCounter().getCounterValue()));
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
				CounterBrowserActivity.getActiveCounter().reset();
				countDisplay.setText(Integer.toString(CounterBrowserActivity.getActiveCounter().getCounterValue()));
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
				CounterBrowserActivity.getActiveCounter().count();
				countDisplay.setText(Integer.toString(CounterBrowserActivity.getActiveCounter().getCounterValue()));
			}
		});
	}
}
