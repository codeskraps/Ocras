package com.codeskraps.ocras;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EventsActivity extends Activity implements OnClickListener {
	private static final String TAG = EventsActivity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.event);
		
		/*
		 * Debates
		 */
		ViewGroup layout_theme = (ViewGroup) findViewById(R.id.linearDebate);
		String[] arr_theme = (getResources()).getStringArray(R.array.arr_debate);
		ArrayList<Integer> arrImages = new ArrayList<Integer>();
		arrImages.add(R.drawable.debate_background_1);
		arrImages.add(R.drawable.debate_background_2);
		arrImages.add(R.drawable.debate_background_3);
		
		fillLayout(0, layout_theme, arr_theme, arrImages);
		
		/*
		 * Talks
		 */
		layout_theme = (ViewGroup) findViewById(R.id.linearTalk);
		arr_theme = (getResources()).getStringArray(R.array.arr_talk);
		
		arrImages.clear();
		arrImages.add(R.drawable.talk_background_1);
		arrImages.add(R.drawable.talk_background_2);
		arrImages.add(R.drawable.talk_background_3);
		
		fillLayout(8, layout_theme, arr_theme, arrImages);
		
		
		/*
		 * Taste
		 */
		layout_theme = (ViewGroup) findViewById(R.id.linearTaste);
		arr_theme = (getResources()).getStringArray(R.array.arr_taste);
		
		arrImages.clear();
		arrImages.add(R.drawable.taste_background_1);
		arrImages.add(R.drawable.taste_background_2);
		arrImages.add(R.drawable.taste_background_3);
		
		fillLayout(14, layout_theme, arr_theme, arrImages);

	}
	
	private void fillLayout (int id, ViewGroup layout_theme, String[] arr_theme,
			ArrayList<Integer> arrImages) {
				
		for (String w : arr_theme) {

			LinearLayout lContainer = new LinearLayout(this);
			lContainer.setOrientation(LinearLayout.HORIZONTAL);
			lContainer.setLayoutParams(new LayoutParams(140, 140));
			if(id==0 || id==3 || id==6 || id==8 || id==11 || id==14 || id==17){
				lContainer.setBackgroundResource(arrImages.get(0));
			}else if(id==1 || id==4 || id==9 || id==12 || id==15 || id==18){
				lContainer.setBackgroundResource(arrImages.get(1));
			}else{
				lContainer.setBackgroundResource(arrImages.get(2));
			}
			
			LinearLayout lColor = new LinearLayout(this);
			lColor.setOrientation(LinearLayout.VERTICAL);
			lColor.setLayoutParams(new LayoutParams(10, LayoutParams.FILL_PARENT));
			lColor.setBackgroundResource(R.color.debate_background);
			
			LinearLayout lText = new LinearLayout(this);
			lText.setOrientation(LinearLayout.HORIZONTAL);
			lText.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
			lText.setGravity(Gravity.BOTTOM);
			lText.setId(id);
			lText.setOnClickListener(this);
			
			TextView tv = new TextView(this);
			tv.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			tv.setPadding(5, 5, 5, 5);
			tv.setText(w);
			tv.setId(id);
//			tv.setOnClickListener(this);
			tv.setBackgroundResource(R.color.text_background);
			id++;
			
			layout_theme.addView(lContainer);
			lContainer.addView(lColor);
			lContainer.addView(lText);
			lText.addView(tv);
		}
	}

	@Override
	public void onClick(View v) {
		//Toast.makeText(this, "id: " + v.getId(), Toast.LENGTH_SHORT).show();
	
		Log.d(TAG, "id: " + v.getId());
		
		showDialog(v.getId());
	}

	@Override
    protected Dialog onCreateDialog(int id) {

		Resources res = getResources();
		
		switch (id) {
       	
		// Debate
		case 0: return getDebateDialog(res.getStringArray(R.array.arr_gmf));
       	case 1: return getDebateDialog(res.getStringArray(R.array.arr_nutrition));
       	case 2: return getDebateDialog(res.getStringArray(R.array.arr_obesity));
       	case 3: return getDebateDialog(res.getStringArray(R.array.arr_developing));
       	case 4: return getDebateDialog(res.getStringArray(R.array.arr_tourism));
       	case 5: return getDebateDialog(res.getStringArray(R.array.arr_agriculture));
       	case 6: return getDebateDialog(res.getStringArray(R.array.arr_fisheries));
       	case 7: return getDebateDialog(res.getStringArray(R.array.arr_safety));
       	
       	// Talk
       	case 8: return getDialog(res.getString(R.string.talk_title1), res.getString(R.string.talk_synop1));
       	case 9: return getDialog(res.getString(R.string.talk_title2), res.getString(R.string.talk_synop2));
       	case 10: return getDialog(res.getString(R.string.talk_title3), res.getString(R.string.talk_synop3));
       	case 11: return getDialog(res.getString(R.string.talk_title4), res.getString(R.string.talk_synop4));
       	case 12: return getDialog(res.getString(R.string.talk_title5), res.getString(R.string.talk_synop5));
       	case 13: return getDialog(res.getString(R.string.talk_title6), res.getString(R.string.talk_synop6));
       	
       	// Taste
       	case 14: return getDialog(res.getString(R.string.taste_title1), res.getString(R.string.taste_synop1));
       	case 15: return getDialog(res.getString(R.string.taste_title2), res.getString(R.string.taste_synop2));
       	case 16: return getDialog(res.getString(R.string.taste_title3), res.getString(R.string.taste_synop3));
       	case 17: return getDialog(res.getString(R.string.taste_title4), res.getString(R.string.taste_synop4));
       	case 18: return getDialog(res.getString(R.string.taste_title5), res.getString(R.string.taste_synop5));
       	
       	default: return null;
		}
	}
	
	private AlertDialog getDebateDialog(String[] arr_layouts) {
		   		
		LayoutInflater inflater = (LayoutInflater) EventsActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.custom_debate_dialog, (ViewGroup) findViewById(R.id.layout_debate_root));

		AlertDialog.Builder builder = new AlertDialog.Builder(EventsActivity.this);
   		builder.setView(layout);
   		AlertDialog alertDialog = builder.create();
   		
   		TextView text_guess = (TextView) layout.findViewById(R.id.dialog_text_debate_guess);
   		text_guess.setText(arr_layouts[1]);
   		
   		TextView text_summary = (TextView) layout.findViewById(R.id.dialog_text_debate_summary);
   		text_summary.setText(arr_layouts[2]);
   		
   		alertDialog.setTitle(arr_layouts[0]);
   		alertDialog.setButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                /* User clicked OK so do some stuff */
            }
        });
   		
   		return alertDialog;
	}
	
	private AlertDialog getDialog(String s_title, String s_summary) {
   		
		LayoutInflater inflater = (LayoutInflater) EventsActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.custom_dialog, (ViewGroup) findViewById(R.id.layout_root));

		AlertDialog.Builder builder = new AlertDialog.Builder(EventsActivity.this);
   		builder.setView(layout);
   		AlertDialog alertDialog = builder.create();
   		
   		TextView text_summary = (TextView) layout.findViewById(R.id.dialog_text_summary);
   		text_summary.setText(s_summary);
   		
   		alertDialog.setTitle(s_title);
   		alertDialog.setButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                /* User clicked OK so do some stuff */
            }
        });
   		
   		return alertDialog;
	}
}
