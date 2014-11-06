package com.example.falcontesting.utility;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author anand - Main class to create ui elements. Use these function wherever
 *         possible. As it will make maintaing the code much easier. If adding
 *         new methods make sure they are public and static.
 */
public class UiBuilder {

	public static TextView createTextView(Activity activity, String text) {
		TextView tmpTextView = new TextView(activity);
		tmpTextView.setText(text);
		tmpTextView.setTextSize(14);
		return tmpTextView;
	}

	public static TextView createBoldTextView(Activity activity, String text) {
		TextView tmpTextView = createTextView(activity, text);
		tmpTextView.setTextSize(16);
		tmpTextView.setTypeface(null, Typeface.BOLD);
		return tmpTextView;
	}

	public static EditText createEditText(Activity activity) {
		EditText tmpEditText = new EditText(activity);
		tmpEditText.setSingleLine();
		return tmpEditText;
	}

	public static Spinner createSpinner(Activity activity, String[] elements) {
		Spinner spinner = new Spinner(activity);
		spinner.setAdapter(new ArrayAdapter<String>(activity,
				android.R.layout.simple_spinner_dropdown_item, elements));
		return spinner;
	}
	
	public static Button createButton(Activity activity, String text) {
		Button button = new Button(activity);
		button.setText(text);
		return button;
	}

}
