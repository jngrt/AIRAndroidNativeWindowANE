package com.jngrt.ane;


import android.util.Log;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;


public class ANEWindowExtension implements FREExtension {
	public static final String TAG = "ANEWindowExtension";
	
	private static FREContext myContext;
	
	public FREContext createContext(String arg0) {
		if( myContext != null ) return myContext;
		
		myContext = new ANEWindowExtensionContext();
		return myContext;
	}
	
	public void initialize() {
		Log.d(TAG, "Extension initialized.");
	}

	public void dispose() {
		Log.d(TAG, "Extension disposed.");
	}
}
