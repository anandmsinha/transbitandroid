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
		getFragmentManager().beginTransaction().add(R.id.main_details_view, new SingleDetailBlock()).commit();
		getFragmentManager().beginTransaction().add(R.id.main_details_view, new SingleDetailBlock()).commit();
		getFragmentManager().beginTransaction().add(R.id.main_details_view, new SingleDetailBlock()).commit();
	}
}
