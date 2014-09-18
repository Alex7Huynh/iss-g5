package com.example.demomobilesecurity.adapter;

import com.example.demomobilesecurity.R;
import com.example.demomobilesecurity.entity.FileItem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class FileItemView {

	@InjectView(R.id.file_item_name)
	TextView fileName;
	@InjectView(R.id.file_item_path)
	TextView filePath;
	@InjectView(R.id.file_item_avatar)
	ImageView fileAvatar;

	private View mParentView;
	private FileItem mFileItem;

	public FileItemView(View parentView, FileItem fileItem) {
		// TODO Auto-generated constructor stub
		mParentView = parentView;
		ButterKnife.inject(this, parentView);
		mFileItem = fileItem;
		fileName.setText(mFileItem.FileName);
		filePath.setText(mFileItem.PathFile);

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

	}

}
