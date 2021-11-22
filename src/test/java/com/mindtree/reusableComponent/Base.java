package com.mindtree.reusableComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.utilities.GetProperties;

public class Base extends GetProperties{
	protected static Logger log;
	protected static ExtentTest test;
	protected static ExtentReports report;
	public Base() throws UtilityException, Exception {
		super();
	}

	
	public static void initializeReport()
	{
		if(report==null)
		report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\" + "ExtentReportResults-"
				+ System.currentTimeMillis() + "-.html");
	}
	public static WebDriver initialize() throws Exception {
		WebDriver driver=null;
		if (driver == null) {
			if (get.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + get.getProperty("path"));
				ChromeOptions opt = new ChromeOptions();
				opt.addArguments("--disable-notifications");
				 driver = new ChromeDriver(opt);
			} else if (get.getProperty("browser").equals("firefox")) {

			} else if (get.getProperty("browser").equals("IE")) {

			}
		}
		return driver;
	}
}
