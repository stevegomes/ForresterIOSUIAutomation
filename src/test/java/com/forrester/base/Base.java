package com.forrester.base;
import io.appium.java_client.ios.IOSDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.forrester.util.Xls_Reader;

public class Base {
	static IOSDriver driver;
	public static Xls_Reader xls1= new Xls_Reader(System.getProperty("user.dir")+"/src/test/java/com/forrester/xls/TestCasesForrester.xlsx");
	

	Properties OR = new Properties();

	public Base(IOSDriver driveri) throws IOException {
		this.driver = driveri;

		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+ "/src/test/java/com/forrester/config/OR.properties");
			OR.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}



	/////These are all the custom function//////
	// tap
	public void tap(int fingers, int x, int y, int duration) {
		try {
			driver.tap(fingers, x, y, duration);
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
			// report error
		}
	}

	// getkeyboard1
	public void getthekeyboard1(String search) 
	{
		WebElement ele1 = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAWebView[1]/UIATextField[1]"));
		driver.getKeyboard().sendKeys(search);
		
		ele1.clear();
		}
	//getkeyboard2
	public void getthekeyboard2(String search) 
	{
		//WebElement ele2 = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIATextField[1]/UIATextField[1]"));

		
		driver.getKeyboard().sendKeys(search);
		
		//ele2.clear();
	
	}
	//getkeyboard3
	public void getthekeyboard3(String description) 
	{

		//WebElement ele3 = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[4]/UIATextField[1]"));
		driver.getKeyboard().sendKeys(description);
		
		//ele3.clear();
	
	}
	// hidekeyboard
	public void hidethekeyboard() {
		driver.hideKeyboard();

	}

	// click
	public void click(String xpathKey) {
		try {
			driver.findElement(By.xpath(OR.getProperty(xpathKey))).click();
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
			// report error
		}
	}

	// inputtext
	public void input(String xpathKey, String text) {
		try {
			driver.findElement(By.xpath(OR.getProperty(xpathKey))).sendKeys(
					text);
		} catch (Exception e) {
			// report error
			e.printStackTrace();
		}
	}

	// verification
	public boolean isElementPresent(String xpathKey) {
		try {
			driver.findElement(By.xpath(OR.getProperty(xpathKey)));
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	// finds the link on page
	public boolean isLinkPresent(String linkText) {
		try {
			driver.findElement(By.linkText(linkText));
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public String text(String xpathkey)// gettext
	{
		// WebDriverWait wait = new WebDriverWait (driver,10);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty(xpathkey))));

		String actual_text = driver.findElement(By.xpath(OR.getProperty(xpathkey))).getText();
		return actual_text;
		//System.out.println("Actual text is:" + actual_text);
		// Assert.assertEquals(actual_text,expected );
	}

	public static void takeScreenshot() 
	{
		// fileName of the screenshot
	Date d=new Date();
	String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
				// store screenshot in that file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+ "/screenshots/" + screenshotFile));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
