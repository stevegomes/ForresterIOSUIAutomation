package com.forrester.testCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.forrester.base.Base;
import com.forrester.config.MobileAppConfiguration;
import com.forrester.pages.MobsPage;
import com.forrester.util.TestUtil;


@Listeners(MyTestResultListnerMobile.class)
public class MobSearch{


	@Test(priority=2,dataProvider="getData")
	public void searchMob(Hashtable<String,String> data) throws InterruptedException, IOException
	{
		
		
			// check the runmode of test case
			if(!TestUtil.isExecutable("MobSearch",Base.xls1))
			 throw new SkipException("Runmode set to NO");
			
			// check runmode for data set
			if(!data.get("Runmode").equals("Y"))
				 throw new SkipException("Runmode set to NO for the data set");
         
		  MobsPage pagemob  = new MobsPage(Navigate.config.getDriveri());
		  pagemob.MonPeopleSearch(data.get("PeopleSearch"),data.get("ExpectedText"));
		  
		 
	}

	@DataProvider
		public Object[][] getData(){
			return TestUtil.getData("MobSearch", Base.xls1);
		}
	
	@AfterSuite
	public void teardown() throws InterruptedException
	{

		MobileAppConfiguration app = new MobileAppConfiguration();
		//app.startappiumserver();
		//driveri.quit();
		
	}
}
  
	

