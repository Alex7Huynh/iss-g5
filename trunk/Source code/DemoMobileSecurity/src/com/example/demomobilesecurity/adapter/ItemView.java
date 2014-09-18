package com.example.demomobilesecurity.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.example.demomobilesecurity.R;
import com.example.demomobilesecurity.entity.FileItem;

public class ItemView {

	@InjectView(R.id.iv_view) ImageView iv_view;
	@InjectView(R.id.cb_select) CheckBox cb_select;
	@InjectView(R.id.tv_file) TextView tv_file;
	
	private View mParentView;
	public FileItem mRefFile;
	
	public ItemView (View parentview){
		mParentView = parentview;
		ButterKnife.inject(this, mParentView);
	}
	
	@OnClick(R.id.cb_select)
	public void selectFile (){
		mRefFile.IsSelected = cb_select.isChecked();
	}
	
}
