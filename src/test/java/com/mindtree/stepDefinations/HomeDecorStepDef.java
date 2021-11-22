package com.mindtree.stepDefinations;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.pageObject.HomeDecor;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class HomeDecorStepDef extends Base {
	public WebDriver driver=null;
	HomeDecor homdecr=null;
	public HomeDecorStepDef() throws UtilityException, Exception {
		super();
	}
	@Before("@HomeDecor")
	public void init() throws Exception
	{
		log = Logger.getLogger(HomeDecorStepDef.class.getName());
		test = report.startTest("Home decor");
		driver=initialize();
		System.out.println("Home decor");
		homdecr=new HomeDecor(driver, log, test);
	}
	@Given("Open  Website with URL")
	public void open_website_with_url() throws IOException {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
	}

	@Then("Click on HomeDecor Gift section")
	public void click_on_home_decor_gift_section() throws  Exception {
	   homdecr.homeDecorClick();
	}

	@Then("Click on {string} in HomeDecor result")
	public void click_on_in_home_decor_result(String item) throws  Exception {
	   homdecr.clickItem(item);
	}

	@Then("select {string} of HomeDecor gift")
	public void select_of_home_decor_gift(String qunt) throws  Exception {
	    homdecr.setQunt(qunt);
	}

	@Then("Click on Add to Cart Button For HomeDecor Gift")
	public void click_on_add_to_cart_button_for_home_decor_gift() throws Exception {
	   homdecr.clickAddToCart();
	}

	@Then("If cart page is Displayed for For HomeDecor Gift Close it")
	public void if_cart_page_is_displayed_for_for_home_decor_gift_close_it() throws Exception {
	    homdecr.HandelCartPage();
	}
	@After("@HomeDecor")
	public void setReport()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
