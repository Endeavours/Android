package com.praveen.endeavour;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.praveen.endeavour.service.AppService;
import com.praveen.endeavour.util.AppConstants;

public class MainActivity extends ActionBarActivity implements AppConstants {

	EditText editUserName, editPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		inItViews();

	}

	private void inItViews() {
		editUserName = (EditText) findViewById(R.id.loginEditUserName);
		editPassword = (EditText) findViewById(R.id.loginEditPassword);
	}

	public void loginUser(View view) {
		String userName = editUserName.getText().toString().trim();
		String password = editPassword.getText().toString().trim();
		validateUsername(userName, password);
	}

	private void validateUsername(String userName, String password) {
		if (userName.isEmpty() || password.isEmpty()){
			Toast.makeText(getApplicationContext(),
					"UserName/Password is Empty", Toast.LENGTH_LONG).show();
			return ;
		}else{
			callServiceToConnectServer(userName,password);
		}

	}

	private void callServiceToConnectServer(String userName, String password) {
		Intent intent = new Intent(this,AppService.class);
		intent.putExtra(CUSTOM_RECEIVER, resultReceiver);
		startService(intent);
		
	}
	
	private final ResultReceiver resultReceiver = new ResultReceiver(new Handler()) {
		@Override
		protected void onReceiveResult(int resultCode, Bundle resultData) {
			String sample=resultData.getString("sample");
			Toast.makeText(getApplicationContext(), "susceesss  "+sample, 30).show();
		};
	};

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
}
