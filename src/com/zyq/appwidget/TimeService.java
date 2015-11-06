package com.zyq.appwidget;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

public class TimeService extends Service {

	Timer mTimer;
	SimpleDateFormat format;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mTimer = new Timer();
		mTimer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String timeStr = format.format(new Date());
				
				RemoteViews rv = new RemoteViews(getPackageName(), R.layout.widget);
				rv.setTextViewText(R.id.tv, timeStr);
				AppWidgetManager manager = AppWidgetManager.getInstance(getApplicationContext());
				ComponentName provider = new ComponentName(getApplicationContext(), MyAppWidgetProvider.class);
				
			
				manager.updateAppWidget(provider, rv);
				
				
			}
		}, 0, 1000);
		
		
		
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mTimer = null;
	}
	

}
