package com.forrester.testCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Hashtable;

import io.appium.java_client.ios.IOSDriver;

import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.forrester.base.Base;
import com.forrester.config.MobileAppConfiguration;
import com.forrester.pages.HomePage;
import com.forrester.pages.TAPPage;
import com.forrester.util.TestUtil;

@Listeners(MyTestResultListnerMobile.class)
public class Mobformation 
{


	@Test(priority=3,dataProvider="getData")
	
	public void checkmobformation(Hashtable<String,String> data) throws InterruptedException, IOException
	{

		// check the runmode of test case
		if(!TestUtil.isExecutable("Mobformation",Base.xls1))
		 throw new SkipException("Runmode set to NO");
		
		// check runmode for data set
		if(!data.get("Runmode").equals("Y"))
			 throw new SkipException("Runmode set to NO for the data set");
		
		TAPPage tape = new TAPPage(Navigate.config.getDriveri());
		
		tape.mobform(data.get("PlaceSearch"),data.get("Description"),data.get("Text"));
		
		
	}
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getData("Mobformation", Base.xls1);
	}
	

}
