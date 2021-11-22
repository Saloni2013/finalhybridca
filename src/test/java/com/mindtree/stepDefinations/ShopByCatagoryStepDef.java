package com.mindtree.stepDefinations;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.pageObject.ShopByCatagory;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class ShopByCatagoryStepDef extends Base {
	WebDriver driver=null;
	ShopByCatagory shopcat=null;
	public ShopByCatagoryStepDef() throws UtilityException, Exception {
		super();
	}
	@Before("@ShopByCatagory")
	public void init() throws Exception
	{
		log = Logger.getLogger(ShopByCatagoryStepDef.class.getName());
		test = report.startTest("Shop By Catagory");
		driver=initialize();
		System.out.println("Shop By Catagory");
		shopcat=new ShopByCatagory(driver, log, test);
	}

	@Given("Open Website URL for Shop By Catagory")
	public void open_website_url_for_shop_by_catagory() throws IOException {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
	}

	@Then("Hover on  Shop By Catagory drop down section")
	public void hover_on_shop_by_catagory_drop_down_section() {
	   shopcat.hoverMenu();
	}

	@Then("Select {string} from dropdown from Shop By Catagory menu")
	public void select_from_dropdown_from_shop_by_catagory_menu(String menu) throws ReusableComponentException, Exception {
	   shopcat.clickMenu(menu);
	}

	@Then("select {string} of your choice from dropdown Menu result for Shop By Catagory")
	public void select_of_your_choice_from_dropdown_menu_result_for_shop_by_catagory(String item) throws ReusableComponentException, Exception {
	   shopcat.clickItem(item);
	}

	@Then("Select {string} and add to cart for Shop By Catagory gift")
	public void select_and_add_to_cart_for_shop_by_catagory_gift(String qunt) throws ReusableComponentException, Exception {
	    shopcat.setQuantity(qunt);
	}

	@Then("If cart page is Displayed Close it from Shop By Catagory gift page")
	public void if_cart_page_is_displayed_close_it_from_shop_by_catagory_gift_page() throws ReusableComponentException, Exception {
	  shopcat.handelCart();
	}
	@After("@ShopByCatagory")
	public void setReport()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
