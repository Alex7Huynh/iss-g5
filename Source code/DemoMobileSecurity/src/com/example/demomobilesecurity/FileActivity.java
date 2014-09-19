package com.example.demomobilesecurity;

import java.io.File;
import java.util.ArrayList;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ListView;
import butterknife.InjectView;
import butterknife.OnClick;

import com.example.demomobilesecurity.adapter.ItemViewAdapter;
import com.example.demomobilesecurity.entity.FileItem;
import com.example.demomobilesecurity.utility.ConstantValues;

public class FileActivity extends BaseActivity {

	@InjectView(R.id.lv_files)
	ListView lv_files;
	ArrayList<FileItem> arrfiles;
	ItemViewAdapter fileadapter;
	private static final int MAX_FILE = 5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
//		sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://"
//                + Environment.getExternalStorageDirectory())));

		FileActivity that = this;

		int extra = getIntent().getExtras().getInt(
				ConstantValues.EXTRA);
		arrfiles = new ArrayList<FileItem>();

		String[] projections = new String[3];
		Cursor cursor;
		switch (extra) {
		case ConstantValues.PICTURE:
			projections[0] = MediaStore.Images.Media.DATA;
			projections[1] = MediaStore.Images.Media.DISPLAY_NAME;
			projections[2] = MediaStore.Images.Media.DATE_ADDED;
			cursor = getContentResolver()
					.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
							projections, null, null,
							MediaStore.Images.Media.DATE_MODIFIED);
		
			break;
		case ConstantValues.AUDIO:
			projections[0] = MediaStore.Audio.Media.DATA;
			projections[1] = MediaStore.Audio.Media.DISPLAY_NAME;
			projections[2] = MediaStore.Audio.Media.DATE_ADDED;

			cursor = getContentResolver()
					.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
							projections, null, null,
							MediaStore.Audio.Media.DATE_ADDED);
			break;
		case ConstantValues.VIDEO:
			projections[0] = MediaStore.Video.Media.DATA;
			projections[1] = MediaStore.Video.Media.DISPLAY_NAME;
			projections[2] = MediaStore.Video.Media.DATE_ADDED;

			cursor = getContentResolver()
					.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
							projections, null, null,
							MediaStore.Video.Media.DATE_ADDED);
			break;
		default:
			projections[0] = MediaStore.Files.FileColumns.DATA;
			projections[1] = MediaStore.Files.FileColumns.DISPLAY_NAME;
			projections[2] = MediaStore.Files.FileColumns.DATE_ADDED;

			String selection = MediaStore.Files.FileColumns.MEDIA_TYPE
					+ "="
					+ MediaStore.Files.FileColumns.MEDIA_TYPE_NONE;
			String[] selectionArgs = null;
			cursor = getContentResolver().query(
					MediaStore.Files.getContentUri("external"),
					projections, selection, selectionArgs,
					MediaStore.Files.FileColumns.DATE_ADDED);
		}
		int index = 0;
		while (cursor.moveToNext() && index < MAX_FILE) {

			FileItem item = new FileItem();

			item.PathFile = cursor.getString(0);
			item.FileName = cursor.getString(1);
			item.FileType = MimeTypeMap
					.getFileExtensionFromUrl(item.FileName);
			item.IsFolder = item.FileType == null
					|| item.FileType.isEmpty();
			File f = new File(item.PathFile);
			if (f != null && f.exists()
					&& item.FileName != null
					&& !item.FileName.isEmpty()) {
				arrfiles.add(item);
				index++;

			}
		}
		fileadapter = new ItemViewAdapter(arrfiles, this, extra);
		lv_files.setAdapter(fileadapter);
		//cursor.close();
//		MediaScannerConnection.scanFile(this, new String[] { Environment
//				.getExternalStorageDirectory().getAbsolutePath() }, null,
//				new MediaScannerConnection.OnScanCompletedListener() {
//
//					@Override
//					public void onScanCompleted(String path, Uri uri) {
//						// TODO Auto-generated method stub
//						
//					}
//				});

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

	@OnClick(R.id.bn_Hide)
	public void hideFiles() {
		for (FileItem fileItem : arrfiles) {
			if (fileItem.IsFolder)
				continue;
			if (!fileItem.IsSelected)
				continue;
			fileUtils.hideFiles(fileItem);
		}
		finish();
	}
}
