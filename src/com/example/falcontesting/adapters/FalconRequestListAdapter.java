package com.example.falcontesting.adapters;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.falcontesting.R;
import com.example.falcontesting.request.Request;

public class FalconRequestListAdapter extends BaseAdapter {
	
	private List<Request> mRequestList;
	private LayoutInflater mInflater;
	
	public FalconRequestListAdapter(List<Request> requestList, LayoutInflater inflater) {
		this.mRequestList = requestList;
		this.mInflater = inflater;
	}
	
	@Override
	public int getCount() {
		return mRequestList.size();
	}

	@Override
	public Object getItem(int position) {
		return mRequestList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_row, parent, false);
		}
		
		Request tmpRequest = (Request) getItem(position);
		
		TextView mainRequestId = (TextView) convertView.findViewById(R.id.main_request_id);
		mainRequestId.setText(tmpRequest.getId());
		TextView mainRequestHeading = (TextView) convertView.findViewById(R.id.main_request_heading);
		mainRequestHeading.setText(tmpRequest.getSubject());
		TextView mainRequestDetails = (TextView) convertView.findViewById(R.id.main_request_details);
		mainRequestDetails.setText(tmpRequest.getRequestDetails());
		TextView requestTime = (TextView) convertView.findViewById(R.id.main_request_time);
		requestTime.setText(tmpRequest.getRequestTime());
		
		return convertView;
	}

}
