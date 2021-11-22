package com.mindtree.stepDefinations;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.pageObject.OfficialMerchandise;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class OfficialMerchandiseStepDef extends Base {
	WebDriver driver=null;
	OfficialMerchandise ofMer=null;
	public OfficialMerchandiseStepDef() throws UtilityException, Exception {
		super();
	}
	@Before("@OfficeMerchandise")
	public void init() throws Exception
	{
		log = Logger.getLogger(OfficialMerchandiseStepDef.class.getName());
		test = report.startTest("Officil Merchandise");
		driver=initialize();
		System.out.println("Officil Merchandise");
		ofMer=new OfficialMerchandise(driver, log, test);
	}

	@Given("Open Website URL for Official Merchandise")
	public void open_website_url_for_official_merchandise() throws IOException {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
	}

	@Then("Hover on  Official Merchandise drop down section")
	public void hover_on_official_merchandise_drop_down_section() {
	    ofMer.hoverMenu();
	}

	@Then("Select {string} from dropdown from Official Merchandise menu")
	public void select_from_dropdown_from_official_merchandise_menu(String menu) throws ReusableComponentException, Exception {
	  ofMer.clickMenu(menu);
	}

	@Then("select {string} of your choice from dropdown Menu result for Official Merchandise")
	public void select_of_your_choice_from_dropdown_menu_result_for_official_merchandise(String item) throws ReusableComponentException, Exception {
	    ofMer.clickItem(item);
	}

	@Then("Select {string} and add to cart for Official Merchandise gift")
	public void select_and_add_to_cart_for_official_merchandise_gift(String qunt) throws ReusableComponentException, Exception {
	    ofMer.setQuantity(qunt);
	}

	@Then("If cart page is Displayed Close it from Official Merchandise gift page")
	public void if_cart_page_is_displayed_close_it_from_official_merchandise_gift_page() throws ReusableComponentException, Exception {
	   ofMer.clickAddToCart();
	}
	@After("@OfficeMerchandise")
	public void setReport()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
