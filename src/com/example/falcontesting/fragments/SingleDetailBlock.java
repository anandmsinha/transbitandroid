package com.example.falcontesting.fragments;

import com.example.falcontesting.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingleDetailBlock extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle args) {
		View view = inflater.inflate(R.layout.single_detail_fragment, container, false);
		LinearLayout mainLinearLayout = (LinearLayout) view.findViewById(R.id.single_detail_frag);
		Activity tmpActivity = getActivity();
		final TextView titleBlockTextView = new TextView(tmpActivity);
		titleBlockTextView.setText("Properties");
		mainLinearLayout.addView(titleBlockTextView);
		return view;
	}
	
	private View getHorizontalBorder(Activity activity) {
		LayoutParams tmpLayoutParams = new LayoutParams(-1, R.dimen.two_vm);
		View view = new View(activity);
		view.setLayoutParams(tmpLayoutParams);
		view.setBackgroundColor(getResources().getColor(R.color.black));
		return view;
	}
}
