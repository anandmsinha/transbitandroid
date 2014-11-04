package com.example.falcontesting.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.falcontesting.R;

public class DetailFragment extends Fragment {

	private TextView mTextView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle args) {
		View view = inflater.inflate(R.layout.menu_details_fragment, container,
				false);
		String menu = getArguments().getString("Menu");
		mTextView = (TextView) view.findViewById(R.id.detail);
		mTextView.setText(menu);
		return view;
	}

}
