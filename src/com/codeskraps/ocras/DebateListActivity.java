package com.codeskraps.ocras;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class DebateListActivity extends ListActivity {
	private static final String TAG = DebateListActivity.class.getSimpleName();
	
	private static final String ITEM_KEY = "key";
	private ArrayList<HashMap<String, String>> debateList = new ArrayList<HashMap<String, String>>();
	private OcrasData oData = null;
	private SimpleAdapter adapter;
	private TextView txtTitle =  null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate started");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_list);
		
		String[] arr_debates = (getResources()).getStringArray(R.array.arr_debate);
		oData = ((OcrasApplication) getApplication()).getoData();
		
		for (String w : arr_debates) {
			HashMap<String, String> item = new HashMap<String, String>();
			item.put(ITEM_KEY, w);
			debateList.add(item);
		}
		
		adapter = new SimpleAdapter(this, debateList, R.layout.debate_list_item,
				new String[] { ITEM_KEY }, new int[] { R.id.txtRow });

		setListAdapter(adapter);
		
		txtTitle = (TextView) findViewById(R.id.txtListTitle);
		txtTitle.setText(R.string.listacitivity_debate);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		oData.setDebateClicked(position);
		DebateListActivity.this.startActivity(new Intent(DebateListActivity.this, DebateActivity.class));
	}
}