package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.HomePageLogInUi;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePageLogIn extends HomePageLogInUi{

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public HomePageLogIn(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void clickLoginButton()throws ReusableComponentException, Exception
	{
		WebDriverSupport.click(driver,logInButton,"Home Page","Log In Button", log, test);
		Thread.sleep(5000);
	}
	public void loginForm(String Uid,String Pw) throws ReusableComponentException, Exception
	{
		if(driver.findElement(header).isDisplayed() &&driver.findElement(header).getText().toLowerCase().contains("LogIn".toLowerCase()))
		{
		WebDriverSupport.sendKeys(driver,email,"Account Log in","Email field", log, test, Uid);
		WebDriverSupport.sendKeys(driver,pass,"Account Log in","password field", log, test, Pw);
		}
		else
		{
			ExtentLogUtilities.fail(driver, test,"Page not opened", log);
			throw new PageObjectException("Page not opened");
		}
	}
	public void login() throws PageObjectException,Exception
	{
		if(driver.findElement(header).isDisplayed() &&driver.findElement(header).getText().toLowerCase().contains("Log In".toLowerCase()))
		{
		WebDriverSupport.click(driver,signin, "Account Log in","sign in button", log, test);
		Thread.sleep(2000);
		}
		else
		{
			ExtentLogUtilities.fail(driver, test,"Page not opened", log);
			throw new PageObjectException("Page not opened");
		}
	}
	public void validate() throws PageObjectException
	{
		try {
			if(driver.findElements(myAcc).size()>0)
			{
				ExtentLogUtilities.pass(driver, test,"Successfully logged in", log);
				WebDriverSupport.click(driver,getHome,"cart page","Bigsmall pic", log, test);
			}
			else
			{
				ExtentLogUtilities.fail(driver, test,"logged in failed", log);
				WebDriverSupport.click(driver,getHome,"cart page","Bigsmall pic", log, test);
				throw new PageObjectException("Logged in failed");
			}
			}
			catch(Exception e)
			{
				throw new PageObjectException(e.getMessage());
			}
	}
}
