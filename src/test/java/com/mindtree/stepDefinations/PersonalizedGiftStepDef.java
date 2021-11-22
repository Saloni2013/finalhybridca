package com.mindtree.stepDefinations;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.pageObject.PersonalizedGifts;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class PersonalizedGiftStepDef extends Base {
	WebDriver driver=null;
	PersonalizedGifts personalz=null;
	public PersonalizedGiftStepDef() throws UtilityException, Exception {
		super();
	}
	@Before("@Personalized")
	public void init() throws Exception
	{
		log = Logger.getLogger(PersonalizedGiftStepDef.class.getName());
		test = report.startTest("Personalized gifts");
		driver=initialize();
		System.out.println("Personalized gifts");
		personalz=new PersonalizedGifts(driver, log, test);
	}

	@Given("Open  Website URL for personalized gifts")
	public void open_website_url_for_personalized_gifts() throws IOException {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
	}

	@Then("Click on Peronalized Gift section")
	public void click_on_peronalized_gift_section() throws ReusableComponentException, Exception {
		personalz.personalizedButton();
	}

	@Then("Click on desired {string}")
	public void click_on_desired(String item) throws ReusableComponentException, Exception {
		personalz.clickItem(item);
	}

	@Then("select {string} and add {string}")
	public void select_and_add(String qunt, String name) throws ReusableComponentException, Exception {
		personalz.setData(qunt, name);
	}

	@Then("Click on Add to Cart Button in personalized gift cart")
	public void click_on_add_to_cart_button_in_personalized_gift_cart() throws ReusableComponentException, Exception {
		personalz.clickAddToCart();
	}

	@Then("If cart page is Displayed Close it after personalized gift")
	public void if_cart_page_is_displayed_close_it_after_personalized_gift() throws ReusableComponentException, Exception {
	    personalz.HandelCartPage();
	}
	@After("@Personalized")
	public void setReport()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
