package com.mindtree.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.HomeDecorUi;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class HomeDecor extends HomeDecorUi {
	WebDriver driver;
	Logger log;
	ExtentTest test;
	
	public HomeDecor(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
		}

	public void homeDecorClick()throws ReusableComponentException, Exception
	{
		WebDriverSupport.click(driver, HomeDecorButton, " Home page", "secretsanta button", log, test);
		Thread.sleep(2000);
	}
	public void clickItem(String item) throws ReusableComponentException, Exception
	{
		
		if(driver.findElement(header).isDisplayed() &&driver.findElement(header).getText().toLowerCase().contains("Home Decor".toLowerCase()))
		{
		List<WebElement>listRec=driver.findElements(result);
		for(WebElement temp:listRec)
		{
			if(temp.getText().equalsIgnoreCase(item))
			{
				WebDriverSupport.clickByWebElement(driver, temp,"result page",item, log, test);
				break;
			}
		}
		Thread.sleep(3000);
		}
		else
		{
			ExtentLogUtilities.fail(driver, test,"Page not opened", log);
			throw new PageObjectException("Page not opened");
		}
	}
	public void setQunt(String qunt) throws ReusableComponentException, Exception
	{
		if(driver.findElement(cart).isDisplayed())
		{
		WebDriverSupport.sendKeys(driver, quantity, "cart page", "quantity field", log, test,qunt);
		}
		else
		{
			ExtentLogUtilities.fail(driver, test,"cart Page not opened", log);
			throw new PageObjectException("cart Page not opened");
		}
	}
	public void clickAddToCart() throws ReusableComponentException, Exception
	{
		if(driver.findElement(cart).isDisplayed())
		{
		WebDriverSupport.click(driver, cart, "cart page", "cart button", log, test);
		Thread.sleep(3000);
		}
		else
		{
			ExtentLogUtilities.fail(driver, test,"cart Page not opened", log);
			throw new PageObjectException("cart Page not opened");
		}
	}
	public void HandelCartPage() throws ReusableComponentException, Exception
	{
		if(driver.findElement(formCart).isDisplayed())
		{
			WebDriverSupport.click(driver,close,"Cart slider Page","Close Button", log, test);
		}
		WebDriverSupport.click(driver,getHome,"cart page","Bigsmall pic", log, test);
		Thread.sleep(5000);
	}
}
