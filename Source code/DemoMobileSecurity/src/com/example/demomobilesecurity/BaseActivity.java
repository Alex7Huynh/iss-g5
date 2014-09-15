package com.example.demomobilesecurity;

import java.io.FileOutputStream;
import java.lang.reflect.Field;

import com.example.demomobilesecurity.utility.FileUtils;



import butterknife.ButterKnife;
import android.R.bool;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;

public abstract class BaseActivity extends Activity implements OnClickListener, OnItemClickListener {

	public static String dataPath = "/";
	protected FileUtils fileUtils;
	protected int requestCode = 100;
	public BaseActivity() {
		// TODO Auto-generated constructor stub
	
	}
	
	public <T> T getView(int id) {
		return (T) findViewById(id);
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	protected void registerEventOnClick() throws IllegalAccessException, IllegalArgumentException {
		Field[] fields = this.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.getType() == ImageButton.class) {
				((ImageButton)field.get(this)).setOnClickListener(this);
			}
			if (field.getType() == Button.class) {
				((Button)field.get(this)).setOnClickListener(this);
			}
		}
	}
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}
	
	public void onBackPressed(){
	     // do something here and don't write super.onBackPressed()
		finish();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getContentView());
		ButterKnife.inject(this);
		fileUtils = fileUtils.getFileUtils(getApplication());
	}
	

	protected abstract int getContentView();
	
	public void showDialog(String title, String content) {
		AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

		dlgAlert.setMessage(content);
		dlgAlert.setTitle(title);
		dlgAlert.setCancelable(true);
		
			dlgAlert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) {
		            //dismiss the dialog  
		        	dialog.cancel();
		          }
		      });
		
		dlgAlert.create().show();
	}
	
}
