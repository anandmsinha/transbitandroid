package com.example.falcontesting.utility;

import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JsonUtility {
	
	private static final String TAG = "JsonUtility";
	
	public static HashMap<String, HashMap<String, String>> getInFormHashHashMap(
			String jsonData) {
		HashMap<String, HashMap<String, String>> data = new HashMap<String, HashMap<String, String>>();
		try {
			JSONObject jsonObject = new JSONObject(jsonData);
			Iterator<String> it = jsonObject.keys();
			while (it.hasNext()) {
				String key = it.next();
				data.put(key,
						loopThroghJsonObject(jsonObject.getJSONObject(key)));
			}
		} catch (Exception e) {
			// Here we are catching exception instead of JsonObjectException
			// because getJsonObject can throw JSONException exception.
			Log.e(TAG, "Exception while parsing json - " + e.getMessage());
		}

		return data;
	}

	private static HashMap<String, String> loopThroghJsonObject(JSONObject jsonObject) throws JSONException {
		HashMap<String, String> output = new HashMap<String, String>();
		if (jsonObject != null) {
			Iterator<String> it = jsonObject.keys();
			while (it.hasNext()) {
				String key = it.next();
				output.put(key, jsonObject.get(key).toString());
			}
		}
		return output;
	}
}
