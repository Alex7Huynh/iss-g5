package com.example.demomobilesecurity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends BaseActivity {

	@InjectView(R.id.password) EditText passwordText;
	@InjectView(R.id.view_files) Button viewFile;
	@InjectView(R.id.change_password) Button changePassword;
	@InjectView(R.id.view_sms_app) Button viewSMSApp;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.view_files) {
			Intent intent = new Intent(this, MainActivity.class);
			intent.putExtra("ChangePassword", true);
			startActivity(intent);
			
		}
	}
	
	@OnClick(R.id.view_files)
	public void viewFiles() {
		if (!passwordText.getText().toString().isEmpty() && fileUtils.checkPassword(passwordText.getText().toString())) {
			Intent intent = new Intent(this, ListFilesAcitivity.class);
			startActivity(intent);
		} else {
			this.showDialog("Warning!", "Please input your password");
		}
	}
	
	@OnClick(R.id.change_password)
	public void changePassword() {
		
	}

	@Override
	protected int getContentView() {
		// TODO Auto-generated method stub
		return R.layout.activity_main;
	}
}
