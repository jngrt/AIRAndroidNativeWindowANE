package com.jngrt.ane;

import com.adobe.fre.FREContext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class WindowCallbackReceiver extends BroadcastReceiver {
	public static final String TAG = ANEWindowExtension.TAG+".TestReceiver";
	
	private FREContext fcontext;
	
	public WindowCallbackReceiver(FREContext fcontext) {
		this.fcontext = fcontext;
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG,"received intent via broadcast");
		
		fcontext.dispatchStatusEventAsync("MESSAGE_FROM_WINDOW", intent.getStringExtra("message"));		
	}

}
