package com.example.demomobilesecurity;

import java.util.ArrayList;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ListView;
import butterknife.InjectView;

import com.example.demomobilesecurity.adapter.ItemViewAdapter;
import com.example.demomobilesecurity.entity.FileItem;

public class FileActivity extends BaseActivity {

	private String mExtra;

	@InjectView(R.id.lv_files)
	ListView lv_files;
	ArrayList<FileItem> arrfiles;
	ItemViewAdapter fileadapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		arrfiles = new ArrayList<FileItem>();

		String[] projections = { MediaStore.Images.Media.DATA,
				MediaStore.Images.Media.DISPLAY_NAME,
				MediaStore.Images.Media.DATE_ADDED };

		Cursor cursor = getContentResolver().query(
				MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projections,
				null, null, MediaStore.Images.Media.DATE_ADDED);

		while (cursor.moveToNext()) {
			FileItem item = new FileItem();
			item.PathFile = cursor.getString(0);
			item.FileName = cursor.getString(1);

			arrfiles.add(item);
		}
		
		fileadapter = new ItemViewAdapter(arrfiles, this);
		lv_files.setAdapter(fileadapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	@Override
	protected int getContentView() {
		// TODO Auto-generated method stub
		return R.layout.activity_file_activity;
	}

}
