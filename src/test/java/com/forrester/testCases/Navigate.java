package com.forrester.testCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.forrester.base.Base;
import com.forrester.config.MobileAppConfiguration;
import com.forrester.pages.HomePage;
import com.forrester.pages.MobsPage;
import com.forrester.util.TestUtil;

@Listeners(MyTestResultListnerMobile.class)
public class Navigate
{
	public static MobileAppConfiguration config ;

@BeforeSuite
public static void beforetest() throws InterruptedException, IOException 
{
	
	config = new MobileAppConfiguration();
	config.setupMobileAppConfigForIOS();
}

@Test(priority=1,dataProvider="getData")
 public void navigateaction(Hashtable<String,String> data) throws InterruptedException, IOException 
 {

	// check the runmode of test case
	if(!TestUtil.isExecutable("Navigate",Base.xls1))
	 throw new SkipException("Runmode set to NO");
	
	// check runmode for data set
	if(!data.get("Runmode").equals("Y"))
		 throw new SkipException("Runmode set to NO for the data set");
    
	HomePage page = new HomePage(config.getDriveri());
	page.navigation();
	

}
@DataProvider
public Object[][] getData(){
	return TestUtil.getData("Navigate", Base.xls1);
}

}
 
				
