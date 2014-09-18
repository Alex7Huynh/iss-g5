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
		if (et_oldpass.getEditableText().toString().isEmpty())
			return;

		if (et_oldpass.getEditableText().toString().trim().isEmpty())
			return;

		if (et_newpass.getEditableText().toString().trim().isEmpty())
			return;

		if (et_newpass.getEditableText().toString()
				.compareTo(et_conpass.getEditableText().toString()) != 0)
			return;

		fileUtils.setValueData(ConstantValues.USER_PASSWORD, et_newpass
				.getEditableText().toString());
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(intent);
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
