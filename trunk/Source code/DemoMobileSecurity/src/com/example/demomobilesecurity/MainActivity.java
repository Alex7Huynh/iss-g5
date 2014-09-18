package com.example.demomobilesecurity;

import com.example.demomobilesecurity.utility.ConstantValues;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends BaseActivity {

	@InjectView(R.id.password) EditText passwordText;
	@InjectView(R.id.view_files) Button viewFile;
	//@InjectView(R.id.change_password) Button changePassword;
	//@InjectView(R.id.view_sms_app) Button viewSMSApp;
	@InjectView(R.id.createpass)	Button createpass;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		SharedPreferences passwords = getSharedPreferences(
				ConstantValues.USER_PASSWORD,
				android.content.Context.MODE_PRIVATE);
		String passtext = passwords.getString(ConstantValues.USER_PASSWORD, "");
		if (passtext == "") {
			createpass.setEnabled(true);
			viewFile.setEnabled(false);
		} else {
			createpass.setEnabled(false);
			viewFile.setEnabled(true);
		}
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

		}
	}

	@OnClick(R.id.createpass)
	public void createPassword() {
		if (passwordText.getText().toString().isEmpty())
			return;

		if (passwordText.getText().toString().trim().isEmpty())
			return;

		SharedPreferences passwords = getSharedPreferences(
				ConstantValues.USER_PASSWORD,
				android.content.Context.MODE_PRIVATE);
		Editor editor = passwords.edit();
		editor.putString(ConstantValues.USER_PASSWORD, passwordText.getText()
				.toString());
		editor.commit();
		
		Intent intent = new Intent(this, ListFilesAcitivity.class);
		startActivity(intent);
	}
	
	@OnClick(R.id.view_files)
	public void viewFiles() {

		SharedPreferences passwords = getSharedPreferences(
				ConstantValues.USER_PASSWORD,
				android.content.Context.MODE_PRIVATE);
		String passtext = passwords.getString(ConstantValues.USER_PASSWORD, "");
		if (passtext.compareTo(passwordText.getText().toString()) == 0) {
			 Intent intent = new Intent(this, HiddenActivity.class);
			 startActivity(intent);
		}
	}
	
//	@OnClick(R.id.change_password)
//	public void changePassword() {
//		
//	}

	@Override
	protected int getContentView() {
		// TODO Auto-generated method stub
		return R.layout.activity_main;
	}
}
