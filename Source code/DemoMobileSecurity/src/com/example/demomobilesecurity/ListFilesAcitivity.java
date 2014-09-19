package com.example.demomobilesecurity;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.demomobilesecurity.adapter.ListFileAdpater;
import com.example.demomobilesecurity.entity.FileItem;
import com.example.demomobilesecurity.utility.FileUtils;

import butterknife.InjectView;
import butterknife.OnClick;
import android.app.Activity;
import android.content.Intent;
import android.net.rtp.RtpStream;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class ListFilesAcitivity extends BaseActivity {

	@InjectView(R.id.list_file) ListView listView;
    @InjectView(R.id.add_files) Button addFile;
    @InjectView(R.id.restore_files) Button restoreFile;
    public int currentPosition;
    
	private List<FileItem> fileItems;

	private ListFileAdpater listFileAdpater;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		fileItems = fileUtils.hideFileItems;
		listFileAdpater = new ListFileAdpater(this, fileItems, false);
		listView.setAdapter(listFileAdpater);
		listView.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.browse_acitivity, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		
		
	}
	
	@OnClick(R.id.add_files)
	public void addFiles() {
		Intent intent = new Intent(this, BrowseFileActivity.class);
		intent.putExtra("CurrentPath", Environment.getExternalStorageDirectory().getAbsolutePath());
		startActivityForResult(intent, requestCode);
	}
	
	@OnClick(R.id.restore_files) 
	public void onRestoreFileAction(){
		if (currentPosition >= 0) {
			fileUtils.currentFileItems.clear();
			for (FileItem hiddenFile : fileUtils.hideFileItems) {
				if (hiddenFile.IsSelected) {
					fileUtils.currentFileItems.add(hiddenFile);
				}
			}
			Intent intent = new Intent(this, BrowseFileActivity.class);
			intent.putExtra("IS_RESTORE", true);
			startActivity(intent);
		}
		currentPosition = -1;
	}

	@Override
	protected int getContentView() {
		// TODO Auto-generated method stub
		return R.layout.activity_list_file_acitivity;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		listFileAdpater.updateDataList(fileUtils.hideFileItems);
	}
	
	
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		currentPosition = position;
		
	}
	
	public void onBackPressed(){
	     // do something here and don't write super.onBackPressed()
		Intent intent = new Intent(this, HiddenActivity.class);
		this.startActivity(intent);
	}
	
	
}
