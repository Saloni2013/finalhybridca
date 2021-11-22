package com.mindtree.stepDefinations;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.pageObject.WhatsNew;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class WhatsNewStepDef extends Base {
	WebDriver driver=null;
	WhatsNew whatnw=null;
	public WhatsNewStepDef() throws UtilityException, Exception {
		super();
	}
	@Before("@WhatsNew")
	public void init() throws Exception
	{
		log = Logger.getLogger(WhatsNewStepDef.class.getName());
		test = report.startTest("What's New gift");
		driver=initialize();
		System.out.println("What's New gift");
		whatnw=new WhatsNew(driver, log, test);
	}

	@Given("Open Website URL for WhatsNew")
	public void open_website_url_for_whats_new() throws IOException {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
	}

	@Then("click on WhatsNew  Gift section")
	public void click_on_whats_new_gift_section() throws ReusableComponentException, Exception {
	    whatnw.whatsNewClick();
	}

	@Then("Click on {string} from list of products shown for WhatsNew")
	public void click_on_from_list_of_products_shown_for_whats_new(String item) throws ReusableComponentException, Exception {
	    whatnw.clickItem(item);
	}

	@Then("select {string} of product for WhatsNew item")
	public void select_of_product_for_whats_new_item(String qunt) throws ReusableComponentException, Exception {
	    whatnw.setQunt(qunt);
	}

	@Then("Click on Add to Cart Button for WhatsNew Operation")
	public void click_on_add_to_cart_button_for_whats_new_operation() throws ReusableComponentException, Exception {
	    whatnw.clickAddToCart();
	}

	@Then("If cart page is Displayed Close it for WhatsNew Page")
	public void if_cart_page_is_displayed_close_it_for_whats_new_page() throws ReusableComponentException, Exception {
	   whatnw.HandelCartPage();
	}
	@After("@WhatsNew")
	public void setReport()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
