package com.codeskraps.ocras;

import com.codeskraps.ocras.OcrasApplication;
import com.codeskraps.ocras.OcrasData;
import com.codeskraps.ocras.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DebateActivity extends Activity {
	private static final String TAG = DebateActivity.class.getSimpleName();
	
	private OcrasData oData =  null;
	private String[] arr_content;
	private TextView txtTitle = null;
	private TextView txtChair =  null;
	private TextView txtSynop = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreated Started");
		
		setContentView(R.layout.debates);
		
		oData = ((OcrasApplication) getApplication()).getoData();
		
		Log.d(TAG, "onCreated id: " + oData.getDebateClicked());
		
		txtTitle = (TextView) findViewById(R.id.txtDebateTitle);
		txtChair = (TextView) findViewById(R.id.txtDebateChair);
		txtSynop = (TextView) findViewById(R.id.txtDebateSynopsis);
		
		switch(oData.getDebateClicked()){
			case 0: arr_content = (getResources()).getStringArray(R.array.arr_gmf); break;
			case 1: arr_content = (getResources()).getStringArray(R.array.arr_nutrition); break;
			case 2: arr_content = (getResources()).getStringArray(R.array.arr_obesity); break;
			case 3: arr_content = (getResources()).getStringArray(R.array.arr_developing); break;
			case 4: arr_content = (getResources()).getStringArray(R.array.arr_tourism); break;
			case 5: arr_content = (getResources()).getStringArray(R.array.arr_agriculture); break;
			case 6: arr_content = (getResources()).getStringArray(R.array.arr_fisheries);	break;
			case 7:	arr_content = (getResources()).getStringArray(R.array.arr_safety);	break;
		}
		
		txtTitle.setText(arr_content[0]);
		txtChair.setText(arr_content[1]);
		txtSynop.setText(arr_content[2]);
	}
}