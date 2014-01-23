package ca.ualberta.counter;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CounterBrowserActivity extends ListActivity {

	private String[] counterNames;
	private ArrayAdapter<String> listViewAdapter;

	private void updateList() {
		if (counterNames == null || counterNames.length != CounterList.getCounters().size()) {
			counterNames = new String[CounterList.getCounters().size()];
		}
		for (int i = 0; i < CounterList.getCounters().size(); i++) {
			counterNames[i]=CounterList.getCounters().get(i).getName();
		}
		listViewAdapter.notifyDataSetChanged();
	}
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		counterNames = new String[CounterList.getCounters().size()];
		listViewAdapter = new ArrayAdapter<String>(CounterBrowserActivity.this,
				android.R.layout.simple_list_item_1, counterNames);
		setListAdapter(listViewAdapter);
	}

	@Override
	protected void onResume() {
		super.onResume();
		this.updateList();
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		CounterList.setCurrentIndex(position);
		startActivity(new Intent("android.intent.action.COUNTER"));
	}

}