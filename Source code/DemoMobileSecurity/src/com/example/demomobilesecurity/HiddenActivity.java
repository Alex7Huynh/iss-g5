package com.example.demomobilesecurity;

import butterknife.InjectView;
import butterknife.OnClick;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HiddenActivity extends BaseActivity {

	@InjectView(R.id.in_picture)
	ImageButton iv_picture;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@OnClick(R.id.in_hiddenfile)
	public void showHiddenFiles() {
		Intent intent = new Intent(getApplicationContext(),
				ListFilesAcitivity.class);
		startActivity(intent);
	}

	@OnClick(R.id.in_picture)
	public void browseHiddenPicture() {

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	@Override
	protected int getContentView() {
		// TODO Auto-generated method stub
		return R.layout.activity_hidden_activity;
	}
}
