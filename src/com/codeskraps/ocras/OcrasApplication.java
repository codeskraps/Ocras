package com.codeskraps.ocras;

import android.app.Application;

public class OcrasApplication extends Application {
	
	private OcrasData oData = null;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		setoData(new OcrasData());
	}

	public OcrasData getoData() {
		return oData;
	}

	public void setoData(OcrasData oData) {
		this.oData = oData;
	}
}