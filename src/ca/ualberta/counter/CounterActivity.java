package ca.ualberta.counter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends Activity {
	
	Button back, rename, reset, statistics, count;
	TextView countDisplay;
	Counter counter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);
		setButtons();
		counter = new Counter();
	}
	
	private void setButtons() {
		back = (Button) findViewById(R.id.back);
		rename = (Button) findViewById(R.id.reset);
		statistics = (Button) findViewById(R.id.statistics);
		count = (Button) findViewById(R.id.count);
		countDisplay = (TextView) findViewById(R.id.countDisplay);
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		rename.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		statistics.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		count.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				counter.count();
				countDisplay.setText(counter.getCounterValue());
				
			}
		});
	}
}
