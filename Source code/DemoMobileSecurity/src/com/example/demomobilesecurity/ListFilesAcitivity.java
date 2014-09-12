package com.example.demomobilesecurity;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.demomobilesecurity.adapter.ListFileAdpater;
import com.example.demomobilesecurity.entity.FileItem;
import com.example.demomobilesecurity.utility.FileUtils;

import butterknife.InjectView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ListFilesAcitivity extends BaseActivity {

	@InjectView(R.id.list_file) ListView listView;
    @InjectView(R.id.add_files) Button addFile;
    
	private List<FileItem> fileItems;

	private ListFileAdpater listFileAdpater;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		fileItems = fileUtils.hideFileItems;
		listView.setAdapter(new ListFileAdpater(this, fileItems));
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
		// TODO Auto-generated method stub
		if (v.getId() == R.id.add_files) {
			Intent intent = new Intent(this, BrowseFileActivity.class);
			intent.putExtra("CurrentPath", Environment.getExternalStorageDirectory().getAbsolutePath());
			startActivityForResult(intent, requestCode);
		}
		
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
	
	
}
