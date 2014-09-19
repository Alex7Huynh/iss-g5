package com.example.demomobilesecurity.adapter;

import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.example.demomobilesecurity.R;
import com.example.demomobilesecurity.entity.FileItem;
import com.example.demomobilesecurity.utility.ConstantValues;

public class ItemView {

	@InjectView(R.id.iv_view) ImageView iv_view;
	@InjectView(R.id.cb_select) CheckBox cb_select;
	@InjectView(R.id.tv_file) TextView tv_file;
	
	private View mParentView;
	public FileItem mRefFile;
	int mExtra;
	
	public ItemView (View parentview){
		mParentView = parentview;
		ButterKnife.inject(this, mParentView);
	}
	
	
	public void setViews(){
		cb_select.setChecked(false);
		switch (mExtra) {
		case ConstantValues.PICTURE:
			tv_file.setText(mRefFile.PathFile);
			tv_file.setVisibility(View.GONE);
			iv_view.setImageBitmap(BitmapFactory.decodeFile(mRefFile.PathFile));
			return;
		case ConstantValues.AUDIO:
			iv_view.setImageDrawable(mParentView.getContext().getResources()
					.getDrawable(R.drawable.filetype_music));
			break;
		case ConstantValues.VIDEO:
			iv_view.setImageDrawable(mParentView.getContext().getResources()
					.getDrawable(R.drawable.filetype_video));
			break;
		case ConstantValues.FILE:
			iv_view.setImageDrawable(mParentView.getContext().getResources()
					.getDrawable(R.drawable.filetype_sys_file));
			break;
			// tv_file.setVisibility(View.GONE);

		}
		tv_file.setText(mRefFile.PathFile);
	}

	public void setExtra(int extra) {
		mExtra = extra;

	}
	
	@OnClick(R.id.cb_select)
	public void selectFile (){
		mRefFile.IsSelected = cb_select.isChecked();
	}
	
}
