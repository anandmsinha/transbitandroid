package com.example.falcontesting.utility;

/**
 * @author anand - Later on we will replace this class with a json file which will
 *         be fetched from the server as in case ui components meanings change
 *         it will get difficult to maintain across all devices.
 */
public class UiConstants {

	// Type of the field for the form
	public static final String FIELD_TYPE = "type";
	
	// default field name assigned in case no field type is returned in json
	public static final String DEFAULT_FIELD_TYPE = "defaultField";
	
	// spinner type field
	public static final String FIELD_SPINNER = "spinnerField";
	
	// single file upload field
	public static final String FIELD_FILE_UPLOAD = "fileUploadField";
	
	// generally text on buttons etc.
	public static final String FIELD_DISPLAY_NAME = "displayName";
	
	// field options - other details about field
	public static final String FIELD_OPTIONS = "options";
	
	// if no field options are specified use this string.
	public static final String FIELD_OPTIONS_DEFAULT = "none";
	
	// separator used to separate multiple options in field options.
	public static final String FIELD_OPTIONS_SEPARATOR = "__";
	
	public static final String DEFAULT_FILE_UPLOAD_MESSAGE = "Upload file";
}
