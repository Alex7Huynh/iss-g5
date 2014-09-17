package com.example.demomobilesecurity.adapter;


import com.example.demomobilesecurity.R;
import com.example.demomobilesecurity.entity.FileItem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class FileItemView {

	@InjectView(R.id.file_item_name) TextView fileName;
	@InjectView(R.id.file_item_path) TextView filePath;
	@InjectView(R.id.file_item_avatar) ImageView fileAvatar;
	
	private View mParentView;
	private FileItem mFileItem;
	public FileItemView(View parentView, FileItem fileItem) {
		// TODO Auto-generated constructor stub
		mParentView = parentView;
		ButterKnife.inject(this, parentView);
		mFileItem = fileItem;
		fileName.setText(mFileItem.FileName);
		filePath.setText(mFileItem.PathFile);
		
		
	}

}
