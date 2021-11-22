package com.mindtree.stepDefinations;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.pageObject.Gifts;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class GiftsStepDef extends Base {
	public GiftsStepDef() throws UtilityException, Exception {
		super();
	}

	public WebDriver driver=null;
	Gifts gifts=null;
	
	@Before("@Gifts")
	public void init() throws Exception
	{
		log = Logger.getLogger(GiftsStepDef.class.getName());
		test = report.startTest("Gifts");
		driver=initialize();
		System.out.println("Gifts");
		gifts=new Gifts(driver, log, test);
	}
	@Given("Open Website URL for Gifts")
	public void open_website_url_for_gifts()  throws IOException {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
	}

	@Then("Hover on  Gift drop down section")
	public void hover_on_gift_drop_down_section() {
	   gifts.hoverMenu();
	}

	@Then("Select {string} from dropdown from gifts menu")
	public void select_from_dropdown_from_gifts_menu(String menu) throws  Exception {
	   gifts.clickMenu(menu);
	}

	@Then("select {string} of your choice from dropdown Menu result")
	public void select_of_your_choice_from_dropdown_menu_result(String item) throws Exception {
	    gifts.clickItem(item);
	}

	@Then("Select {string} and add to cart for gift")
	public void select_and_add_to_cart_for_gift(String qunt) throws Exception {
	   gifts.setQuantity(qunt);
	}

	@Then("If cart page is Displayed Close it from gift page")
	public void if_cart_page_is_displayed_close_it_from_gift_page() throws  Exception {
	   gifts.clickAddToCart();
	}
	@After("@Gifts")
	public void setReport()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
