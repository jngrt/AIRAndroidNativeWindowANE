package com.jngrt.ane
{
	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	import flash.system.Capabilities;


	public class ANEWindowExtension
	{
	
		protected static var _dispatcher:EventDispatcher = new EventDispatcher();
		protected static var _context:ExtensionContext = null;

		public static function makeWindowFunction() : void
		{
			if( isSupported )
				context.call("makeWindowFunction");
			else
				trace("called ANEWindowExtension.makeWindowFunction\n");
		}
		
		public static function toast(text:String, showForLong:Boolean = false) : void
		{
			if( isSupported )
				context.call("toast", text, showForLong);
			else
				trace("called ANEWindowExtension.toast\n");
		}
		

		public static function dispose() : void
		{
			if(_context)
			{
				_context.removeEventListener(StatusEvent.STATUS, onStatusEventHandler);
				_context.dispose();
			}
			_context = null;
		}
		
		/////////////////////////////////////////
		// Event handling functions
		//
		
		public static function addEventListener(type:String, listener:Function) : void
		{
			_dispatcher.addEventListener(type, listener);
		}
		
		public static function removeEventListener(type:String, listener:Function) : void
		{
			_dispatcher.removeEventListener(type,listener);
		}
		
		
		
		
		/////////////////////////////////////////
		// Protected functions
		//
		
		protected static function get context() : ExtensionContext
		{
			if(!_context)
			{
				_context = ExtensionContext.createExtensionContext("com.jngrt.ane.anewindowextension","");
				_context.addEventListener(StatusEvent.STATUS, onStatusEventHandler);
			}
			return _context;
		}
		
		protected static function get isSupported() : Boolean
		{
			return (Capabilities.os.indexOf("Linux") >= 0);
		}
		
		
		/////////////////////////////////////////
		// Callbacks
		//
		
		protected static function onStatusEventHandler(event:StatusEvent) : void
		{
			if(event == null || event.code == null || event.level == null)
				return;
			
			trace("ANEWindowExtension, received status event. code:"+event.code+" level:"+event.level);
			// handle StatusEvent
			switch(event.code)
			{
				case ANEWindowExtensionEvent.TYPE_ERROR:
					_dispatcher.dispatchEvent(new ANEWindowExtensionEvent(ANEWindowExtensionEvent.TYPE_ERROR,event.level));
					break;
				case ANEWindowExtensionEvent.MESSAGE_FROM_WINDOW:
					_dispatcher.dispatchEvent(new ANEWindowExtensionEvent(ANEWindowExtensionEvent.MESSAGE_FROM_WINDOW,event.level));
					break;
			}
		}
	}
}