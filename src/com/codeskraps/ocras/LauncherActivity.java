package com.codeskraps.ocras;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class LauncherActivity extends Activity implements OnClickListener {
	private static final String TAG = LauncherActivity.class.getSimpleName();
	
	private ImageView btnDebate = null;
	private ImageView btnTalk = null;
	private ImageView btnFood = null;
	private ImageView btnChildren = null;
	private ImageView btnMarket = null;
	private ImageView btnCommunity = null;
	private ImageView btnAward = null;
	private ImageView btnFeast = null;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);
    
        btnDebate = (ImageView) findViewById(R.id.img_debate);
        btnTalk = (ImageView) findViewById(R.id.img_talk);
        btnFood = (ImageView) findViewById(R.id.img_food);
        btnChildren = (ImageView) findViewById(R.id.img_children);
        btnMarket = (ImageView) findViewById(R.id.img_market);
        btnCommunity = (ImageView) findViewById(R.id.img_community);
        btnAward = (ImageView) findViewById(R.id.img_award);
        btnFeast = (ImageView) findViewById(R.id.img_feast);
        
        btnDebate.setOnClickListener(this);
        btnTalk.setOnClickListener(this);
        btnFood.setOnClickListener(this);
        btnChildren.setOnClickListener(this);
        btnMarket.setOnClickListener(this);
        btnCommunity.setOnClickListener(this);
        btnAward.setOnClickListener(this);
        btnFeast.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.img_debate:		LauncherActivity.this.startActivity(new Intent(LauncherActivity.this, DebateListActivity.class)); break;
		case R.id.img_talk:			LauncherActivity.this.startActivity(new Intent(LauncherActivity.this, TalksListAcitivity.class)); break;
		case R.id.img_food:			LauncherActivity.this.startActivity(new Intent(LauncherActivity.this, TasteListActivity.class));  break;
		case R.id.img_children:
			break;
		case R.id.img_market:
			break;
		case R.id.img_community:
			break;
		case R.id.img_award:
			break;
		case R.id.img_feast:		LauncherActivity.this.startActivity(new Intent(LauncherActivity.this, MapViewActivity.class));  break;
		}
	}
}