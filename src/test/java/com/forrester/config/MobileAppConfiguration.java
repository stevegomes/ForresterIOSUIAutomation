package com.forrester.config;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.forrester.base.Base;
import com.forrester.testCases.Mobformation;
import com.forrester.util.AppiumUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileAppConfiguration {

	// Create global variable

	AndroidDriver drivera;
	IOSDriver driveri;
	static AppiumDriverLocalService service;
	static String service_url;

	// Method to setup the desired capabilities for mobile Application
	// configuration - Android
	@SuppressWarnings("rawtypes")
	public AndroidDriver setupMobileAppConfigForAndroid(String devicename,
			String platformversion, String platformname, String apppackage,
			String appactivity) throws MalformedURLException,
			InterruptedException {
		new MobileAppConfiguration();
		DesiredCapabilities capa = new DesiredCapabilities();

		capa.setCapability("deviceName", devicename);
		capa.setCapability("platformVersion", platformversion);
		capa.setCapability("platformName", platformname);
		capa.setCapability("appPackage", apppackage);
		capa.setCapability("appActivity", appactivity);

		URL url = new URL(service_url);
		drivera = new AndroidDriver(url, capa);
		return drivera;
	}

	// Method to setup the desired capabilities for mobile web application
	// configuration - Android
	@SuppressWarnings("rawtypes")
	public AndroidDriver setupMobileWebAppConfigForAndroid()
			throws MalformedURLException, InterruptedException {

		DesiredCapabilities capa = new DesiredCapabilities();
		capa.setCapability(MobileCapabilityType.PLATFORM_NAME,
				MobilePlatform.ANDROID);
		capa.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		capa.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		// set the android version as well
		// Create object of URL class and specify the appium server address
		URL url = new URL(service_url);

		drivera = new AndroidDriver(url, capa);
		return drivera;
	}

	// Method to setup the desired capabilities for mobile web application
	// configuration - iOS
	@SuppressWarnings("rawtypes")
	public IOSDriver setupMobileWebAppConfigForIOS()
			throws MalformedURLException, InterruptedException {

		DesiredCapabilities capa = new DesiredCapabilities();
		capa.setCapability(MobileCapabilityType.PLATFORM_NAME,
				MobilePlatform.IOS);
		capa.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
		capa.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		// set the android version as well

		// Create object of URL class and specify the appium server address
		URL url = new URL(service_url);

		driveri = new IOSDriver(url, capa);
		return driveri;
	}

	// Method to setup the desired capabilities for mobile app application
	// configuration - iOS
	@SuppressWarnings("rawtypes")
	public IOSDriver setupMobileAppConfigForIOS() throws InterruptedException,
			IOException {
		AppiumUtil appiumUtil = new AppiumUtil();
		String url = appiumUtil.startAppiumServer();
		String currentpath = System.getProperty("user.dir") + "/Apps";
		File appDir = new File(currentpath);
		File app = new File(appDir, "Forrester_TAP.app");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "iPhone 6");
		capabilities.setCapability("platformVersion", "9.3");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("app", app.getAbsolutePath());
		driveri = new IOSDriver(new URL(url), capabilities);
		return driveri;
	}

	public IOSDriver getDriveri() {
		return driveri;
	}

}