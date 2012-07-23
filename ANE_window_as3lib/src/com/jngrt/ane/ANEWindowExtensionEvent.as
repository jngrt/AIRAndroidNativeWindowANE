package com.jngrt.ane
{
	import flash.events.Event;
	
	public class ANEWindowExtensionEvent extends Event
	{
		public static const TYPE_ERROR:String = "error";
		public static const MESSAGE_FROM_WINDOW:String = "MESSAGE_FROM_WINDOW";
		
		public var message:String;
		
		public function ANEWindowExtensionEvent(type:String, message:String, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			this.message = message;
			super(type, bubbles, cancelable);
		}
		
		override public function clone():Event
		{
			return new ANEWindowExtensionEvent(this.type, this.message, this.bubbles, this.cancelable);
		}
		
		
	}
}