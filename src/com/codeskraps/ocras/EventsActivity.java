package com.codeskraps.ocras;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AnalogClock;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EventsActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.event);
		int id = 0;
		
		/*
		 * Debates
		 */
		ViewGroup layoutDebate = (ViewGroup) findViewById(R.id.linearDebate);
		String[] arr_layouts = (getResources()).getStringArray(R.array.arr_debate);
		
		for (String w : arr_layouts) {

			LinearLayout lContainer = new LinearLayout(this);
			lContainer.setOrientation(LinearLayout.HORIZONTAL);
			lContainer.setLayoutParams(new LayoutParams(140, 140));
			if(id==0 || id==3 || id==6 || id==9){
				lContainer.setBackgroundResource(R.drawable.debate_background_1);
			}else if(id==1 || id==4 || id==7){
				lContainer.setBackgroundResource(R.drawable.debate_background_2);
			}else{
				lContainer.setBackgroundResource(R.drawable.debate_background_3);
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
			
			layoutDebate.addView(lContainer);
			lContainer.addView(lColor);
			lContainer.addView(lText);
			lText.addView(tv);
		}
		
		/*
		 * Talks
		 */
		ViewGroup layout_talk = (ViewGroup) findViewById(R.id.linearTalk);
		String[] arr_talk = (getResources()).getStringArray(R.array.arr_talk);
		
		for (String w : arr_talk) {

			LinearLayout lContainer = new LinearLayout(this);
			lContainer.setOrientation(LinearLayout.HORIZONTAL);
			lContainer.setLayoutParams(new LayoutParams(140, 140));
			if(id==8 || id==11 ){
				lContainer.setBackgroundResource(R.drawable.talk_background_1);
			}else if(id==9 || id==12 ){
				lContainer.setBackgroundResource(R.drawable.talk_background_2);
			}else{
				lContainer.setBackgroundResource(R.drawable.talk_background_3);
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
			//tv.setOnClickListener(this);
			tv.setBackgroundResource(R.color.text_background);
			id++;
			
			layout_talk.addView(lContainer);
			lContainer.addView(lColor);
			lContainer.addView(lText);
			lText.addView(tv);
		}
		
		/*
		 * Taste
		 */
		ViewGroup layout_taste = (ViewGroup) findViewById(R.id.linearTaste);
		String[] arr_taste = (getResources()).getStringArray(R.array.arr_taste);
		
		for (String w : arr_taste) {

			LinearLayout lContainer = new LinearLayout(this);
			lContainer.setOrientation(LinearLayout.HORIZONTAL);
			lContainer.setLayoutParams(new LayoutParams(140, 140));
			if(id==14 || id==17 ){
				lContainer.setBackgroundResource(R.drawable.taste_background_1);
			}else if(id==15 || id==18 ){
				lContainer.setBackgroundResource(R.drawable.taste_background_2);
			}else{
				lContainer.setBackgroundResource(R.drawable.taste_background_3);
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
			//tv.setOnClickListener(this);
			tv.setBackgroundResource(R.color.text_background);
			id++;
			
			layout_taste.addView(lContainer);
			lContainer.addView(lColor);
			lContainer.addView(lText);
			lText.addView(tv);
		}
	}

	@Override
	public void onClick(View v) {
		Toast.makeText(this, "id: " + v.getId(), Toast.LENGTH_SHORT).show();
	}

}
