package com.example.falcontesting;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.falcontesting.utility.JsonUtility;
import com.example.falcontesting.utility.LayoutBuilder;
import com.example.falcontesting.utility.UiBuilder;
import com.example.falcontesting.utility.UiConstants;

public class AddRequestActivity extends BaseActivity {
	
	private static final String TAG = "JsonUtility";
	
	private LinearLayout mainActivityContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_request_layout);

		mainActivityContent = (LinearLayout) findViewById(R.id.main_add_request_content);
		fetchDetails();
	}

	private void fetchDetails() {
		// getFragmentManager().beginTransaction().add(R.id.main_add_request_content,
		// new AddRequestFormFragment()).commit();
		String formJson = "{\r\n\t\t  \"subject\": {\r\n\t\t    \"type\": \"textField\"\r\n\t\t  },\r\n\t\t  \"logger\": {\r\n\t\t    \"type\": \"spinnerField\",\r\n\t\t    \"options\": \"anand__anant__rahul__random__yo\"\r\n\t\t  },\r\n\t\t  \"assigne\": {\r\n\t\t    \"type\": \"spinnerField\",\r\n\t\t    \"options\": \"anand__anant__rahul__random__yo\"\r\n\t\t  },\r\n\t\t  \"Attachements\": {\r\n\t\t    \"type\": \"fileUploadField\",\r\n\t\t    \"displayName\": \"Upload file\"\r\n\t\t  }\r\n\t\t}";
		HashMap<String, HashMap<String, String>> formData = JsonUtility.getInFormHashHashMap(formJson);
		Log.d(TAG, "Size for the form " + formData.size());
		mainActivityContent.addView(createFormBlockFromMap(formData, "Properties"));
	}

	public LinearLayout createFormBlockFromMap(
			HashMap<String, HashMap<String, String>> elements, String parent) {
		LinearLayout mainLayout = LayoutBuilder
				.createStandardFalconLinearLayout(this);
		mainLayout.addView(UiBuilder.createBoldTextView(this, parent));
		for (Map.Entry<String, HashMap<String, String>> entry : elements
				.entrySet()) {
			// switch has not been used here to keep backward java versions
			// support
			HashMap<String, String> fieldProperties = entry.getValue();
			String fieldType = (fieldProperties
					.containsKey(UiConstants.FIELD_TYPE)) ? fieldProperties
					.get(UiConstants.FIELD_TYPE)
					: UiConstants.DEFAULT_FIELD_TYPE;
			mainLayout.addView(UiBuilder.createTextView(this, entry.getKey()));
			View formComponent;
			if (fieldType.equals(UiConstants.FIELD_SPINNER)) {
				String spinnerOptions = (fieldProperties
						.containsKey(UiConstants.FIELD_OPTIONS)) ? fieldProperties
						.get(UiConstants.FIELD_OPTIONS)
						: UiConstants.FIELD_OPTIONS_DEFAULT;
				formComponent = UiBuilder.createSpinner(this, spinnerOptions
						.split(UiConstants.FIELD_OPTIONS_SEPARATOR));
			} else if (fieldType.equals(UiConstants.FIELD_FILE_UPLOAD)) {
				String uploadButtonText = (fieldProperties
						.containsKey(UiConstants.FIELD_DISPLAY_NAME)) ? fieldProperties
						.get(UiConstants.FIELD_DISPLAY_NAME)
						: UiConstants.DEFAULT_FILE_UPLOAD_MESSAGE;
				formComponent = UiBuilder.createButton(this, uploadButtonText);
			} else {
				formComponent = UiBuilder.createEditText(this);
			}
			mainLayout.addView(formComponent);
		}
		return mainLayout;
	}
}
