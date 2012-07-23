package com.jngrt.ane;

import java.util.HashMap;
import java.util.Map;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class ANEWindowExtensionContext extends FREContext {
	public static final String TAG = ANEWindowExtension.TAG+".AndroidExtensionsContext";
		
	private WindowCallbackReceiver receiver;
	
	@Override
	public void dispose() {
		Log.d(TAG,"Context disposed.");
	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
		functions.put("toast", new ToastFunction());
		functions.put("makeWindowFunction", new MakeWindowFunction());
		return functions;
	}

	public void launchMakeWindowActivity() {
		Log.d(TAG, "launchMakeWindowActivity() trying to start activity");
		
		startListener();
	
		//Intent testIntent = new Intent(getActivity(),MakeWindowActivity.class);
		Intent intent = new Intent();
		intent.setAction("com.jngrt.ane.MAKE_WINDOW");
		int resId =  this.getResourceId("layout.main");
		intent.putExtra("mainLayoutId",resId);
		
		try{
			this.getActivity().startActivity(intent);
			Log.d(TAG,"activity probably found...");
		}catch(ActivityNotFoundException e){
			Log.e(TAG, "activity not found!");
		}
		
				
	}
	public void startListener(){
		if(receiver == null){
			receiver = new WindowCallbackReceiver(this);
		}
		
		IntentFilter f = new IntentFilter();
		f.addAction(MakeWindowActivity.WINDOW_CALLBACK_INTENT);
		
		this.getActivity().registerReceiver(receiver,f);
		Log.d(TAG,"startListener, receiver registered");
	}
	
	
	
	
}