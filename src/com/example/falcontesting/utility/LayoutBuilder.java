package com.example.falcontesting.utility;

import com.example.falcontesting.R;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.widget.LinearLayout;

/**
 * @author anand This class is for the purpose of generating view groups. A
 *         separate class has been made instead of adding it to UIBuilder for
 *         better code maintainence.
 */
public class LayoutBuilder {

	public static LinearLayout createBasicLinearLayout(Activity activity) {
		LinearLayout linearLayout = new LinearLayout(activity);
		return linearLayout;
	}

	public static LinearLayout createStandardFalconLinearLayout(
			Activity activity) {
		LinearLayout tmpLinearLayout = createBasicLinearLayout(activity);
		tmpLinearLayout.setOrientation(LinearLayout.VERTICAL);
		tmpLinearLayout.setPadding(10, 10, 10, 10);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		params.setMargins(5, 5, 5, 5);
		tmpLinearLayout.setLayoutParams(params);
		tmpLinearLayout.setBackgroundColor(activity.getResources().getColor(
				R.color.white));
		return tmpLinearLayout;
	}
}
