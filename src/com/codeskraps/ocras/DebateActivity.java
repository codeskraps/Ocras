package com.codeskraps.ocras;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

public class DebateActivity extends ListActivity {
	private static final String TAG = DebateActivity.class.getSimpleName();
	
	private CustomListAdapter listItemAdapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate started");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_activity);
		
		String[] arr_debates = (getResources()).getStringArray(R.array.arr_debate);
		Log.d(TAG, "after getting arr_debate");
		
		listItemAdapter = new CustomListAdapter(this);
		setListAdapter(listItemAdapter);
		
		for(String s : arr_debates)
        {
        	listItemAdapter.addItem(new ListItem(s));
        	Log.d(TAG, "Adding: " + s);
        }
	}
}