package com.example.falcontesting;

import com.example.falcontesting.fragments.AddRequestFormFragment;

import android.os.Bundle;


public class AddRequestActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_request_layout);
		fetchDetails();
	}
	
	private void fetchDetails() {
		getFragmentManager().beginTransaction().add(R.id.main_add_request_content, new AddRequestFormFragment()).commit();
		getFragmentManager().beginTransaction().add(R.id.main_add_request_content, new AddRequestFormFragment()).commit();
		getFragmentManager().beginTransaction().add(R.id.main_add_request_content, new AddRequestFormFragment()).commit();
		getFragmentManager().beginTransaction().add(R.id.main_add_request_content, new AddRequestFormFragment()).commit();
	}
	
}
