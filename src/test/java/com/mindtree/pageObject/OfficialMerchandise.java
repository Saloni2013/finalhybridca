package com.mindtree.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.OfficialMerchandiseUi;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.ExtentTest;

public class OfficialMerchandise extends OfficialMerchandiseUi {

	WebDriver driver;
	Logger log;
	ExtentTest test;
	private String type;

	public OfficialMerchandise(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void hoverMenu()
	{
		new Actions(driver).moveToElement(driver.findElement(OfficialMerchandiseButton)).build().perform();
	}
	public void clickMenu(String type) throws ReusableComponentException, Exception
	{
		
		this.type=type;
		List<WebElement>menu=driver.findElements(dropDown);
		boolean b=false;
		for(WebElement temp:menu)
		{
			System.out.println(temp.getText());
			if(temp.getText().equalsIgnoreCase(type))
			{
				b=true;
				WebDriverSupport.clickByWebElement(driver, temp,"Home Page",type, log, test);
				break;
			}
		}
		Thread.sleep(3000);
		if(!b)
		{
			ExtentLogUtilities.fail(driver, test,"Option not found", log);
			throw new PageObjectException("Option not found");
		}
	}
	public void clickItem(String item) throws ReusableComponentException, Exception {
		if(driver.findElement(header).isDisplayed() &&driver.findElement(header).getText().toLowerCase().contains(type.toLowerCase()))
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
	public void setQuantity(String qunt) throws ReusableComponentException, Exception
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
	public void handelCart() throws ReusableComponentException, Exception
	{
		if(driver.findElement(formCart).isDisplayed())
		{
			WebDriverSupport.click(driver,close,"Cart Page","Close Button", log, test);
		}
		WebDriverSupport.click(driver,getHome,"cart page","Bigsmall pic", log, test);
		Thread.sleep(5000);
	}
}
