package com.example.falcontesting.fragments;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.falcontesting.R;
import com.example.falcontesting.utility.UiBuilder;

public class SingleDetailBlock extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle args) {
		View view = inflater.inflate(R.layout.single_detail_fragment, container, false);
		LinearLayout mainLinearLayout = (LinearLayout) view.findViewById(R.id.single_detail_frag);
		Activity tmpActivity = getActivity();
		final TextView titleBlockTextView = UiBuilder.createBoldTextView(tmpActivity, "Properties");
		mainLinearLayout.addView(titleBlockTextView);
		HashMap<String, String> testHashMap = new HashMap<String, String>();
		testHashMap.put("Private", "True");
		testHashMap.put("Last updated by", "Ritesh tripathi");
		testHashMap.put("Last Updated", "15-Sep-2014 IST");
		testHashMap.put("Parent", "None");
		StringBuilder tmpStringBuilder = new StringBuilder();
		tmpStringBuilder.append("<br />");
		for (Map.Entry<String, String> entry : testHashMap.entrySet()) {
			tmpStringBuilder.append("<p><b>");
			tmpStringBuilder.append(entry.getKey() + " </b> : ");
			tmpStringBuilder.append(entry.getValue() + "</p>");
		}
		TextView detailsTextView = new TextView(tmpActivity);
		detailsTextView.setText(Html.fromHtml(tmpStringBuilder.toString()));
		mainLinearLayout.addView(detailsTextView);
		return view;
	}
	
	public View getHorizontalBorder(Activity activity) {
		LayoutParams tmpLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, 2);
		View view = new View(activity);
		view.setLayoutParams(tmpLayoutParams);
		view.setBackgroundColor(getResources().getColor(R.color.black));
		return view;
	}
	
}
