package com.jngrt.ane;

import android.util.Log;
import android.widget.Toast;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class ToastFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		if(args == null || args.length < 1) {
			Log.e(ANEWindowExtension.TAG, "Invalid arguments number for ToastFunction! (requested: text, optional: duration type)");
			return null;
		}
		
		try{
			String text = args[0].getAsString();
			int toastType = Toast.LENGTH_SHORT;
			
			if(args.length == 2 && args[1].getAsBool())
				toastType = Toast.LENGTH_LONG;
			
			Toast.makeText(context.getActivity(), text, toastType).show();
		}
		catch(Exception e) {
			Log.e(ANEWindowExtension.TAG, "Error: "+e.getMessage(), e);
		}
		return null;
	}

}
