package ca.ualberta.counter;

import android.app.Activity;
import android.os.Bundle;

/*
 * Show summary of counts by time.
 * In the same activity are given buttons
 * for choosing how to summarize the statistics,
 * changing the list when the button is clicked.
 */

public class StatisticsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statistics);
	}

}
