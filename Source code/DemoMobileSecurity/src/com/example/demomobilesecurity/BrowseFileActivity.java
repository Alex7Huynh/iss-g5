package com.example.demomobilesecurity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

import com.example.demomobilesecurity.adapter.ListFileAdpater;
import com.example.demomobilesecurity.entity.FileItem;
import com.example.demomobilesecurity.utility.FileUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class BrowseFileActivity extends BaseActivity {

	@InjectView(R.id.browse_list_file) ListView listView;
	@InjectView(R.id.select_file) Button selectFile;
	
	private int currentPostion = -1;
	
	private List<FileItem> fileItems;
	private String pathFile;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		pathFile = getIntent().getStringExtra("CurrentPath");
		if (pathFile == null) 
			pathFile = Environment.getExternalStorageDirectory().getAbsolutePath();
		fileItems = FileUtils.getFileUtils(getApplication()).getListFileItems(pathFile);
		listView.setAdapter(new ListFileAdpater(this, fileItems));
		listView.setOnItemClickListener(this);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.browse_file, menu);
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
		this.selectFile();
	}

	@Override
	protected int getContentView() {
		// TODO Auto-generated method stub
		return R.layout.activity_browse_file;
	}
	
	
	@OnClick(R.id.select_file) 
	public void selectFile() {
		if (currentPostion >= 0) {
			FileItem fileItem = fileItems.get(currentPostion);
			fileUtils.hideFiles(fileItem);
			finish();
		}
		currentPostion = -1;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		FileItem fileItem = fileItems.get(position);
		if (fileItem.IsFolder) {
			Intent intent = new Intent(this, BrowseFileActivity.class);
			intent.putExtra("CurrentPath", fileItem.PathFile);
			startActivity(intent); 
		} else {
			currentPostion = position;
		}
	}
	
	
}
