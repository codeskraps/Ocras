package com.codeskraps.ocras;

import android.app.Activity;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.TextView;

public class ContentActivity extends Activity implements OnClickListener {
	
	private OcrasData oData = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		oData = ((OcrasApplication) getApplication()).getoData();
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
                WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        
        setContentView(R.layout.debate_content);
        
        if (oData.isDebate()) showDebate();
        else showNotDebate();
	}
	
	private void showDebate() {
		String[] arr_content = oData.getArr_content();
		
		TextView textTitle = (TextView) findViewById(R.id.content_text_debate_title);
        TextView textGuess = (TextView) findViewById(R.id.content_text_debate_guess);
        TextView textSummary = (TextView) findViewById(R.id.content_text_debate_summary);
        
        textTitle.setText(arr_content[0]);
        textGuess.setText(arr_content[1]);
        textSummary.setText(arr_content[2]);
        
        TextView btnOk = (TextView) findViewById(R.id.content_ok);
        btnOk.setOnClickListener(this);
	}
	
	private void showNotDebate() {
		String[] arr_content = oData.getArr_content();
		
		TextView textTitle = (TextView) findViewById(R.id.content_text_debate_title);
        TextView textGuess = (TextView) findViewById(R.id.content_text_debate_guess);
        TextView textSummary = (TextView) findViewById(R.id.content_text_debate_summary);
        
        textGuess.setVisibility(View.GONE);
        
        textTitle.setText(arr_content[0]);
        //textGuess.setText(arr_content[1]);
        textSummary.setText(arr_content[1]);
        
        TextView btnOk = (TextView) findViewById(R.id.content_ok);
        btnOk.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		this.finish();
	}

}
