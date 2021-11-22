package com.mindtree.stepDefinations;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.pageObject.HomeAndLifeStyle;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class HomeAndLifeStyleStepDef extends Base {

	public WebDriver driver=null;
	HomeAndLifeStyle homlyf=null;
	public HomeAndLifeStyleStepDef() throws UtilityException, Exception {
		super();
	}
	@Before("@HomeAndLifestyle")
	public void init() throws Exception
	{
		log = Logger.getLogger(HomeAndLifeStyleStepDef.class.getName());
		test = report.startTest("Home And Lifestyle");
		driver=initialize();
		System.out.println("Corporate Gifts");
		homlyf=new HomeAndLifeStyle(driver, log, test);
	}
	@Given("Open Website URL for Home And Lifestyle")
	public void open_website_url_for_home_and_lifestyle() throws IOException {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
	}

	@Then("Hover on  Home And Lifestyle drop down section")
	public void hover_on_home_and_lifestyle_drop_down_section() {
	   homlyf.hoverMenu();
	}

	@Then("Select {string} from dropdown from Home And Lifestyle menu")
	public void select_from_dropdown_from_home_and_lifestyle_menu(String menu) throws Exception {
	    homlyf.clickMenu(menu);
	}

	@Then("select {string} of your choice from dropdown Menu result for Home And Lifestyle")
	public void select_of_your_choice_from_dropdown_menu_result_for_home_and_lifestyle(String item) throws Exception {
	   homlyf.clickItem(item);
	}

	@Then("Select {string} and add to cart for Home And Lifestyle gift")
	public void select_and_add_to_cart_for_home_and_lifestyle_gift(String qunt) throws Exception {
	    homlyf.setQuantity(qunt);
	    homlyf.clickAddToCart();
	}

	@Then("If cart page is Displayed Close it from Home And Lifestyle gift page")
	public void if_cart_page_is_displayed_close_it_from_home_and_lifestyle_gift_page() throws  Exception {
	   homlyf.handelCart();
	}
	@After("@HomeAndLifestyle")
	public void setReport()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
