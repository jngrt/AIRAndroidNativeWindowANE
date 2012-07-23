package com.jngrt.ane;


import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class MakeWindowFunction implements FREFunction {

	public static final String TAG = ANEWindowExtension.TAG+".TestFunction";
	
	public FREObject call(FREContext context, FREObject[] args) {
		((ANEWindowExtensionContext) context).launchMakeWindowActivity();
		return null;
	}
}
