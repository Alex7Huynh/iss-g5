package com.example.demomobilesecurity;

import java.lang.reflect.Field;

import butterknife.ButterKnife;
import android.app.Activity;
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
	
	public BaseActivity() {
		// TODO Auto-generated constructor stub
	}
	
	public <T> T getView(int id) {
		return (T) findViewById(id);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		setContentView(getContentView());
		ButterKnife.inject(this);
		try {
			registerEventOnClick();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	protected abstract int getContentView();
	
}
