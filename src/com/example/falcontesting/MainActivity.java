package com.example.falcontesting;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.falcontesting.adapters.FalconExpandableListAdapter;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

public class MainActivity extends ActionBarActivity implements
		OnChildClickListener, OnGroupClickListener, OnGroupExpandListener,
		OnGroupCollapseListener {
	private ActionBarDrawerToggle mDrawerToggle;
	private DrawerLayout mDrawerLayout;
	private ExpandableListView mExpandableListView;
	private Toolbar mToolbar;
	private FalconExpandableListAdapter expandableListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mExpandableListView = (ExpandableListView) findViewById(R.id.main_sidebar);
		this.populateExpandableListView();
		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				mToolbar, R.string.navigation_drawer_open,
				R.string.navigation_drawer_close);
		setSupportActionBar(mToolbar);
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				mToolbar, R.string.app_name, R.string.app_name);
		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void onBackPressed() {
		if (mDrawerLayout.isDrawerOpen(Gravity.START | Gravity.LEFT)) {
			mDrawerLayout.closeDrawers();
			return;
		}
		super.onBackPressed();
	}

	private void populateExpandableListView() {
		ArrayList<String> groups = new ArrayList<String>();
		groups.add("GroupA");
		groups.add("GroupB");
		groups.add("GroupC");
		groups.add("GroupD");
		HashMap<String, ArrayList<String>> groupData = new HashMap<String, ArrayList<String>>();
		ArrayList<String> childA = new ArrayList<String>();
		childA.add("Child1");
		childA.add("Child2");
		groupData.put("GroupA", childA);
		groupData.put("GroupB", new ArrayList<String>());
		groupData.put("GroupC", new ArrayList<String>());
		groupData.put("GroupD", new ArrayList<String>());

		expandableListAdapter = new FalconExpandableListAdapter(
				getLayoutInflater(), groups, groupData);
		this.mExpandableListView.setAdapter(expandableListAdapter);
		this.mExpandableListView.setOnChildClickListener(this);
		this.mExpandableListView.setOnGroupClickListener(this);
		this.mExpandableListView.setOnGroupExpandListener(this);
		this.mExpandableListView.setOnGroupCollapseListener(this);
	}

	@Override
	public void onGroupCollapse(int groupPosition) {
		Toast.makeText(
				this,
				"Collapsing "
						+ this.expandableListAdapter.getGroup(groupPosition)
								.toString(), Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onGroupExpand(int groupPosition) {
		Toast.makeText(
				this,
				"Expanding "
						+ this.expandableListAdapter.getGroup(groupPosition)
								.toString(), Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onGroupClick(ExpandableListView parent, View v,
			int groupPosition, long id) {
		Toast.makeText(
				this,
				"Group click "
						+ this.expandableListAdapter.getGroup(groupPosition)
								.toString(), Toast.LENGTH_SHORT).show();
		return false;
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		Toast.makeText(
				this,
				"Child click "
						+ this.expandableListAdapter.getChild(groupPosition, childPosition)
								.toString(), Toast.LENGTH_SHORT).show();
		return false;
	}
}