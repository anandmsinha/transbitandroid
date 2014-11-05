package com.example.falcontesting.adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class FalconExpandableListAdapter extends BaseExpandableListAdapter {

	LayoutInflater layoutInflater;
	Map<String, ArrayList<String>> menuGroupItems;
	List<String> groups;

	public FalconExpandableListAdapter(LayoutInflater inflater,
			List<String> groups, Map<String, ArrayList<String>> groupItems) {
		this.layoutInflater = inflater;
		this.menuGroupItems = groupItems;
		this.groups = groups;
	}

	@Override
	public int getGroupCount() {
		return this.groups.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		try {
			return this.menuGroupItems.get(this.groups.get(groupPosition))
					.size();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Object getGroup(int groupPosition) {
		return this.groups.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		try {
			return this.menuGroupItems.get(this.groups.get(groupPosition)).get(
					childPosition);
		} catch (Exception e) {
			return "Exception";
		}
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return groupPosition * 1024 + childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		if (convertView == null) {
			int tmpLayoutElement = (getChildrenCount(groupPosition) == 0) ? android.R.layout.simple_selectable_list_item
					: android.R.layout.simple_expandable_list_item_1;
			convertView = layoutInflater.inflate(tmpLayoutElement, parent,
					false);
		}
		TextView tmpTextView = (TextView) convertView
				.findViewById(android.R.id.text1);
		tmpTextView.setText(getGroup(groupPosition).toString());
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = layoutInflater.inflate(
					android.R.layout.simple_list_item_1, parent, false);
		}
		TextView tmpTextView = (TextView) convertView
				.findViewById(android.R.id.text1);
		tmpTextView.setText(getChild(groupPosition, childPosition).toString());
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
