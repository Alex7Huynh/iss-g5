package com.example.demomobilesecurity;

import butterknife.InjectView;
import butterknife.OnClick;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordActivity extends BaseActivity {

	@InjectView(R.id.old_password) EditText oldPassword;
	@InjectView(R.id.new_password) EditText newPassword;
	@InjectView(R.id.renew_password) EditText renewPassword;
	@InjectView(R.id.change_password) Button changePassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.change_password, menu);
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
		
	}

	@Override
	protected int getContentView() {
		// TODO Auto-generated method stub
		return R.layout.activity_change_password;
	}
	
	@OnClick(R.id.change_password)
	public void changePassword() {
		String oldPass = fileUtils.getPassword();
		String oldPassText = oldPassword.getText().toString();
		String newPass = newPassword.getText().toString();
		String renewPass = renewPassword.getText().toString();
		
		if (!oldPass.equals(oldPassText)) {
			this.showDialog("Error", "Please input your old password!");
			return;
		}
		if (!newPass.equals(renewPass)) {
			this.showDialog("Error", "Your re-input new password not matched!");
			return;
		}
		fileUtils.PASSWORD = newPass;
		fileUtils.updatePassword();
		finish();
	}
}
