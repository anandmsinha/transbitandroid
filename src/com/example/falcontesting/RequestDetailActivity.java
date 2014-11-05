package com.example.falcontesting;

import android.os.Bundle;

public class RequestDetailActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.request_details);
		fetchDetails();
	}
	
	private void fetchDetails() {
		
	}
}
