package com.example.falcontesting;

import com.example.falcontesting.fragments.SingleDetailBlock;

import android.os.Bundle;

public class RequestDetailActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.request_details);
		fetchDetails();
	}

	private void fetchDetails() {
		if (getFragmentManager().findFragmentById(android.R.id.content) == null) {
			getFragmentManager().beginTransaction().add(android.R.id.content, new SingleDetailBlock()).commit();
		}
	}
}
