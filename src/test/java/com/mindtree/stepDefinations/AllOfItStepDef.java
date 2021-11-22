package com.mindtree.stepDefinations;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.*;
import com.mindtree.pageObject.*;
import com.mindtree.reusableComponent.*;
import com.mindtree.utilities.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class AllOfItStepDef extends Base {
	public WebDriver driver=null;
	AllOfIt alf;
	public AllOfItStepDef() throws UtilityException, Exception {
		super();
	}
	@Before("@AllOfIt")
	public void init() throws Exception
	{
		log = Logger.getLogger(AllOfItStepDef.class.getName());
		test = report.startTest("All Of It");
		driver=initialize();
		System.out.println("All of it");
		alf=new AllOfIt(driver, log, test);
	}
	@Given("Open  Website with URl  All of it")
	public void open_website_with_u_rl_all_of_it() throws IOException {
		
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
	}

	@Then("Click on  All of it  Gift section")
	public void click_on_all_of_it_gift_section()throws Exception {
		alf.allOfItClick();
	}

	@Then("Click on {string} in  All of it  result")
	public void click_on_in_all_of_it_result(String item)throws Exception {
		alf.clickItem(item);
	}

	@Then("select {string} of  All of it  gift")
	public void select_of_all_of_it_gift(String qunt)throws Exception {
		alf.setQunt(qunt);
	}

	@Then("Click on Add to Cart Button For  All of it  Gift")
	public void click_on_add_to_cart_button_for_all_of_it_gift()throws Exception {
		alf.clickAddToCart();
	}

	@Then("If cart page is Displayed for For  All of it  Gift Close it")
	public void if_cart_page_is_displayed_for_for_all_of_it_gift_close_it()throws Exception {
		alf.HandelCartPage();
	}
	@After("@AllOfIt")
	public void setReport()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
		//driver.close();
	}
	
	
}
