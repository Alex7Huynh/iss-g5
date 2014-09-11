package com.demofiles.filebrowser;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

import android.R.color;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
/*import android.support.v7.app.ActionBarActivity;
 import android.os.Bundle;
 import android.view.Menu;
 import android.view.MenuItem;*/
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.*;
import android.widget.*;

public class FileBrowser extends Activity {

	public static String StartDirectory = "StartDirectory";
	public static String FilterExtension = "FilterExtension";

	ArrayList<String> ListPathDirectories = new ArrayList<String>();
	File Path = null;
	String ChosenFile = null;
	ArrayList<Item> ListItems = new ArrayList<Item>();
	ArrayAdapter<Item> AdapterItems;
	boolean IsEmptyDirectory = false;
	String FilterFileExtension = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_browser);

		this.FilterFileExtension = getIntent().getStringExtra(
				FileBrowser.FilterExtension);

		setInitDirectory();

		parseDirectoryPaths();

		LoadFileList();

		CreateFileListAdapter();

		InitializeFileListView();

		UpdateCurrentDirectoryTextView();
	}

	private void setInitDirectory() {
		// TODO Auto-generated method stub
		Intent intent = getIntent();
		String start = intent.getStringExtra(FileBrowser.StartDirectory);

		if (start != null && start.length() > 0) {
			File tempfile = new File(start);
			if (tempfile.isDirectory())
				this.Path = tempfile;
		}

		if (this.Path == null) {
			if (Environment.getExternalStorageDirectory().isDirectory()
					&& Environment.getExternalStorageDirectory().canRead())
				this.Path = Environment.getExternalStorageDirectory();
			else
				this.Path = new File("/");
		}
	}

	private void parseDirectoryPaths() {
		// TODO Auto-generated method stub
		this.ListPathDirectories.clear();

		String pathString = this.Path.getAbsolutePath();
		String[] parts = pathString.split("/");
		int i = 0;
		while (i < parts.length) {
			this.ListPathDirectories.add(parts[i]);
			i++;
		}

	}

	private void LoadFileList() {
		// TODO Auto-generated method stub
		try {
			this.Path.mkdirs();
		} catch (Exception ex) {

		}

		ListItems.clear();

		if (this.Path.exists() && this.Path.canRead()) {
			FilenameFilter filter = new FilenameFilter() {

				@Override
				public boolean accept(File dir, String filename) {
					// TODO Auto-generated method stub
					return true;
				}
			};

			String[] flist = this.Path.list(filter);
			this.IsEmptyDirectory = false;
			for (int i = 0; i < flist.length; i++) {
				File selectfile = new File(this.Path, flist[i]);
				int drawableid = R.drawable.file_icon;
				if (selectfile.isDirectory()) {
					drawableid = R.drawable.file_icon;
				}
				ListItems.add(i, new Item(flist[i], drawableid, true));
			}

			if (ListItems.size() == 0) {
				this.IsEmptyDirectory = true;
				this.ListItems.add(0, new Item("Directory is Empty", -1, true));
			} else {
				Collections.sort(ListItems, new ItemFileNameComparator());
			}
		}

	}

	@SuppressLint("NewApi")
	private void CreateFileListAdapter() {
		// TODO Auto-generated method stub
		this.AdapterItems = new ArrayAdapter<Item>(this,
				android.R.layout.select_dialog_item, android.R.id.text1,
				ListItems) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				View view = super.getView(position, convertView, parent);
				TextView textview = (TextView) view
						.findViewById(android.R.id.text1);
				int drawableid = 0;

				if (ListItems.get(position).Icon != -1) {
					drawableid = ListItems.get(position).Icon;
				}
				textview.setCompoundDrawablesRelativeWithIntrinsicBounds(
						drawableid, 0, 0, 0);
				textview.setEllipsize(null);

				int dp3 = (int) (3 * getResources().getDisplayMetrics().density + 0.5f);
				textview.setCompoundDrawablePadding(dp3);
				textview.setBackgroundColor(Color.LTGRAY);
				return view;

			}
		};
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.file_browser, menu);
		return true;
	}

	private void InitializeFileListView() {
		// TODO Auto-generated method stub
		ListView view = (ListView) this.findViewById(R.id.fileListView);
		view.setBackgroundColor(Color.LTGRAY);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		params.setMargins(15, 5, 15, 5);
		view.setAdapter(this.AdapterItems);
		view.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				ChosenFile = ListItems.get(arg2).FileName;
				File selectfile = new File(ChosenFile);
				if (selectfile.isDirectory()){
					ListPathDirectories.add(ChosenFile);
					Path = new File(selectfile + "");
					LoadFileList();
					AdapterItems.notifyDataSetChanged();
					UpdateCurrentDirectoryTextView();
				}else
				{
					//Execute File
				}
			}
		});
		;
	}

	private void UpdateCurrentDirectoryTextView() {
		// TODO Auto-generated method stub
		int i = 0;
		String curDirString = "";
		while (i < ListPathDirectories.size()) {
			curDirString += ListPathDirectories.get(i) + "/";
			i++;
		}

		if (ListPathDirectories.size() == 0) {
			curDirString = "/";
		}

		long freespace = getFreeSpace(curDirString);
		String formatbytes = getByteType(freespace);
		if (freespace == 0) {

		}

		((TextView) this.findViewById(R.id.currentDirectoryTextView))
				.setText(curDirString);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			// Do Something here
		} else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
			// Do Something here
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
		return super.onOptionsItemSelected(item);
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
	public static long getFreeSpace(String path) {
		StatFs stat = null;
		try {
			stat = new StatFs(path);
		} catch (Exception ex) {
			String error = ex.toString();
			String temp = error;
		}
		long availablesize = (long) stat.getAvailableBlocksLong()
				* (long) stat.getBlockSizeLong();
		return availablesize;
	}

	public static String getByteType(long bytes) {
		String result = "";

		// GigaBytes
		if (bytes > 1073741824) {
			long gbs = bytes / 1073741824;
			result += (new Long(gbs)).toString() + "GB ";
			bytes = bytes - (gbs * 1073741824);
		}

		// MegaBytes
		if (bytes > 1048576) {
			long mbs = bytes / 1048576;
			result += (new Long(mbs)).toString() + "MB ";
		}

		if (bytes > 1024) {
			long kbs = bytes / 1024;
			result += (new Long(kbs)).toString() + "KB";
			bytes = bytes - (kbs * 1024);
		} else
			result += (new Long(bytes)).toString() + "bytes";
		return result;
	}

	private class Item {
		public String FileName;
		public int Icon;
		public boolean IsRead;

		public Item(String name, int icon, boolean isread) {
			this.FileName = name;
			this.Icon = icon;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.FileName;
		}
	}

	private class ItemFileNameComparator implements Comparator<Item> {

		@Override
		public int compare(Item lhs, Item rhs) {
			// TODO Auto-generated method stub
			return lhs.FileName.toLowerCase().compareTo(
					rhs.FileName.toLowerCase());
		}

	}
}
