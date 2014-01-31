package ca.ualberta.counter;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Activity in which a Counter can be renamed.
 */

public class RenameActivity extends CounterListActivity {

	private Button create;
	private EditText inputName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rename_counter);
		getActionBar().setTitle(getActiveCounter().getName());
		getActionBar().setDisplayHomeAsUpEnabled (true);
		inputName = (EditText) findViewById(R.id.inputName);
		create = (Button) findViewById(R.id.confirmName);
		inputName.setHint(getActiveCounter().getName());
		create.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = inputName.getText().toString();
				getActiveCounter().setName(name);
				saveCounterList();
				finish();
			}
		} );
	}
	
	//Makes ActionBar back button behave as physical back button
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
        	onBackPressed();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
