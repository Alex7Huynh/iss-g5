package com.example.demomobilesecurity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import butterknife.InjectView;
import butterknife.OnClick;

import com.example.demomobilesecurity.utility.ConstantValues;

public class SettingsActivity extends BaseActivity {

	@InjectView(R.id.et_oldpass)
	EditText et_oldpass;
	@InjectView(R.id.et_newpass)
	EditText et_newpass;
	@InjectView(R.id.et_conpass)
	EditText et_conpass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@OnClick(R.id.bn_confirm)
	public void onConfirm() {
		if (et_oldpass.getEditableText().toString().isEmpty()){
			this.showDialog("Error", "Please input your old password!");
			return;
		}

		if (et_oldpass.getEditableText().toString().trim().isEmpty()){
			this.showDialog("Error", "Please input your new password!");
			return;
		}
		if (et_newpass.getEditableText().toString().trim().isEmpty())
		{
			this.showDialog("Error", "Please input your new password!");
			return;
		}

		String oldPassword = fileUtils.getPassword();
		if (!oldPassword.equals(et_oldpass.getEditableText().toString())) {
			this.showDialog("Error", "Your old password does not matched!");

			return;
		}

		if (et_newpass.getEditableText().toString()
				.compareTo(et_conpass.getEditableText().toString()) != 0){
			this.showDialog("Error", "Your confirm password does not matched!");
			return;
		}

		fileUtils.setValueData(ConstantValues.USER_PASSWORD, et_newpass
				.getEditableText().toString());
		
		finish();

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	@Override
	protected int getContentView() {
		// TODO Auto-generated method stub
		return R.layout.activity_settings_activity;
	}
}
