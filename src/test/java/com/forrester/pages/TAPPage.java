package com.forrester.pages;

import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;

import org.testng.Assert;

import com.forrester.base.Base;

public class TAPPage extends Base
{

IOSDriver driveri;
	public TAPPage(IOSDriver driveri) throws IOException 
	{
		super(driveri);
		
	}
	
	public void clicklove()
	{
		click("click_love");
		
	}
	
	public void clickok()
	{
		click("click_ok");
	}
	
	public void clickhate()
	{
		click("click_hate");
	}
	
	public void mobform(String placesearch,String description,String expectedtext) throws InterruptedException
	{
		for(int i=1 ;i<=5;i++)
		{
			click("click_love");
			
			try{
			if(isElementPresent("location_error"))
			{
			Assert.assertEquals(text("location_error"), expectedtext);
			
				click("cancel_button");
				Thread.sleep(2000);
				tap(1, 20, 36, 2000);
				Thread.sleep(2000);
				break;
			}
			}
			catch(Exception e)
			{
				e.getMessage();
			}

			 
			 try{
			 if(isElementPresent("cancel_searchonboarding"))
					 {
				 click("cancel_searchonboarding");
			 
					 }//this is the close button of search onboarding screen
			 }
			 catch (Exception e)
			 {
				 System.out.println(e.getMessage());
			 }
			 	
		 click("Place_search");
		
		 getthekeyboard2(placesearch);
		 Thread.sleep(3000);
		 tap(1, 30, 203, 2000);
		 Thread.sleep(3000);
		 click("whydidyoutap_descriptopn");
		 getthekeyboard3(description);
		 hidethekeyboard();
		 Thread.sleep(2000);
		 click("whydidyoutap_done");
		 Thread.sleep(10000);
		try{
		 if(isElementPresent("enable_push"))
		 {click("enable_push");
		 }}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		 Thread.sleep(4000);
		 try{
		 if(isElementPresent("allow_push"))
		 {
			 click("allow_push");
			 
		 }}
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
		 click("tap_screen");
		 
		 Thread.sleep(3000);
		 }
		}
	}


	


