package com.example.demomobilesecurity;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

import com.example.demomobilesecurity.adapter.AppPermissionAdapter;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class DetectPermissionAppActivity extends BaseActivity {

	@InjectView(R.id.list_app)
	ListView listAppsView;
	public List<String> apps;
	public AppPermissionAdapter permissionAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		apps = new ArrayList<String>();

		final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
		mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		final List pkgAppsList = getPackageManager().queryIntentActivities(
				mainIntent, 0);

		for (Object obj : pkgAppsList) {
			ResolveInfo resolveInfo = (ResolveInfo) obj;
			PackageInfo packageInfo = null;
			try {
				packageInfo = getPackageManager().getPackageInfo(
						resolveInfo.activityInfo.packageName,
						PackageManager.GET_PERMISSIONS);
			} catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (packageInfo == null)
				continue;
			String[] requestedPermissions = packageInfo.requestedPermissions;
			if (requestedPermissions != null) {
				for (String string : requestedPermissions) {
					if (string.contains("SMS")) {
						apps.add(packageInfo.packageName);
					}
				}
			}
			
		}
		permissionAdapter = new AppPermissionAdapter(this, apps);
		listAppsView.setAdapter(permissionAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detect_permission_app, menu);
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
		return R.layout.activity_detect_permission_app;
	}
}
