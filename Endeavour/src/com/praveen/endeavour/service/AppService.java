package com.praveen.endeavour.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;

import com.praveen.endeavour.util.AppConstants;

public class AppService extends IntentService implements AppConstants {

	public AppService() {
		super("AppService");

	}

	@Override
	protected void onHandleIntent(Intent intent) {

		Bundle bundle = new Bundle();
		bundle.putString("sample", "10");
		ResultReceiver receiver = intent.getParcelableExtra(CUSTOM_RECEIVER);
		receiver.send(0, bundle);

	}

	@Override
	public IBinder onBind(Intent intent) {
		return super.onBind(intent);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}

}
