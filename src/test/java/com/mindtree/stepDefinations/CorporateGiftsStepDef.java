package com.mindtree.stepDefinations;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.pageObject.CorporateGifts;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class CorporateGiftsStepDef extends Base {
	public CorporateGiftsStepDef() throws UtilityException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver=null;
	CorporateGifts cogifts=null;
	
	@Before("@CorporateGifts")
	public void init() throws Exception
	{
		log = Logger.getLogger(CorporateGiftsStepDef.class.getName());
		test = report.startTest("Corporate Gift");
		driver=initialize();
		System.out.println("Corporate Gifts");
		cogifts=new CorporateGifts(driver, log, test);
	}
	@Given("Open URL for corporate gifts")
	public void open_url_for_corporate_gifts()  throws IOException {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
	}

		@Then("Click on Corporate Gift section")
		public void click_on_corporate_gift_section() throws Exception {
		   cogifts.clickCorporate();
		}

	@Then("Add {string} {string} {string} in the form")
	public void add_in_the_form(String name, String phn, String email) throws ReusableComponentException, Exception {
	    cogifts.fillDetails(name, email, phn);
	}

	@Then("click on Submit Button")
	public void click_on_submit_button() throws ReusableComponentException, Exception {
	    cogifts.submitForm();
	}
	@After("@CorporateGifts")
	public void setReport()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
