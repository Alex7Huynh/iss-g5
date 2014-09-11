package com.example.demomobilesecurity.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.demomobilesecurity.R;
import com.example.demomobilesecurity.entity.FileItem;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ListFileAdpater extends BaseAdapter {

	public Activity mParentActivity;
	public List<FileItem> mDataList;
	private LayoutInflater inflater;
	public ListFileAdpater() {
		// TODO Auto-generated constructor stub
	}
	
	public ListFileAdpater(Activity parentActivity, List<FileItem> dataList) {
		mParentActivity = parentActivity;
		mDataList = dataList;
		inflater = mParentActivity.getLayoutInflater();
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDataList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mDataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		FileItemView holder;
	    if (convertView != null) {
	      holder = (FileItemView) convertView.getTag();
	    } else {
	    	convertView = inflater.inflate(R.layout.list_file_item, parent, false);
	      holder = new FileItemView(convertView, mDataList.get(position));
	      convertView.setTag(holder);
	    }
	    return convertView;

	}

}
