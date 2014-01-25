package ca.ualberta.counter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RenameActivity extends Activity {

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
				CounterBrowserActivity.getActiveCounter().setName(name);
				finish();
			}
		} );
	}
}
