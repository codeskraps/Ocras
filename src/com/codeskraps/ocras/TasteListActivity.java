package com.codeskraps.ocras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class TasteListActivity extends ListActivity {
	private static final String TAG = TalksListAcitivity.class.getSimpleName();

	private static final String ITEM_TITLE = "title";
	private static final String ITEM_SYNOP = "synop";
	private List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
	private OcrasData oData = null;
	private SimpleAdapter adapter;
	private TextView txtTitle =  null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate started");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_list);
		
		oData = ((OcrasApplication) getApplication()).getoData();
		
		String[] from = new String[] { ITEM_TITLE, ITEM_SYNOP };
		int[] to = new int[] { R.id.txtTitle, R.id.txtSynop };
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(ITEM_TITLE, getString(R.string.taste_title1));
		map.put(ITEM_SYNOP, getString(R.string.taste_synop1));
		fillMaps.add(map);
		
		map = new HashMap<String, String>();
		map.put(ITEM_TITLE, getString(R.string.taste_title2));
		map.put(ITEM_SYNOP, getString(R.string.taste_synop2));
		fillMaps.add(map);
		
		map = new HashMap<String, String>();
		map.put(ITEM_TITLE, getString(R.string.taste_title3));
		map.put(ITEM_SYNOP, getString(R.string.taste_synop3));
		fillMaps.add(map);
		
		map = new HashMap<String, String>();
		map.put(ITEM_TITLE, getString(R.string.taste_title4));
		map.put(ITEM_SYNOP, getString(R.string.taste_synop4));
		fillMaps.add(map);
		
		map = new HashMap<String, String>();
		map.put(ITEM_TITLE, getString(R.string.taste_title5));
		map.put(ITEM_SYNOP, getString(R.string.taste_synop5));
		fillMaps.add(map);
		
		adapter = new SimpleAdapter(this, fillMaps, R.layout.custom_list_item, from, to);

		setListAdapter(adapter);
		
		txtTitle = (TextView) findViewById(R.id.txtListTitle);
		txtTitle.setText(R.string.listacitivity_talk);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		//oData.setDebateClicked(position);
		//TalksListAcitivity.this.startActivity(new Intent(TalksListAcitivity.this, DebateActivity.class));
	}
}
