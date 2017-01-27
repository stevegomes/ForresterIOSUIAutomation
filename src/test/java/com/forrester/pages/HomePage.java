package com.forrester.pages;

import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;

import com.forrester.base.Base;

public class HomePage extends Base
{
	IOSDriver driveri;
	
	public HomePage(IOSDriver driveri) throws IOException 
	{
		super(driveri);
	}
	
public  void navigation() throws InterruptedException 
	{
	
		     Thread.sleep(25000);
		     String text = text("onboardingtext");
		     System.out.println(text);
			 click("first_onboarding");
             click("second_onboarding");
			 click("third_onboarding");
			 click("on_tap");
		     click("enable_location");
		     Thread.sleep(5000);
		     click("allow_accesslocation");
		     Thread.sleep(3000);
		 
			 
	}
	
	
}
