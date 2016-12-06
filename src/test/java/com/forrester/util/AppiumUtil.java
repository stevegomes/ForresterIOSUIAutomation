package com.forrester.util;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.IOException;

public final class AppiumUtil {
	AppiumDriverLocalService service;

	public String startAppiumServer() throws IOException, InterruptedException {

		String osName = System.getProperty("os.name").toLowerCase();

		String nodePath = null;
		String appiumPath = null;

		if (osName.contains("mac")) {
			// mac path
			nodePath = "/usr/local/bin/node";
			appiumPath = "/usr/local/lib/node_modules/appium/build/lib/main.js";
		} else if (osName.contains("linux")) {
			// / linux path
			nodePath = System.getenv("HOME") + "/.linuxbrew/bin/node";
			appiumPath = System.getenv("HOME")
					+ "/.linuxbrew/lib/node_modules/appium/build/lib/main.js";
		}
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						.usingDriverExecutable(new File(nodePath))
						.usingPort(4723).withAppiumJS(new File(appiumPath)));
		service.start();
		Thread.sleep(5000);

		return service.getUrl().toString();

	}

	public void stopAppiumServer() // how to stop appium server
	{
		service.stop();
	}
}
