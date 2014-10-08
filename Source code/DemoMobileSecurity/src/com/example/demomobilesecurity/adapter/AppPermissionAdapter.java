package com.example.demomobilesecurity.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.demomobilesecurity.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AppPermissionAdapter extends BaseAdapter {

	protected Activity parentActivity;
	protected LayoutInflater inflater;
	protected List<String> dataList;
	public AppPermissionAdapter() {
		// TODO Auto-generated constructor stub
		dataList = new ArrayList<String>();
	}
	
	public AppPermissionAdapter(Activity activity, List<String> apps) {
		this();
		inflater = activity.getLayoutInflater();
		parentActivity = activity;
		dataList = apps;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dataList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = inflater.inflate(R.layout.app_item, parent, false);
		if (convertView != null) {
			TextView nameView  = (TextView)convertView.findViewById(R.id.name_app);
			nameView.setText(dataList.get(position));
		}

		return convertView;
	}

}
