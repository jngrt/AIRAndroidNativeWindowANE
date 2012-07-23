package com.jngrt.ane;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
//import android.widget.Toast;

public class MakeWindowActivity extends Activity {
	public static final String TAG = ANEWindowExtension.TAG+".TestActivity";
	public static final String WINDOW_CALLBACK_INTENT = "com.jngrt.ane.WINDOW_CALLBACK_INTENT";
	
	  @Override
	    public void onCreate(Bundle savedInstanceState) 
	    {
		  	Log.w(TAG, "MakeWindowActivity.onCreate called");
	        super.onCreate(savedInstanceState);
	        
	        int lres = getIntent().getIntExtra("mainLayoutId",0);
	        //setContentView(R.layout.main);
	        setContentView(lres);
	        
	        
	        Context context = getApplicationContext();
	        //CharSequence text = "Hello toast!";
	        //int duration = Toast.LENGTH_LONG;

	        //Toast toast = Toast.makeText(context, text, duration);
	        //toast.show();
	        
	        Intent i = new Intent();
	        i.setAction(WINDOW_CALLBACK_INTENT);
	        i.putExtra("message", "message from new window");
	        context.sendBroadcast(i);
	        
	        Log.d(TAG, "MakeWindowActivity, broadcast sent");	      
	    }
}
