package com.example.demomobilesecurity.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.demomobilesecurity.R;
import com.example.demomobilesecurity.entity.FileItem;

public class ItemViewAdapter extends BaseAdapter {

	ArrayList<FileItem> mItemList;
	Activity mActivity;
	LayoutInflater mInflater;
	int mExtra;

	public ItemViewAdapter() {
		// TODO Auto-generated constructor stub
	}

	public ItemViewAdapter(ArrayList<FileItem> mItemList, Activity mActivity,
			int extra) {
		super();
		this.mItemList = mItemList;
		this.mActivity = mActivity;
		this.mInflater = this.mActivity.getLayoutInflater();
		this.mExtra = extra;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mItemList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mItemList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ItemView tag;

		convertView = mInflater.inflate(R.layout.item_layout, parent, false);
		tag = new ItemView(convertView);
		tag.mRefFile = mItemList.get(position);
		tag.setExtra(mExtra);
		tag.setViews();
		convertView.setTag(tag);

		return convertView;
	}

}
