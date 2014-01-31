package ca.ualberta.counter;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Activity in which a single counter is browsed.
 * Provides access to all resources of the Counter.
 */

public class CounterActivity extends CounterListActivity {
	
	private Button count;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);
		getActionBar().setDisplayHomeAsUpEnabled (true);
		count = (Button) findViewById(R.id.count);
		count.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getActiveCounter().count();
				count.setText(Integer.toString(getActiveCounter().getCounterValue()));
				saveCounterList();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.counter_activity_actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
        case R.id.rename_action:
        	startActivity(new Intent("android.intent.action.RENAME"));
            return true;
        case R.id.reset_action:
        	getActiveCounter().reset();
			count.setText(Integer.toString(getActiveCounter().getCounterValue()));
			saveCounterList();
			return true;
        case R.id.delete_action:
        	removeActiveCounter();
			saveCounterList();
			finish();
            return true;
        case R.id.statistics_action:
			startActivity(new Intent("android.intent.action.STATISTICS"));
            return true;
        //Makes ActionBar back button behave as physical back button
        case android.R.id.home:
            onBackPressed();
        default:
            return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		if(getActiveCounter().getCounterValue() != 0)
			count.setText(Integer.toString(getActiveCounter().getCounterValue()));
		getActionBar().setTitle(getActiveCounter().getName());
	}
	
}
