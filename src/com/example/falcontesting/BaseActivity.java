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

public class BaseActivity extends ActionBarActivity implements
		OnChildClickListener, OnGroupClickListener, OnGroupExpandListener,
		OnGroupCollapseListener {

	private ActionBarDrawerToggle mDrawerToggle;
	private FalconExpandableListAdapter expandableListAdapter;
	private ExpandableListView mExpandableListView;
	private Toolbar mToolbar;
	private DrawerLayout mDrawerLayout;

	@Override
	public void setContentView(int resourceId) {
		super.setContentView(resourceId);
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
		groups.add("Employee services");
		groups.add("Developement Team");
		groups.add("Internal");
		HashMap<String, ArrayList<String>> groupData = new HashMap<String, ArrayList<String>>();
		ArrayList<String> childA = new ArrayList<String>();
		childA.add("ITR");
		childA.add("Personal Records");
		childA.add("Expense claims");
		childA.add("Leave Tracking");
		groupData.put("Employee services", childA);
		ArrayList<String> childB = new ArrayList<String>();
		childB.add("Falcon Bug Tracker");
		groupData.put("Developement Team", childB);
		ArrayList<String> childC = new ArrayList<String>();
		childC.add("Docs");
		childC.add("Customer Data");
		childC.add("Library");
		childC.add("Knowledge management");
		childC.add("Unused");
		groupData.put("Internal", childC);

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
		mDrawerLayout.closeDrawers();
		getSupportActionBar().setTitle(
				this.expandableListAdapter.getChild(groupPosition,
						childPosition).toString());
		return false;
	}
}
