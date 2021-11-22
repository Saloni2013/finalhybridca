package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.CorporateGiftsUi;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class CorporateGifts extends CorporateGiftsUi{


	WebDriver driver;
	Logger log;
	ExtentTest test;

	public CorporateGifts(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void clickCorporate()throws ReusableComponentException, Exception
	{
		WebDriverSupport.click(driver, corporateButton,"Home Page","Corporate Button", log, test);
		Thread.sleep(2000);
	}
	public void fillDetails(String name,String Gmail,String phno) throws ReusableComponentException, Exception
	{
		if(driver.findElement(header).isDisplayed() &&driver.findElement(header).getText().toLowerCase().contains("Corporate Gifts".toLowerCase()))
		{
			Thread.sleep(2000);
			WebDriverSupport.sendKeys(driver, fname,"Corporate gift form", "name", log, test, name);
			WebDriverSupport.sendKeys(driver,email, "Corporate gift form", "email", log, test, Gmail);
			WebDriverSupport.sendKeys(driver,phn, "Corporate gift form","phone no", log, test, phno);
		}
		else
		{
			ExtentLogUtilities.fail(driver, test,"Page not opened", log);
			throw new PageObjectException("Page not opened");
		}
	}
	public void submitForm()throws ReusableComponentException, Exception
	{
		if(driver.findElement(header).isDisplayed() &&driver.findElement(header).getText().toLowerCase().contains("Corporate Gifts".toLowerCase()))
		{
		WebDriverSupport.click(driver, submit,"Corporate Page","Submit Button", log, test);
		Thread.sleep(2000);
		}
		else
		{
			ExtentLogUtilities.fail(driver, test,"Page not opened", log);
			throw new PageObjectException("Page not opened");
		}
	}


}
