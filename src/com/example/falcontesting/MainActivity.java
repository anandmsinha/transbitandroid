package com.example.falcontesting;

import java.util.ArrayList;
import java.util.List;

import com.example.falcontesting.adapters.FalconRequestListAdapter;
import com.example.falcontesting.request.Request;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends BaseActivity {

	private FalconRequestListAdapter mFalconRequestListAdapter;
	private ListView mListContent;
	private List<Request> mRequestList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		createListView();
	}

	private void createListView() {
		this.mRequestList = new ArrayList<Request>();
		this.mRequestList
				.add(new Request(
						"2227:2",
						"Searcher - Ability to use FineReader.",
						"Searcher - Ability to use FineReader SDK for extracting the text from images and use the text for solr indexing.",
						"12th may 2014"));
		this.mRequestList
				.add(new Request(
						"2227:8",
						"Falcon Resumable uploader",
						"Sir, As per our last discussion, please Incorporate the resumable uploader feature in Falcon.Thanks,Shubham",
						"14th July 2014"));
		for (int i = 0; i < 10; ++i) {
			this.mRequestList
					.add(new Request(
							"2227:2",
							"Falcon Resumable uploader",
							"Sir, As per our last discussion, please Incorporate the resumable uploader feature in Falcon.Thanks,Shubham",
							"14th July 2014"));
		}
		mFalconRequestListAdapter = new FalconRequestListAdapter(
				this.mRequestList, getLayoutInflater());
		mListContent = (ListView) findViewById(R.id.main_list_content);
		mListContent.setAdapter(mFalconRequestListAdapter);

		final MainActivity tmpThis = this;

		mListContent.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				startActivity(new Intent(tmpThis, RequestDetailActivity.class));
			}
		});
	}

}