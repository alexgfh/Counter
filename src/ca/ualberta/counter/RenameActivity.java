package ca.ualberta.counter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*
 * Activity in which a Counter can be created.
 * Uses the same GUI layout of CreateCounter.
 */

public class RenameActivity extends CounterListActivity {

	private Button create;
	private EditText inputName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_name_counter);
		inputName = (EditText) findViewById(R.id.inputName);
		create = (Button) findViewById(R.id.confirmName);
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
}
