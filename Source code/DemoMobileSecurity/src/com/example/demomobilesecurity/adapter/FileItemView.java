package com.example.demomobilesecurity.adapter;

import com.example.demomobilesecurity.R;
import com.example.demomobilesecurity.entity.FileItem;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class FileItemView {

	@InjectView(R.id.file_item_name)
	TextView fileName;
	@InjectView(R.id.file_item_path)
	TextView filePath;
	@InjectView(R.id.file_item_avatar)
	ImageView fileAvatar;
	@InjectView(R.id.file_item_select)
	CheckBox fileItemSelect;

	private View mParentView;
	private FileItem mFileItem;
	private boolean isRestoreMode;
	
	public FileItemView(View parentView, FileItem fileItem, boolean isRestore) {
		// TODO Auto-generated constructor stub
		mParentView = parentView;
		ButterKnife.inject(this, parentView);
		mFileItem = fileItem;
		fileName.setText(mFileItem.FileName);
		filePath.setText(mFileItem.PathFile);
		isRestoreMode = isRestore;

		if (fileItem.FileType.equalsIgnoreCase("jpg")
				|| fileItem.FileType.equalsIgnoreCase("png")) {
			fileAvatar.setImageResource(R.drawable.filetype_image);
		}
		if (fileItem.FileType.equalsIgnoreCase("mp3")) {
			fileAvatar.setImageResource(R.drawable.filetype_music);
		}
		if (fileItem.FileType.equalsIgnoreCase("pdf")
				|| fileItem.FileType.equalsIgnoreCase("docx")
				|| fileItem.FileType.equalsIgnoreCase("xls")
				|| fileItem.FileType.equalsIgnoreCase("doc")) {
			fileAvatar.setImageResource(R.drawable.filetype_document);
		}
		if (isRestoreMode) {
			fileItemSelect.setVisibility(View.GONE);
		}else{
			fileItemSelect.setVisibility(View.VISIBLE);

		}

	}
	
	@OnClick(R.id.file_item_select)
	public void onCheck(){
		mFileItem.IsSelected = fileItemSelect.isChecked();
	}

}
