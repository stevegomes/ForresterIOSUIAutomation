package com.forrester.pages;

import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;

import org.testng.Assert;

import com.forrester.base.Base;

public class MobsPage extends Base
{
IOSDriver driveri;
	
   public MobsPage(IOSDriver driveri) throws IOException 
	{
		super(driveri);
		
	}

	public void MonPeopleSearch(String search,String expected) throws InterruptedException
	{
		click("goto_mobscreen");
		Thread.sleep(2000);
		click("switch_people");
		Thread.sleep(2000);
		tap(1, 8, 119, 2000);
		 Assert.assertEquals(text("mob_text"), expected);
		getthekeyboard1(search);
		Thread.sleep(2000);
		
	}
	
	public void MobPlacesSearch() throws InterruptedException
	
	{
		click("switch_places");
		Thread.sleep(3000);
		tap(1, 8, 119, 2000);
		getthekeyboard1("search_places");
		hidethekeyboard();
	}
	
	public void MobThingsSearch() throws InterruptedException
	{
		click("switch_thing");
		Thread.sleep(2000);
		tap(1, 8, 119, 2000);
		getthekeyboard1("search_thing");
		hidethekeyboard();
	}
	
}
