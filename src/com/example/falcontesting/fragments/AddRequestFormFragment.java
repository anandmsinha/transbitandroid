package com.example.falcontesting.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.falcontesting.R;
import com.example.falcontesting.utility.UiBuilder;

public class AddRequestFormFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle args) {
		View view = inflater.inflate(R.layout.add_request_form_fragment, container, false);
		LinearLayout tmpLinearLayout = (LinearLayout) view.findViewById(R.id.add_req_form_frag_layout);
		Activity tmpActivity = getActivity();
		TextView tmpBoldTextView = UiBuilder.createBoldTextView(tmpActivity, "Properties");
		tmpBoldTextView.setPadding(0, 0, 0, 10);
		tmpLinearLayout.addView(tmpBoldTextView);
		tmpLinearLayout.addView(UiBuilder.createTextView(tmpActivity, "Subject"));
		tmpLinearLayout.addView(UiBuilder.createEditText(tmpActivity));
		tmpLinearLayout.addView(UiBuilder.createTextView(tmpActivity, "Logger"));
		String [] loggers = new String[] {"", "anand.s", "anant.s", "ramkrishna"};
		tmpLinearLayout.addView(UiBuilder.createSpinner(tmpActivity, loggers));
		tmpLinearLayout.addView(UiBuilder.createTextView(tmpActivity, "Assigne"));
		tmpLinearLayout.addView(UiBuilder.createSpinner(tmpActivity, loggers));
		tmpLinearLayout.addView(UiBuilder.createTextView(tmpActivity, "Attachements"));
		tmpLinearLayout.addView(UiBuilder.createButton(tmpActivity, "Select files"));
		return view;
	}
	
}
