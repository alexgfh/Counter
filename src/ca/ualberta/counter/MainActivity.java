package ca.ualberta.counter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
 * Main Activity, gives the option to create a new Counter or to browse existing counters.
 */

public class MainActivity extends Activity {

	private Button add, browse;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		add = (Button) findViewById(R.id.addCounter);
		browse = (Button) findViewById(R.id.browseCounters);
		
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent("android.intent.action.CREATE"));
			}
		});
		
		browse.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent("android.intent.action.BROWSE"));
			}
		});
	}
	
	protected void OnStart() {
		CounterList.load();		
	}
	
}
