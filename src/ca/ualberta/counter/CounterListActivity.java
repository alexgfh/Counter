package ca.ualberta.counter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.content.Context;

/**
 * Superclass of all activities of the application, provides
 * access to the Counter List, and resources for saving.
 * The rationale for this was that any Activity has access
 * to the List and can tell it to load and save, with no need to
 * provide input and output.
 * Also, this was necessary because in Android, a context
 * is needed to deal with files.
 */

public class CounterListActivity extends Activity {
	
	private static CounterListModel counterList;
	private static int activeCounterIndex;
	private static final String FILENAME = "file.sav";
	
	protected final void saveCounterList() {
		try  {
			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(counterList);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected final void loadCounterList() {
		CounterListModel counterList = null;
		try {
			FileInputStream fis = openFileInput(FILENAME);
			ObjectInputStream is = new ObjectInputStream(fis);
			counterList = (CounterListModel) is.readObject();
			is.close();
		} catch(FileNotFoundException e) {
			android.util.Log.i("main", "No file, creating new CounterList");
			counterList = new CounterListModel();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		CounterListActivity.counterList=counterList;
	}
	
	/*
	 * The Active Counter can be get and set,
	 * through this, activities can know
	 * which counter to read and manipulate.
	 */
	protected static final CounterModel getActiveCounter() {
		return counterList.getCounterAtIndex(activeCounterIndex);
	}
	
	protected static final void setActiveCounter(int index) {
		activeCounterIndex = index;
	}
	
	protected static final void removeActiveCounter() {
		counterList.removeCounter(activeCounterIndex);
	}
	
	protected static final CounterListModel getCounterList(){
		return counterList;
	}
	
}
